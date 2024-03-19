package models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utils.CollectionElement;
import utils.Convertable;

import java.time.LocalDate;

/**
 * Worker element of the collection.
 */
public class Worker extends CollectionElement implements Convertable {
    /**
     * Worker's id (unique for each worker, generated automatically)
     */
    private int id;

    /**
     * Name of the worker (not null).
     */
    private final String name;

    /**
     * Coordinates of the worker (not null).
     */
    private final Coordinates coordinates;

    /**
     * Creation date of the worker record (generated automatically).
     */
    private LocalDate creationDate;

    /**
     * Salary of the worker (not null, greater than 0).
     */
    private final Long salary;

    /**
     * End date of the worker's contract (not null).
     */
    private final LocalDate endDate;

    /**
     * Position of the worker (can be null).
     */
    private final Position position;

    /**
     * Status of the worker (not null).
     */
    private final Status status;

    /**
     * Personal data of the worker (not null).
     */
    private final Person person;

    /**
     * Creates a new worker.
     *
     * @param id          id
     * @param name        name
     * @param coordinates coordinates
     * @param salary      salary
     * @param endDate     end date
     * @param position    position
     * @param status      status
     * @param person      person
     */
    public Worker(int id, String name, Coordinates coordinates, Long salary,
                  LocalDate endDate, Position position, Status status, Person person) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.salary = salary;
        this.endDate = endDate;
        this.position = position;
        this.status = status;
        this.person = person;
    }

    /**
     * Creates a new worker.
     *
     * @param id           id
     * @param name         name
     * @param coordinates  coordinates
     * @param salary       salary
     * @param creationDate creation date
     * @param endDate      end date
     * @param position     position
     * @param status       status
     * @param person       person
     */
    public Worker(int id, String name, Coordinates coordinates, Long salary, LocalDate creationDate,
                  LocalDate endDate, Position position, Status status, Person person) {
        this(id, name, coordinates, salary, endDate, position, status, person);
        this.creationDate = creationDate;
    }

    /**
     * Creates a new Worker object from the given XML element.
     *
     * @param element XML element
     * @return new Worker object
     */
    public static Worker fromElement(Element element) {
        int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
        String name = element.getElementsByTagName("name").item(0).getTextContent();
        Coordinates coordinates = Coordinates
                .fromElement((Element) element.getElementsByTagName("coordinates").item(0));
        LocalDate creationDate = LocalDate.parse(element.getElementsByTagName("creationDate").item(0).getTextContent());
        Long salary = Long.parseLong(element.getElementsByTagName("salary").item(0).getTextContent());
        LocalDate endDate = LocalDate.parse(element.getElementsByTagName("endDate").item(0).getTextContent());
        Position position = Position.valueOf(element.getElementsByTagName("position").item(0).getTextContent());
        Status status = Status.valueOf(element.getElementsByTagName("status").item(0).getTextContent());
        Person person = Person.fromElement((Element) element.getElementsByTagName("person").item(0));

        return new Worker(id, name, coordinates, salary, creationDate, endDate, position, status, person);
    }

    @Override
    public boolean validate() {
        if (name == null || name.isEmpty())
            return false;
        if (coordinates == null || !coordinates.validate())
            return false;
        if (creationDate == null)
            return false;
        if (salary != null && salary <= 0)
            return false;
        if (status == null)
            return false;
        return person != null && person.validate();
    }

    @Override
    public int compareTo(CollectionElement arg0) {
        return id - arg0.getId();
    }

    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the worker.
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Creates a new XML element from the Worker object.
     *
     * @param document XML document
     * @return new XML element
     */
    @Override
    public Element getElement(Document document) {
        Element workerElement = document.createElement("worker");

        Element idElement = document.createElement("id");
        idElement.setTextContent(String.valueOf(id));
        workerElement.appendChild(idElement);

        Element nameElement = document.createElement("name");
        nameElement.setTextContent(name);
        workerElement.appendChild(nameElement);

        Element coordinatesElement = coordinates.getElement(document);
        workerElement.appendChild(coordinatesElement);

        Element creationDateElement = document.createElement("creationDate");
        creationDateElement.setTextContent(creationDate.toString());
        workerElement.appendChild(creationDateElement);

        Element salaryElement = document.createElement("salary");
        salaryElement.setTextContent(String.valueOf(salary));
        workerElement.appendChild(salaryElement);

        Element endDateElement = document.createElement("endDate");
        endDateElement.setTextContent(endDate == null ? "null" : endDate.toString());
        workerElement.appendChild(endDateElement);

        Element positionElement = document.createElement("position");
        positionElement.setTextContent(position == null ? "null" : position.toString());
        workerElement.appendChild(positionElement);

        Element statusElement = document.createElement("status");
        statusElement.setTextContent(status.toString());
        workerElement.appendChild(statusElement);

        Element personElement = person.getElement(document);
        workerElement.appendChild(personElement);

        return workerElement;
    }

    @Override
    public String toString() {
        return "Worker [coordinates=" + coordinates + ", creationDate=" + creationDate + ", endDate=" + endDate
                + ", id="
                + id + ", name=" + name + ", person=" + person + ", position=" + position + ", salary=" + salary
                + ", status=" + status + "]";
    }

    /**
     * Returns the end date of the worker's contract.
     *
     * @return end date
     */
    public LocalDate getEndDate() {
        return endDate;
    }
}
