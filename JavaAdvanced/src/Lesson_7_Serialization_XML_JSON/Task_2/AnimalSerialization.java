package Lesson_7_Serialization_XML_JSON.Task_2;

import Lesson_5_Reflection.Task_4.Animal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class AnimalSerialization {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Path pathToFile = Paths.get("src/Lesson_7_Serialization_XML_JSON/Task_2/Task_2.txt");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathToFile.toFile()));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(pathToFile.toFile()))) {
            if (!Files.exists(pathToFile)) Files.createFile(pathToFile);

            out.writeObject(animal);
            animal = null;
            animal = (Animal) in.readObject();

            System.out.println(animal);
        } catch (IOException |  ClassNotFoundException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
