package commands;

import managers.CollectionManager;
import utils.Console;
import utils.ConsoleColors;

/**
 * Command for showing information about the collection.
 *
 * @author AlanTheKnight
 */
public class Info extends ConsoleCollectionCommand {
    /**
     * Constructor for the command.
     *
     * @param console           console
     * @param collectionManager collection manager
     */
    public Info(Console console, CollectionManager collectionManager) {
        super("info", "Вывести в стандартный поток вывода информацию о коллекции", "info", console, collectionManager);
    }

    @Override
    public boolean execute(String[] arguments) {
        console.printInColor(ConsoleColors.BLUE, "Сведения о коллекции: ");
        console.println("Тип: " + collectionManager.getWorkers().getClass().getName());
        console.println("Количество элементов: " + collectionManager.getCollection().size());
        console.print("Дата инициализации: ");
        console.println(collectionManager.getLastInitTime().toLocalDate().toString() + " "
                + collectionManager.getLastInitTime().toLocalTime().toString());

        return true;
    }
}
