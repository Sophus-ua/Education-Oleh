package Lesson_2_Class_Objects.Work_5;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть радіус кола:");
        System.out.println("Площа кола = " + MyArea.areaOfCircle(in.nextDouble()));
    }
}
