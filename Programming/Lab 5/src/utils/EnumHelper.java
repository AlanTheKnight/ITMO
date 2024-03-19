package utils;

/**
 * Helper class for working with enums
 *
 * @author AlanTheKnight
 */
public class EnumHelper {
    /**
     * Converts an enum to a string (comma-separated list of values).
     *
     * @param <T>       enum type
     * @param enumClass enum class
     * @return string representation of the enum
     */
    public static <T extends Enum<T>> String enumToString(Class<T> enumClass) {
        StringBuilder result = new StringBuilder();
        for (Enum<T> value : enumClass.getEnumConstants()) {
            result.append(value.name()).append(", ");
        }
        return result.substring(0, result.length() - 2);
    }
}