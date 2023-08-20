package Lesson_1_JDBC.task_5;


import java.sql.*;


class QueriesFromDatabase {
    private final String URL = "jdbc:mysql://localhost:3306/myjoinsdb";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";
    Connection connection;
    PreparedStatement statement;
    ResultSet result;


    QueriesFromDatabase() {
        registerDriver();
        connection = null;
        statement = null;
        result= null;
    }


    void selectColumns (String... columnNames){
        selectWithCondition(null,null, columnNames);
    }


    void selectWithCondition (String fieldForCondition, String condition, String... columnNames) {
        try {
            executeOfStatement(fieldForCondition, condition, columnNames);
            printResultToConsole(columnNames);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void executeOfStatement(String fieldForCondition, String condition, String[] columnNames) throws SQLException {
        String SelectAllColumns = "select " +
                String.join(", ", columnNames) +
                " from job_position as jp" +
                " join employees as e on e.position_id = jp.id" +
                " join personal_info as pi on pi.employees_id = e.id";
        if (fieldForCondition != null && condition != null)
            SelectAllColumns += (" where " + fieldForCondition + " like \'" + condition + "\'");

        connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        statement = connection.prepareStatement(SelectAllColumns);
        result = statement.executeQuery();
    }

    private void printResultToConsole(String[] columnNames) throws SQLException {
        while (result.next()) {
            for (int i = 0; i < columnNames.length; i++) {
                System.out.print("\033[4;32m" + columnNames[i] + ":\033[0m " + result.getString(i + 1) + "; ");
            }
            System.out.println("");
        }
        connection.close();
        statement.close();
        result.close();
    }


    private void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
