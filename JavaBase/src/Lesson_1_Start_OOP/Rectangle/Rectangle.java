package Lesson_1_Start_OOP.Rectangle;

import java.util.Scanner;

class Rectangle {
    double side1;
    double side2;
    double areaCalculator(double side1, double side2) {
        return side1 * side2;
    }
    double perimeterCalculator(double side1, double side2) {
        return 2.0 * (side1 + side2);
    }

    public static void main(String[] args) {
        Rectangle main = new Rectangle();
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть сторони прямокутника:");

        main.side1 = in.nextDouble();
        main.side2 = in.nextDouble();

        System.out.println("Площа прямокутника = " + main.areaCalculator(main.side1, main.side2));
        System.out.println("Площа прямокутника = " + main.perimeterCalculator(main.side1, main.side2));
    }
}
