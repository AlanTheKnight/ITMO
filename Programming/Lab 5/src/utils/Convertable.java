package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Object that can be converted to XML element.
 *
 * @author AlanTheKnight
 */
public interface Convertable {
    Element getElement(Document document);
}
