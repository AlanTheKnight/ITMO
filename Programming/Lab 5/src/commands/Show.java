package commands;

import managers.CollectionManager;
import models.Worker;
import utils.Console;
import utils.ConsoleColors;

/**
 * Command for printing all elements of the collection to the standard
 * output stream.
 *
 * @author AlanTheKnight
 */
public class Show extends ConsoleCollectionCommand {

    /**
     * Constructor for the command.
     *
     * @param console           console
     * @param collectionManager collection manager
     */
    public Show(Console console, CollectionManager collectionManager) {
        super("show", "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении", "show",
                console, collectionManager);
    }

    public Show(Console console, CollectionManager collectionManager, String name, String description) {
        super(name, description, name, console, collectionManager);
    }

    @Override
    public boolean execute(String[] arguments) {
        for (Worker w : collectionManager.getWorkers().values()) {
            console.printInColor(ConsoleColors.byNumber(w.hashCode()), w.toString());
        }
        return true;
    }
}
