package Lesson_2_DAO.task_3.ListSerializations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NecklaceListSerializations {
    private String pathToFile = "src/Lesson_2_DAO/task_3/ListSerializations/NecklaceList.txt";
    private Path path;

    public NecklaceListSerializations() {
        path = Paths.get(pathToFile);
    }

    public void writeNecklacesToFile(CatalogueOfNecklaces catalogue) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("Файл створено!");
            }
            out.writeObject(catalogue);

            System.out.println("Каталог намист записанний в файл");
        } catch (IOException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public CatalogueOfNecklaces readNecklacesFile() {
        CatalogueOfNecklaces catalogue = new CatalogueOfNecklaces();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            if (!Files.exists(path)) Files.createFile(path);

            catalogue = (CatalogueOfNecklaces) in.readObject();
            System.out.println("Каталог намист зчитанний з файлу");
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            System.out.println("Каталог намист порожній");
            return catalogue;
        }
        return catalogue;
    }
}
