package CourseProject.JavaStarter;

import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Methods methods = new Methods();

        /* завдання №1 */
        int number = 987654321;
        System.out.println(methods.getSumDigitsOfNumber(number));

        /* завдання №2 */
        System.out.println(methods.getNumberInReverseOrder(number));

        /* завдання №3 */
        String name = "Oleh";
        System.out.println(methods.numberOfTheName(name));

        /* завдання №4 */
        LocalDate date = LocalDate.now();
        System.out.println(methods.getSumDigitsOfDate(date));
    }
}
