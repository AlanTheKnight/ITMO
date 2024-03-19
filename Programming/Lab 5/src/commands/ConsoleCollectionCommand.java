package commands;

import managers.CollectionManager;
import utils.Console;

/**
 * Abstract class for a command that uses console input/output and operates on a
 * collection.
 *
 * @author AlanTheKnight
 */
public abstract class ConsoleCollectionCommand extends ConsoleCommand {
    /**
     * Collection manager.
     */
    protected final CollectionManager collectionManager;

    /**
     * Constructor.
     *
     * @param name              name of the command
     * @param description       description of the command
     * @param commandFormat     format of the command
     * @param console           console
     * @param collectionManager collection manager
     */
    public ConsoleCollectionCommand(String name, String description, String commandFormat, Console console,
                                    CollectionManager collectionManager) {
        super(name, description, commandFormat, console);
        this.collectionManager = collectionManager;
    }
}
