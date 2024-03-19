package models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utils.Convertable;
import utils.Validatable;

import java.util.Objects;

/**
 * Model for personal data of the worker.
 *
 * @author AlanTheKnight
 */
public class Person implements Validatable, Convertable {
    /**
     * Height of the person (not null, greater than 0).
     */
    private final double height;

    /**
     * Weight of the person (not null, greater than 0).
     */
    private final long weight;

    /**
     * Hair color of the person (can be null).
     */
    private final Color hairColor;

    /**
     * Nationality of the person (can be null).
     */
    private final Country nationality;

    public Person(double height, long weight, Color hairColor, Country nationality) {
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }

    /**
     * Creates a new Person object from the XML element.
     *
     * @param element XML element
     * @return new Person object
     */
    public static Person fromElement(Element element) {
        String heightValue = element.getElementsByTagName("height").item(0).getTextContent();
        String weightValue = element.getElementsByTagName("weight").item(0).getTextContent();
        String hairColorValue = element.getElementsByTagName("hairColor").item(0).getTextContent();
        String nationalityValue = element.getElementsByTagName("nationality").item(0).getTextContent();

        double height = Double.parseDouble(heightValue);
        long weight = Long.parseLong(weightValue);
        Color hairColor = hairColorValue.equals("null") ? null : Color.valueOf(hairColorValue);
        Country nationality = nationalityValue.equals("null") ? null : Country.valueOf(nationalityValue);

        return new Person(height, weight, hairColor, nationality);
    }

    @Override
    public boolean validate() {
        return !(height <= 0) && weight > 0;
    }

    @Override
    public Element getElement(Document document) {
        Element personElement = document.createElement("person");

        Element heightElement = document.createElement("height");
        heightElement.setTextContent(String.valueOf(height));
        personElement.appendChild(heightElement);

        Element weightElement = document.createElement("weight");
        weightElement.setTextContent(String.valueOf(weight));
        personElement.appendChild(weightElement);

        Element hairColorElement = document.createElement("hairColor");
        hairColorElement.setTextContent(hairColor == null ? "null" : hairColor.toString());
        personElement.appendChild(hairColorElement);

        Element nationalityElement = document.createElement("nationality");
        nationalityElement.setTextContent(nationality == null ? "null" : nationality.toString());
        personElement.appendChild(nationalityElement);

        return personElement;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, weight, hairColor, nationality);
    }
}
