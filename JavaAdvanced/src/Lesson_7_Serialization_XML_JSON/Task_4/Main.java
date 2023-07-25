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

        Building building1 = new Building();
        Building building2 = new Building();
        Building building3 = new Building();
        building1.setName("TSUM");
        building2.setName("Ukrposhta 01001");
        building3.setName("hotel 'Khreschatyk'");
        street1.add(building1);
        street1.add(building2);
        street1.add(building3);

        Street street2 = new Street();
        street2.setName("Andriivskyi Descent");

        Building building4 = new Building();
        Building building5 = new Building();
        building4.setName("st Andrew's Church");
        building5.setName("Theater on Podol");
        street2.add(building4);
        street2.add(building5);

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
