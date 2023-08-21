package Lesson_1_JDBC.task_2;

import Lesson_1_JDBC.task_6.WorkWithDatabase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

class Helper {
    static String[] readSqlQueries(Path filePath) {
        String[] sqlQueries = new String[0];
        try {
            String fileContent = Files.readString(filePath, StandardCharsets.UTF_8);

            sqlQueries = Arrays.stream(fileContent.split(";"))
                    .map(String::trim)
                    .filter(query -> !query.isEmpty())
                    .toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlQueries;
    }

    static void queryHandler(String[] sqlQueries) {
        WorkWithDatabase work = new WorkWithDatabase();

        for (String query : sqlQueries) {
            if (query.toLowerCase().startsWith("select")) {
                work.printResultToConsole(query);
                continue;
            }
            work.queryExecutor(query);
        }
    }
}
