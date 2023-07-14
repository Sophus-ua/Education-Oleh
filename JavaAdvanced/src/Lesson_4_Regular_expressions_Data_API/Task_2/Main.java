package Lesson_4_Regular_expressions_Data_API.Task_2;



import java.nio.file.Path;
import java.nio.file.Paths;

class Main {
    public static void main(String[] args) {
        Path textToRead = Paths.get("O:/JavaC/IDEA Projects/JavaAdvanced/src/Lesson_4_Regular_expressions_Data_API/Task_2/textFile.txt");
        Path wrightToFile = Paths.get("O:/JavaC/IDEA Projects/JavaAdvanced/src/Lesson_4_Regular_expressions_Data_API/Task_2/decryptedFile.txt");

        Decryptor myDecryptor = new Decryptor();
        myDecryptor.decrypting(textToRead,wrightToFile);
    }
}
