package task_02;


import controllers.User;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileHandler {

    Path pathToFile;
    JAXBContext jaxbContext;
    private boolean recursiveCall;

    public FileHandler() {
        recursiveCall = false;
        pathToFile = Paths.get("O:\\JavaC\\IDEA Projects\\Spring_projects\\Lesson_03\\src\\main\\resources\\catalog.xml");
        initJaxbContext();
    }

    private void initJaxbContext(){
        try {
            jaxbContext = JAXBContext.newInstance(UsersDatabaseCatalog.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public void recordUserToFile(User user) {
        try {
            UsersDatabaseCatalog usersDatabaseCatalog = getUsersDatabaseCatalog();
            usersDatabaseCatalog.add(new UserInformation(user.getName(), user.getPassword()));

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(usersDatabaseCatalog, pathToFile.toFile());

            recursiveCall = false;
            System.out.println("***В файл було записано інформацію***");
        } catch (JAXBException e) {
            System.out.println("***Помилка при запісі файлу***");
            deleteFile();
            if (!recursiveCall) {
                recursiveCall = true;
                recordUserToFile(user);
            }
        }
    }

    public UsersDatabaseCatalog getUsersDatabaseCatalog() {
        UsersDatabaseCatalog usersDatabaseCatalog = new UsersDatabaseCatalog();
        try {
            if (!Files.exists(pathToFile)) {
                Files.createFile(pathToFile);
                System.out.println("***Файл створено***");
            } else {
                System.out.println("***Файл вже існує***");
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                usersDatabaseCatalog = (UsersDatabaseCatalog) unmarshaller.unmarshal(pathToFile.toFile());
            }
        } catch (IOException e) {
            System.err.println("***Виникла помилка при спробі створити файл***");
        } catch (JAXBException e){
            System.err.println("***Виникла помилка при спробі зчитати файл***");
            deleteFile();
        }
        return usersDatabaseCatalog;
    }

    private void deleteFile(){
        try {
            Files.delete(pathToFile);
            System.out.println("***Файл було видалено***");
        } catch (IOException ex) {
            System.err.println("***Помилка при спробі видалити файл***");
        }
    }
}
