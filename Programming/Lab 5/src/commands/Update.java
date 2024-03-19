package commands;

import inputters.ElementInputter;
import managers.CollectionManager;
import models.Worker;
import utils.Console;

/**
 * Command for updating the value of an element in the collection with a given
 * id.
 */
public class Update extends ConsoleCollectionCommand {
    /**
     * Constructor for the command.
     *
     * @param console           console
     * @param collectionManager collection manager
     */
    public Update(Console console, CollectionManager collectionManager) {
        super("update",
                "Обновить значение элемента коллекции, id которого равен заданному",
                "update <id>",
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
            console.printSuccess("Элемент обновлён");
            return true;
        } catch (ElementInputter.ElementInputterException e) {
            console.printError("Ошибка ввода");
            return false;
        }
    }
}
