package inputters;

import inputters.EnumInputter.EnumInputterException;
import inputters.NumberInputter.NumberInputterException;
import models.*;
import utils.Console;

import java.time.LocalDate;

/**
 * Inputter for worker elements of the collection.
 *
 * @author AlanTheKnight
 */
public class ElementInputter {
    /**
     * Inputs a worker.
     *
     * @param console
     * @return new Worker object
     * @throws ElementInputterException
     */
    public static Worker inputWorker(Console console) throws ElementInputterException {
        try {
            String name = inputName(console);
            Coordinates coordinates = inputCoordinates(console);
            LocalDate endDate = inputEndDate(console);
            Long salary = NumberInputter.input(console, Long.class, "salary", true, (number) -> {
                if (number <= 0) {
                    console.printError("Поле salary должно быть больше 0");
                    return false;
                }
                return true;
            });
            Person person = inputPerson(console);
            Position position = EnumInputter.input(console, Position.class, false, "position");
            Status status = EnumInputter.input(console, Status.class, false, "status");
            return new Worker(0, name, coordinates, salary, endDate, position, status, person);
        } catch (EnumInputterException | NumberInputterException e) {
            throw new ElementInputterException();
        }
    }

    /**
     * Inputs coordinates.
     *
     * @param console console
     * @return new Coordinates object or null if input was unsuccessful
     * @throws ElementInputterException
     */
    public static Coordinates inputCoordinates(Console console) throws ElementInputterException {
        try {
            int x = NumberInputter.input(console, Integer.class, "coordinates.x");
            Float y = NumberInputter.input(console, Float.class, "coordinates.y", true,
                    (number) -> {
                        if (number <= -154.0f) {
                            console.printError("Поле coordinates.y должно быть больше -154");
                            return false;
                        }
                        return true;
                    });
            return new Coordinates(x, y);
        } catch (NumberInputterException e) {
            throw new ElementInputterException();
        }
    }

    /**
     * Inputs name.
     *
     * @param console console
     * @return name
     * @throws ElementInputterException
     */
    public static String inputName(Console console) throws ElementInputterException {
        while (true) {
            if (console.isInteractive())
                console.print("name: ");
            String name = console.readLine(false).trim();
            if (name.isEmpty()) {
                console.printError("Поле name не может быть пустым");
                if (!console.isInteractive()) {
                    throw new ElementInputterException();
                }
                continue;
            }
            return name;
        }
    }

    /**
     * Inputs end date.
     *
     * @param console
     * @return end date or null
     * @throws ElementInputterException
     */
    public static LocalDate inputEndDate(Console console) throws ElementInputterException {
        while (true) {
            if (console.isInteractive())
                console.print("endDate (yyyy-mm-dd): ");
            String endDate = console.readLine(false).trim();
            if (endDate.isEmpty()) {
                return null;
            }
            if (!endDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                console.printError("Поле endDate должно быть в формате yyyy-mm-dd");
                if (!console.isInteractive()) {
                    throw new ElementInputterException();
                }
                continue;
            }
            return LocalDate.parse(endDate);
        }
    }

    /**
     * Inputs person.
     *
     * @param console console
     * @return new Person object
     * @throws ElementInputterException
     */
    public static Person inputPerson(Console console) throws ElementInputterException {
        try {
            Double height = NumberInputter.input(console, Double.class, "person.height",
                    true, (number) -> {
                        if (number <= 0) {
                            console.printError("Поле person.height должно быть больше 0");
                            return false;
                        }
                        return true;
                    });
            Long weight = NumberInputter.input(console, Long.class, "person.weight",
                    true, (number) -> {
                        if (number <= 0) {
                            console.printError("Поле person.weight должно быть больше 0");
                            return false;
                        }
                        return true;
                    });
            Color hairColor = EnumInputter.input(console, Color.class, false, "person.hairColor");
            Country nationality = EnumInputter.input(console, Country.class, false, "person.nationality");
            return new Person(height, weight, hairColor, nationality);
        } catch (NumberInputterException | EnumInputterException e) {
            throw new ElementInputterException();
        }
    }

    public static class ElementInputterException extends Exception {
    }
}
