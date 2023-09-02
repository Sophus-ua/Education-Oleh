package Lesson_2_DAO.task_3.WorkFromConsole;

public class OutputConstants {
    public static final String dashedLine = "\033[1;35m_________________________________________________________________________________\033[0m";
    public static final String inputErrorData = "ви ввели невірні данні, спробуйте ще раз";
    public static final String end = "...введіть \"\033[1;33mEND\033[0m\" для \033[1;32mзавершення створення намиста і виходу\033[0m в головне меню або...";

    static void printMessage(String value, boolean error) {
        if (error) System.err.println(value);
        else System.out.println(value);
    }
}
