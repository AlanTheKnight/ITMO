package commands;

import managers.CommandManager;
import utils.Console;

/**
 * Abstract class for a command that uses console input/output and the command
 * manager.
 *
 * @author AlanTheKnight
 */
public abstract class ConsoleCmdCommand extends ConsoleCommand {
    /**
     * Command manager.
     */
    protected final CommandManager commandManager;

    /**
     * Constructor.
     *
     * @param name           name of the command
     * @param description    description of the command
     * @param commandFormat  format of the command
     * @param console        console
     * @param commandManager command manager
     */
    public ConsoleCmdCommand(String name, String description, String commandFormat, Console console,
                             CommandManager commandManager) {
        super(name, description, commandFormat, console);
        this.commandManager = commandManager;
    }
}
