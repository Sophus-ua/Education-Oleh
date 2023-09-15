package Lesson_1_JDBC.task_5;

class main {
    public static void main(String[] args) {
        QueriesFromDatabase work = new QueriesFromDatabase();

        System.out.println("Контактні данні");
        work.selectColumns("e.First_name","e.Last_name", "e.phone", "pi.address");

        System.out.println("");
        System.out.println("Неодружені");
        work.selectWithCondition("pi.marital_status","un%",
                "e.First_name", "pi.date_of_birth", "e.phone");


        System.out.println("");
        System.out.println("Менеджера");
        work.selectWithCondition("jp.position_name","manager",
                "e.First_name", "e.Last_name", "pi.date_of_birth", "e.phone");

    }
}
