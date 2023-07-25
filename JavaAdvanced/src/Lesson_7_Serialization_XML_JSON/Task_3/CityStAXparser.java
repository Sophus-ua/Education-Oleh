package Lesson_7_Serialization_XML_JSON.Task_3;


import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;

class CityStAXparser {
    class Street{
        String streetName;
        String[] buildings;
        Street (String streetName, String[] buildings){
            this.streetName = streetName;
            this.buildings = buildings;
        }
    }
    void staxParsing(Path pathToFile, String cityName, Street[] streets){
        CityStAXparser cityParser = new CityStAXparser();
        try{
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlWriter = factory.createXMLStreamWriter(new FileOutputStream(pathToFile.toFile()));

            xmlWriter.writeStartDocument("UTF-8","1.0");
            xmlWriter.writeStartElement("city");
            xmlWriter.writeAttribute("size", "big");
            cityParser.writeElement(xmlWriter,"name",cityName);

            xmlWriter.writeStartElement("streets");
            for (Street street : streets) {
                xmlWriter.writeStartElement("street");
                cityParser.writeElement(xmlWriter, "name", street.streetName);
                for (int y = 0; y < street.buildings.length; y++) {
                    cityParser.writeElement(xmlWriter, "building", street.buildings[y]);
                }
                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();
            xmlWriter.writeEndElement();

            xmlWriter.flush();
            xmlWriter.close();

            System.out.println("xml файл створено");
        } catch (XMLStreamException | FileNotFoundException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
    private void writeElement (XMLStreamWriter xmlWriter, String elementName, String description) throws XMLStreamException {
        xmlWriter.writeStartElement(elementName);
        xmlWriter.writeCharacters(description);
        xmlWriter.writeEndElement();
    }
}
