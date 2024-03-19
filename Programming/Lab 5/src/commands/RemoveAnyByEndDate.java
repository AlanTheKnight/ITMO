package commands;

import managers.CollectionManager;
import models.Worker;
import utils.Console;

import java.time.LocalDate;

/**
 * Command for removing the element by end date.
 *
 * @author AlanTheKnight
 */
public class RemoveAnyByEndDate extends ConsoleCollectionCommand {
    /**
     * Constructor for the command.
     *
     * @param console           console
     * @param collectionManager collection manager
     */
    public RemoveAnyByEndDate(Console console, CollectionManager collectionManager) {
        super("remove_any_by_end_date",
                "Удалить из коллекции один элемент, значение поля endDate которого эквивалентно заданному",
                "remove_any_by_end_date yyyy-mm-dd",
                console, collectionManager);
    }

    @Override
    public boolean execute(String[] arguments) {
        String endDate = arguments[1];
        if (!endDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            console.printError("Дата должна быть в формате yyyy-mm-dd");
            return false;
        }

        LocalDate date = LocalDate.parse(endDate);

        Worker w = collectionManager.removeWorkerByEndDate(date);

        if (w == null) {
            console.printError("Элемент с датой окончания " + date + " не найден");
        } else {
            console.printSuccess("Элемент с датой окончания " + date + " удален");
        }

        return true;
    }
}
