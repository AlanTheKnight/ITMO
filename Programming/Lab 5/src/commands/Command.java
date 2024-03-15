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
     * Print the invalid arguments message.
     * 
     * @param console console
     */
    public void printInvalidArgs(Console console) {
        console.printError("Неверное количество аргументов.");
        console.println("Использование: " + getCommandFormat());
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
}
