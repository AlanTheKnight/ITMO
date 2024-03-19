package commands;

import managers.CollectionManager;
import models.Worker;
import utils.Console;
import utils.ConsoleColors;

/**
 * Command for removing an element from the collection by its key.
 *
 * @author AlanTheKnight
 */
public class RemoveKey extends ConsoleCollectionCommand {
    /**
     * Constructor for the command.
     *
     * @param console           console
     * @param collectionManager collection manager
     */
    public RemoveKey(Console console, CollectionManager collectionManager) {
        super("remove_key", "Удалить элемент из коллекции по его ключу", "remove_key <id>",
                console, collectionManager);
    }

    @Override
    public boolean execute(String[] arguments) {
        int id;

        try {
            id = Integer.parseInt(arguments[1]);
        } catch (NumberFormatException e) {
            printArgsError(console);
            return false;
        }

        Worker w = collectionManager.removeWorker(id);

        if (w == null) {
            console.printError("Элемент с ключем " + id + " не найден");
        } else {
            console.println(ConsoleColors.colorize("Элемент с ключом " + id + " удален", ConsoleColors.GREEN));
        }

        return true;
    }
}
