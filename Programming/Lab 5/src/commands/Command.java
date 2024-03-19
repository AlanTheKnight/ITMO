package commands;

import utils.Console;
import utils.Describable;
import utils.Executable;

/**
 * Abstract class for a command.
 *
 * @author AlanTheKnight
 */
public abstract class Command implements Describable, Executable {
    /**
     * Name of the command.
     */
    private final String name;
    /**
     * Description of the command.
     */
    private final String description;
    /**
     * Format of the command (for usage message).
     */
    private final String commandFormat;
    /**
     * Number of arguments.
     */
    private final int argsCount;

    /**
     * Constructor.
     *
     * @param name          name of the command
     * @param description   description of the command
     * @param commandFormat format of the command
     */
    public Command(String name, String description, String commandFormat) {
        this.name = name;
        this.description = description;
        this.commandFormat = commandFormat;
        this.argsCount = commandFormat.split(" ").length - 1;
    }

    /**
     * Constructor.
     *
     * @param name          name of the command
     * @param description   description of the command
     * @param commandFormat format of the command
     * @param argsCount     number of arguments
     */
    public Command(String name, String description, String commandFormat, int argsCount) {
        this.name = name;
        this.description = description;
        this.commandFormat = commandFormat;
        this.argsCount = argsCount;
    }

    /**
     * Get the number of arguments.
     */
    public int getArgsCount() {
        return argsCount;
    }

    /**
     * Get the name of the command.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Get the description of the command.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the format of the command.
     */
    public String getCommandFormat() {
        return commandFormat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        Command command = (Command) obj;
        return name.equals(command.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", commandFormat='" + commandFormat + '\'' +
                '}';
    }

    /**
     * Print the arguments error message.
     *
     * @param console console
     */
    public void printArgsError(Console console) {
        console.printError("Неверный формат аргументов.");
        console.println("Использование: " + getCommandFormat());
    }

    /**
     * Run the command, performing arguments number check and execution.
     *
     * @param arguments arguments of the command
     * @param console   console
     * @return true if the command was successful, false otherwise
     */
    public boolean run(String[] arguments, Console console) {
        try {
            checkArguments(arguments);
            return execute(arguments);
        } catch (IllegalArgumentsNumber e) {
            console.printError(e.getMessage());
            console.println("Использование: " + getCommandFormat());
            return false;
        }
    }

    /**
     * Check the number of arguments.
     *
     * @param arguments arguments
     * @throws IllegalArgumentsNumber if the number of arguments is incorrect
     */
    public void checkArguments(String[] arguments) throws IllegalArgumentsNumber {
        if (arguments.length != getArgsCount()) {
            throw new IllegalArgumentsNumber("Неверное количество аргументов. Ожидается аргументов: " + getArgsCount());
        }
    }

    /**
     * Exception for illegal number of arguments.
     */
    public static class IllegalArgumentsNumber extends Exception {
        public IllegalArgumentsNumber(String message) {
            super(message);
        }
    }

}
