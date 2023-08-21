package Lesson_1_JDBC.task_6;

import java.util.ArrayList;
import java.util.List;


class Main {
    public static void main(String[] args) {
        WorkWithDatabase workDatabase = new WorkWithDatabase();

        List<String> listOfQueries = new ArrayList<>();
        listOfQueries.add("create table Job_position " +
                "(ID int auto_increment not null, " +
                "position_name varchar(30) not null, " +
                "base_salary double, " +
                "constraint pk_id primary key (ID))");
        listOfQueries.add("insert into Job_position " +
                "(position_name, base_salary) " +
                "values " +
                "('Chief_director', 10000), " +
                "('Manager', 2500), " +
                "('Worker', 1500); ");
        listOfQueries.add("Update Job_position " +
                "set base_salary = 12000 where position_name = 'Chief_director';");
        listOfQueries.add("alter table Job_position " +
                "add bonus int;");


        for (int i = 0; i < listOfQueries.size(); i++) {
            workDatabase.queryExecutor(listOfQueries.get(i));
        }

        String query = "select * from Job_position";
        workDatabase.printResultToConsole(query);
    }
}
