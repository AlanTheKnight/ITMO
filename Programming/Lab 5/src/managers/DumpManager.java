package managers;

import models.Worker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utils.Console;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Collection;
import java.util.TreeMap;

/**
 * The DumpManager class is responsible for reading and writing the collection
 * from/to the file.
 *
 * @author AlanTheKnight
 */
public class DumpManager {
    private final String filename;
    private final Console console;

    public DumpManager(String filename, Console console) {
        this.filename = filename;
        this.console = console;
    }

    /**
     * Reads the collection from the file.
     *
     * @return the collection of workers
     */
    public TreeMap<Integer, Worker> readCollection() {
        if (filename == null || filename.isEmpty()) {
            console.printError("Не указан путь к файлу данных.");
        }

        TreeMap<Integer, Worker> workers = new TreeMap<>();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            FileInputStream fileInputStream = new FileInputStream(filename);
            InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");

            Document document = documentBuilder.parse(fileInputStream);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getChildNodes().item(0).getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Worker worker = Worker.fromElement(element);
                    if (worker.validate())
                        workers.put(worker.getId(), worker);
                    else
                        console.printError("Объект с id " + worker.getId()
                                + " не прошел валидацию");
                }
            }

            reader.close();
            fileInputStream.close();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            console.printError("Не удалось прочитать коллекцию из файла.");
        }

        return workers;
    }

    public Document generateDocument(Collection<Worker> workers) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();
        Element root = document.createElement("collection");

        for (Worker worker : workers) {
            root.appendChild(worker.getElement(document));
        }

        document.appendChild(root);
        return document;
    }

    /**
     * Writes the collection to the file.
     *
     * @param workers the collection of workers
     * @return true if the collection was written successfully, false otherwise
     */
    public boolean writeDocument(Collection<Worker> workers) {
        if (filename == null || filename.isEmpty()) {
            console.printError("Не указан путь к файлу данных.");
            return false;
        }

        try {
            Document document = generateDocument(workers);
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            Writer writer = new OutputStreamWriter(fileOutputStream, "UTF-8");

            document.getDocumentElement().normalize();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(writer);

            transformer.transform(source, result);

            writer.close();

        } catch (ParserConfigurationException | TransformerException | IOException e) {
            console.printError("Не удалось записать коллекцию в файл.");
            return false;
        }
        return true;
    }
}
