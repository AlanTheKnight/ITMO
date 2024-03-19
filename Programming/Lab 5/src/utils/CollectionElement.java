package utils;

/**
 * Collection element.
 *
 * @author AlanTheKnight
 */
public abstract class CollectionElement implements Comparable<CollectionElement>, Validatable {
    /**
     * Get the element's ID.
     *
     * @return element's ID
     */
    abstract public Integer getId();
}
