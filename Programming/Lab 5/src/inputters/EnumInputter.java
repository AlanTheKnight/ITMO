package inputters;

import utils.Console;
import utils.EnumHelper;

/**
 * Inputter for enum values.
 *
 * @author AlanTheKnight
 */
public final class EnumInputter {
    /**
     * Asks the user for an enum value.
     *
     * @param <T>        enum type
     * @param console    console
     * @param enumClass  enum class
     * @param isRequired whether the value is required
     * @param prompt     prompt
     * @return enum value
     * @throws EnumInputterException if input was unsuccessful, in file console mode
     */
    public static <T extends Enum<T>> T input(Console console, Class<T> enumClass, boolean isRequired, String prompt)
            throws EnumInputterException {
        while (true) {
            if (console.isInteractive())
                console.println("Выберите одно из значений: " + EnumHelper.enumToString(enumClass));
            String input = console.readLine(false).trim();
            if (input.isEmpty()) {
                if (isRequired) {
                    console.printError("Поле не может быть пустым");
                    if (!console.isInteractive())
                        throw new EnumInputterException("Поле " + prompt + " не может быть пустым");
                    continue;
                } else {
                    return null;
                }
            }
            try {
                return Enum.valueOf(enumClass, input);
            } catch (IllegalArgumentException e) {
                console.printError(
                        "Значение должно быть одним из перечисленных: " + EnumHelper.enumToString(enumClass));
                if (!console.isInteractive())
                    throw new EnumInputterException(
                            "Введенное в поле " + prompt + " значение не соответствует доступным вариантам");
            }
        }
    }

    /**
     * Inputs an enum value.
     *
     * @param <T>       enum type
     * @param console   console
     * @param enumClass enum class
     * @param prompt    prompt
     * @return enum value
     * @throws EnumInputterException if input was unsuccessful, in file console mode
     */
    public static <T extends Enum<T>> T input(Console console, Class<T> enumClass, String prompt)
            throws EnumInputterException {
        return input(console, enumClass, true, prompt);
    }

    /**
     * Exception for enum inputter, thrown when input is unsuccessful, in file
     * console mode.
     *
     * @author AlanTheKnight
     */
    public static class EnumInputterException extends Exception {
        /**
         * Exception message
         */
        private final String message;

        public EnumInputterException(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }
}
