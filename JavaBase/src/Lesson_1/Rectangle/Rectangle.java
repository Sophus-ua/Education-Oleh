package Lesson_1.Rectangle;

import java.util.Scanner;

public class Rectangle {
    static double side1;
    static double side2;

    public Rectangle() {
    }

    double areaCalculator(double side1, double side2) {
        return side1 * side2;
    }

    double perimeterCalculator(double side1, double side2) {
        return 2.0 * (side1 + side2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть сторони прямокутника:");
        side1 = in.nextDouble();
        side2 = in.nextDouble();
        Rectangle rectangle = new Rectangle();
        System.out.println("Площа прямокутника = " + rectangle.areaCalculator(side1, side2));
        System.out.println("Площа прямокутника = " + rectangle.perimeterCalculator(side1, side2));
    }
}
