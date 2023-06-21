package Lesson_4.Task_5;

import java.util.Scanner;

class ConverterTemperature {
    ConverterTemperature() {
    }
    void convert(double t) {
        System.out.println("Конвертація в Кельвіни: " + (t + 273.15));
        System.out.println("Конвертація в Фаренгейт: " + (t * 1.8 + 32.0));
    }

    public static void main(String[] args) {
        ConverterTemperature main = new ConverterTemperature();
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть температуру за Цельсієм для конвертації:");
        main.convert(in.nextDouble());
    }
}
