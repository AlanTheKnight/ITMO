package commands;

import managers.CollectionManager;
import models.Worker;
import utils.Console;
import utils.ConsoleColors;

import java.time.LocalDate;

/**
 * Command for filtering the collection by end date.
 *
 * @author AlanTheKnight
 */
public class FilterByEndDate extends ConsoleCollectionCommand {
    /**
     * Constructor for the command.
     *
     * @param console           console
     * @param collectionManager collection manager
     */
    public FilterByEndDate(Console console, CollectionManager collectionManager) {
        super("filter_by_end_date", "Вывести элементы, значение поля endDate которых равно заданному",
                "filter_by_end_date yyyy-mm-dd",
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
        int count = 0;

        for (Worker w : collectionManager.getWorkers().values()) {
            if (w.getEndDate().equals(date)) {
                console.printInColor(ConsoleColors.byNumber(w.hashCode()), w.toString());
                count++;
            }
        }

        console.printSuccess("Найдено " + count + " элементов");

        return true;
    }
}
