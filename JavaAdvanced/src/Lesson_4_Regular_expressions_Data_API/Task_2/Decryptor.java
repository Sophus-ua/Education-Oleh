package Lesson_4_Regular_expressions_Data_API.Task_2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

class Decryptor {
    void decrypting(Path textToRead, Path wrightToFile) {
        // Прийменники: "в,з,о,на,за,до,по,під,від,між,над,про,поза,перед,серед,через,після,поруч"
        String regex = "\\b[ВвЗзОо]\\b|\\b[НнЗз][а]\\b|\\b[ДдПп][о]\\b|\\b[ПпВвМм][і][дж]\\b|\\b[НнПп][ар][до]\\b|\\b[Пп][о][з][а]\\b|\\b[ПпСсЧч][е][р][е][дз]\\b|\\b[Пп][іо][ср][лу][яч]\\b";
        try {
            this.createFile(wrightToFile);
            String text = Files.readString(textToRead, StandardCharsets.UTF_8);
            String decrypting = text.replaceAll(regex, "\033[0;32mjava:)\033[0m");

            Files.writeString(wrightToFile, decrypting, StandardCharsets.UTF_8);
            System.out.println("Тест успішно дешифрований і записанний у файл");

            this.readFile(wrightToFile);
        } catch (IOException e) {
            System.err.println("Виникла помилка: " + e.getMessage());
        }
    }
    void createFile(Path pathToFile) throws IOException {
        if (!Files.exists(pathToFile)) {
            Files.createFile(pathToFile);
            System.out.println("Файл створено");
        } else System.out.println("Файл вже існує");
    }
    void readFile(Path pathToFile) throws IOException {
        System.out.println("\033[1;35m___________________Decrypted_Text_______________________\033[0m");
        String[] sentences = Files.readString(pathToFile).split("\\.");
        for (String temp : sentences) {
            System.out.println(temp.trim() + ".");
        }
    }
}
