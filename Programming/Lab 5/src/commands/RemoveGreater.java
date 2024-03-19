package commands;

import inputters.ElementInputter;
import managers.CollectionManager;
import models.Worker;
import utils.Console;

/**
 * Command for removing all elements greater than the given one.
 *
 * @author AlanTheKnight
 */
public class RemoveGreater extends ConsoleCollectionCommand {
    /**
     * Constructor for the command.
     *
     * @param console           console
     * @param collectionManager collection manager
     */
    public RemoveGreater(Console console, CollectionManager collectionManager) {
        super("remove_greater", "Удалить из коллекции все элементы, превышающие заданный",
                "remove_greater",
                console, collectionManager);
    }

    @Override
    public boolean execute(String[] arguments) {
        Worker w;
        try {
            w = ElementInputter.inputWorker(console);
        } catch (ElementInputter.ElementInputterException e) {
            console.printError("Ошибка ввода");
            return false;
        }

        int removed = collectionManager.removeGreaterEndDate(w.getEndDate());
        console.printSuccess("Удалено " + removed + " элементов");
        return true;
    }
}
