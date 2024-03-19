package commands;

import utils.Console;

/**
 * Abstract class for a command that uses console input/output.
 *
 * @author AlanTheKnight
 */
public abstract class ConsoleCommand extends Command {
    /**
     * Console to use for input/output.
     */
    protected final Console console;

    /**
     * Constructor.
     *
     * @param name          name of the command
     * @param description   description of the command
     * @param commandFormat format of the command
     * @param console       console
     */
    public ConsoleCommand(String name, String description, String commandFormat, Console console) {
        super(name, description, commandFormat);
        this.console = console;
    }

    /**
     * Constructor.
     *
     * @param name          name of the command
     * @param description   description of the command
     * @param commandFormat format of the command
     * @param console       console
     * @param argsCount     number of arguments
     */
    public ConsoleCommand(String name, String description, String commandFormat, Console console, int argsCount) {
        super(name, description, commandFormat, argsCount);
        this.console = console;
    }
}
