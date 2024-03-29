package Lesson_1_JDBC.task_6;

import java.sql.*;

public class WorkWithDatabase {

    public WorkWithDatabase() {
        registerDriver();
    }

    public void queryExecutor(String query) {
        try (Connection connection = setConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void printResultToConsole(String query) {
        try (Connection connection = setConnection();
             PreparedStatement statement = connection.prepareStatement(query)){

            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData metaData = result.getMetaData();
            int columnsCount = metaData.getColumnCount();

            while (result.next()) {
                for (int i = 1; i <= columnsCount; i++) {
                    System.out.print("\033[4;32m" + metaData.getColumnName(i) + ":\033[0m " + result.getString(i) + "; ");
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Connection setConnection() {
        String URL = "jdbc:mysql://localhost:3306/test_base_lesson1";
        String LOGIN = "root";
        String PASSWORD = "root";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    private void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
