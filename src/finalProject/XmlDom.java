package finalProject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlDom {
    // Запись списка книг в XML файл
    public static void writeBooks (List<Book> books) {
        // Создание нового документа
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document doc = builder.newDocument();

        // Создание корневого элемента 'library'
        Element library = doc.createElement("library");
        doc.appendChild(library);

        for (Book book : books) {
            // Добавление книги
            Element bookElement = doc.createElement("book");
            library.appendChild(bookElement);

            // Установка атрибута книги
            bookElement.setAttribute("id", String.valueOf(book.getId()));

            // Добавление параметров книги
            Element author = doc.createElement("author");
            author.appendChild(doc.createTextNode(book.getAuthor()));
            bookElement.appendChild(author);

            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode(book.getTitle()));
            bookElement.appendChild(title);

            Element year = doc.createElement("year");
            year.appendChild(doc.createTextNode(String.valueOf(book.getYear())));
            bookElement.appendChild(year);

            Element genre = doc.createElement("genre");
            genre.appendChild(doc.createTextNode(book.getGenre()));
            bookElement.appendChild(genre);
        }

        // Запись содержимого в файл
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/finalProject/library.xml"));

            // Включение форматирования с отступами
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(source, result);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    // Чтение списка книг из XML файла
    public static List<Book> readBooks () {
        List<Book> books = new ArrayList<>();

        // Создание документа из файла
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            doc = builder.parse(new File("src/finalProject/library.xml"));
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        doc.getDocumentElement().normalize();

        // builder для создания книг
        Book.Builder bookBuilder = new Book.Builder();

        NodeList nodeList = doc.getElementsByTagName("book");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                bookBuilder.author(element.getElementsByTagName("author").item(0).getTextContent())
                        .title(element.getElementsByTagName("title").item(0).getTextContent())
                        .year(Integer.parseInt(element.getElementsByTagName("year").item(0).getTextContent()))
                        .genre(element.getElementsByTagName("genre").item(0).getTextContent());

                books.add(bookBuilder.build());
            }
        }

        return books;
    }
}
