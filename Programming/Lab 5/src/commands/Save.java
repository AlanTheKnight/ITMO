package commands;

import managers.CollectionManager;
import utils.Console;

/**
 * Command for saving the collection to a file.
 *
 * @author AlanTheKnight
 */
public class Save extends ConsoleCollectionCommand {
    /**
     * Constructor for the command.
     *
     * @param console           console
     * @param collectionManager collection manager
     */
    public Save(Console console, CollectionManager collectionManager) {
        super("save", "Сохранить коллекцию в файл", "save", console, collectionManager);
    }

    @Override
    public boolean execute(String[] arguments) {
        boolean status = collectionManager.saveCollection();
        if (status)
            console.printSuccess("Коллекция сохранена в файл");
        return status;
    }
}
