package utils;

/**
 * Interface for objects that have a name and a description.
 *
 * @author AlanTheKnight
 */
public interface Describable {
    /**
     * Get the name of the object.
     *
     * @return name of the object
     */
    String getName();

    /**
     * Get the description of the object.
     *
     * @return description of the object
     */
    String getDescription();
}
