package commands;

import inputters.ElementInputter;
import managers.CollectionManager;
import models.Worker;
import utils.Console;

/**
 * Command for adding a new element with a given key.
 *
 * @author AlanTheKnight
 */
public class Insert extends ConsoleCollectionCommand {
    /**
     * Constructor for the command.
     *
     * @param console           console
     * @param collectionManager collection manager
     */
    public Insert(Console console, CollectionManager collectionManager) {
        super("insert",
                "Добавить новый элемент с заданным ключом",
                "insert <id>",
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

        try {
            Worker w = ElementInputter.inputWorker(console);
            collectionManager.insertWorker(id, w);
            console.printSuccess("Элемент добавлен");
            return true;
        } catch (ElementInputter.ElementInputterException e) {
            console.printError("Ошибка ввода");
            return false;
        }
    }
}
