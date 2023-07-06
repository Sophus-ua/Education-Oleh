package Lesson_3_Inheritance_Polymorphism.Task_6;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть текст:");

        String value = in.nextLine();
        SubPrinter example = new SubPrinter();
        example.print(value);
    }
}
