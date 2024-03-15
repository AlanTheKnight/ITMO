package commands;

import managers.CollectionManager;
import utils.Console;

/**
 * Command for clearing the collection.
 * 
 * @author AlanTheKnight
 */
public class Clear extends ConsoleCollectionCommand {
    /**
     * Constructor for the command.
     * @param console console
     * @param collectionManager collection manager
     */
    public Clear(Console console, CollectionManager collectionManager) {
        super("clear", "Очистить коллекцию", "clear", console, collectionManager);
    }

    @Override
    public boolean execute(String[] arguments) {
        if (arguments.length != 1) {
            printInvalidArgs(console);
            return false;
        }

        collectionManager.clearCollection();
        console.printSuccess("Коллекция очищена");
        return true;
    }
}
