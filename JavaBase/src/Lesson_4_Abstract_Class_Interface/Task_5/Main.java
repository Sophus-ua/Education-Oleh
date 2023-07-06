package Lesson_4_Abstract_Class_Interface.Task_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
            ConverterTemperature tToKelvin = new ConverterTemperatureKelvin();
            ConverterTemperature tToFahrenheit = new ConverterTemperatureFahrenheit();
            Scanner in = new Scanner(System.in);

            System.out.println("Введіть температуру за Цельсієм для конвертації:");
            double into = in.nextDouble();
            tToKelvin.convert(into);
            tToFahrenheit.convert(into);
        }
    }
}
