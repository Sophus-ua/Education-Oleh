package Lesson_3_IO_Strings.Task_4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File myFile = new File("O:/JavaC/IDEA Projects/JavaAdvanced/src/Lesson_3_IO_Strings/Task_4/file_Task_4.txt");
        String content = "„Если ты будешь любознательным, то будешь много знающим.“ \n— Сократ";

        try {
            if (myFile.createNewFile()) {
                System.out.println("Файл створено");
            } else {
                System.out.println("Файл вже існує");
            }

            PrintWriter writer = new PrintWriter(myFile);
            writer.print(content);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            System.out.println("\033[1;35mТекст файлу:\033[0m");
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Помилка " + e.getMessage());
        }
    }
}
