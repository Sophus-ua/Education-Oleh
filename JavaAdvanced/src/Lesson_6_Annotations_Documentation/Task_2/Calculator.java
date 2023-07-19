package Lesson_6_Annotations_Documentation.Task_2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class for filling and sending parameters for calculation
 * @author Slyvinskyi Oleh
 */
class Calculator {
    /**
     * numbers for calculation
     */
    private double num_1, num_2;
    /**
     * operation symbol
     */
    private char operation;
    /**
     * the need for rounding
     */
    private boolean rounding;

    /**
     * method for filling numbers
     * @param first pointer is the first or second number
     * @param in    scanner
     */
    void numFill(boolean first, Scanner in) {
        String str = "першу ";
        if (!first) str = "другу ";
        System.out.println("Введіть " + str + "перемінну:");

        try {
            double num = in.nextDouble();
            if (first) num_1 = num;
            else {
                num_2 = num;
                if (operation == '/' && num_2 == 0) throw new ArithmeticException("Ділення на нуль неможливе");
            }
        } catch (InputMismatchException e) {
            System.err.println("Упсс, ви ввели невірні данні");
            System.exit(1);
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
            System.exit(3);
        } finally {
            in.nextLine();
        }
    }

    /**
     * method for filling operation symbol
     * @param in scanner
     */
    void operationFill(Scanner in) {
        System.out.println("Введіть знак арифметичної дії \033[1;36m+ - * /\033[0m :");

        try {
            String operations = "+-/*";
            char operation = in.nextLine().charAt(0);
            if (!operations.contains(String.valueOf(operation))) throw new Exception("Упсс, ви ввели невірні данні");
            this.operation = operation;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
    }

    /**
     * method for filling need for rounding
     * @param in scanner
     */
    void roundingFill(Scanner in) {
        System.out.println("Введіть\033[1;36m ДА \033[0mщоб округлити відповідь");
        String str = "да";
        String str2 = in.nextLine();
        rounding = str.equalsIgnoreCase(str2);
    }

    /**
     * method that sends parameters to be calculated and returns the result of the calculation
     * @return calculation result
     */
    double calculationWithAnnotation() {
        Calculation myCalc = new Calculation();
        double result = 0;

        Method[] methods = myCalc.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            CalcAnnotation annotation = method.getAnnotation(CalcAnnotation.class);
            if (annotation.operation() == operation && annotation.rounding() == rounding) {
                try {
                    result = (double) method.invoke(myCalc, num_1, num_2);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    System.err.println("Виникла помилка: " + e.getMessage());
                }
            }
            method.setAccessible(false);
        }
        return result;
    }
}
