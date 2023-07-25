package Lesson_7_Serialization_XML_JSON.Task_4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        City city = new City();
        city.setName("Kyiv");

        Street street1 = new Street();
        street1.setName("Khreshchatyk");
        street1.add("TSUM");
        street1.add("Ukrposhta 01001");
        street1.add("hotel 'Khreschatyk'");

        Street street2 = new Street();
        street2.setName("Andriivskyi Descent");
        street2.add("st Andrew's Church");
        street2.add("Theater on Podol");

        city.add(street1);
        city.add(street2);

        try {
            Path filePath = Paths.get("src/Lesson_7_Serialization_XML_JSON/Task_4/city.xml");
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                System.out.println("Файл створено;");
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(City.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(city, filePath.toFile());

        } catch (JAXBException | java.io.IOException | NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }
}
