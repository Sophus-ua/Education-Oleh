package Lesson_1_JDBC.task_2;


import java.nio.file.Path;
import java.nio.file.Paths;


class main extends Helper {
    public static void main(String[] args) {
        Path filePath = Paths.get("src/Lesson_1_JDBC/task_2/L1_task_2.sql");

        String[] sqlQueries = readSqlQueries(filePath);
        System.out.println("Кількіст sql запитів в файлі: " + sqlQueries.length);


        System.out.println("");
        queryHandler(sqlQueries);
    }
}
