package Lesson_3_IO_Strings.Task_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("O:/JavaC/IDEA Projects/JavaAdvanced/src/Lesson_3_IO_Strings/Task_2/file_Task_2.txt");
        String content = "„Там нет прекрасного, где нет доброго и полезного.“ \n— Сократ";

        try {
            if (!Files.exists(filePath)){
                Files.createFile(filePath);
                System.out.println("Файл створено;");
            } else System.out.println("Файл вже існує");

            Files.writeString(filePath, content);

            System.out.println("\033[1;35mТест файлу:\033[0m");
            System.out.println(Files.readString(filePath));

        } catch (IOException e){
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
