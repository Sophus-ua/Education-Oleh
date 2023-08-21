package Lesson_1_JDBC.task_6;

import java.sql.*;

public class WorkWithDatabase {
    private final String URL = "jdbc:mysql://localhost:3306/test_base_lesson1";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    public WorkWithDatabase() {
        registerDriver();
    }

    public void queryExecutor(String query) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(query);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void printResultToConsole(String query) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);

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
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }


    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
