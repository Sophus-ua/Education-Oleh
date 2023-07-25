package Lesson_7_Serialization_XML_JSON.Task_3;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.nio.file.Path;

class SAXparser {
    static void saxParsing(Path pathToFile) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new UserHandler();

            saxParser.parse(pathToFile.toFile(),handler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
