package inputters;

import utils.Console;

/**
 * Inputter for numeric values.
 *
 * @author AlanTheKnight
 */
public final class NumberInputter {
    /**
     * Asks the user for a numeric value.
     *
     * @param <T>         number type
     * @param console     console
     * @param numberClass number class
     * @param prompt      prompt
     * @param isRequired  whether the value is required
     * @param checker     number checker
     * @return number
     * @throws NumberInputterException
     */
    public static <T extends Number> T input(Console console, Class<T> numberClass, String prompt,
                                             boolean isRequired, NumberChecker<T> checker)
            throws NumberInputterException {
        while (true) {
            if (console.isInteractive())
                console.print("Введите " + prompt + ": ");

            String input = console.readLine(false).trim();

            if (input.isEmpty()) {
                if (isRequired) {
                    console.printError("Поле " + prompt + " не может быть пустым");
                    if (!console.isInteractive()) {
                        throw new NumberInputterException();
                    }
                    continue;
                } else {
                    return null;
                }
            }
            try {
                T number = null;
                if (numberClass == Integer.class) {
                    number = numberClass.cast(Integer.parseInt(input));
                } else if (numberClass == Long.class) {
                    number = numberClass.cast(Long.parseLong(input));
                } else if (numberClass == Float.class) {
                    number = numberClass.cast(Float.parseFloat(input));
                } else if (numberClass == Double.class) {
                    number = numberClass.cast(Double.parseDouble(input));
                } else {
                    throw new NumberInputterException();
                }

                var isValid = true;
                if (checker != null) {
                    isValid = checker.check(number);
                }

                if (isValid) {
                    return number;
                } else {
                    if (!console.isInteractive()) {
                        throw new NumberInputterException();
                    }
                }

            } catch (NumberFormatException e) {
                console.printError("Значение должно быть числом типа " + numberClass.getSimpleName());
                if (!console.isInteractive()) {
                    throw new NumberInputterException();
                }
            }
        }

    }

    public static <T extends Number> T input(Console console, Class<T> numberClass, String prompt)
            throws NumberInputterException {
        return input(console, numberClass, prompt, true, null);
    }

    public interface NumberChecker<T extends Number> {
        boolean check(T number);
    }

    public static class NumberInputterException extends Exception {

    }
}
