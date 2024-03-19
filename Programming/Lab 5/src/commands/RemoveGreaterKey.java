package commands;

import managers.CollectionManager;
import utils.Console;

/**
 * Command for removing all elements greater than the given key.
 *
 * @author AlanTheKnight
 */
public class RemoveGreaterKey extends ConsoleCollectionCommand {
    /**
     * Constructor for the command.
     *
     * @param console           console
     * @param collectionManager collection manager
     */
    public RemoveGreaterKey(Console console, CollectionManager collectionManager) {
        super("remove_greater_key", "Удалить из коллекции все элементы, ключ которых превышает заданный",
                "remove_greater_key <value>",
                console, collectionManager);
    }

    @Override
    public boolean execute(String[] arguments) {
        int key;

        try {
            key = Integer.parseInt(arguments[1]);
        } catch (NumberFormatException e) {
            printArgsError(console);
            return false;
        }

        int removed = collectionManager.removeGreaterKey(key);

        console.printSuccess("Удалено " + removed + " элементов");

        return true;
    }
}
