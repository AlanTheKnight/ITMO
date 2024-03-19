package models;

/**
 * Countries enumeration.
 *
 * @author AlanTheKnight
 */
public enum Country {
    UNITED_KINGDOM,
    SOUTH_KOREA,
    NORTH_KOREA;

    /**
     * Returns all countries as a string.
     *
     * @return all countries
     */
    public static String countries() {
        StringBuilder result = new StringBuilder();
        for (Country country : values()) {
            result.append(country.name()).append(", ");
        }
        return result.substring(0, result.length() - 2);
    }
}
