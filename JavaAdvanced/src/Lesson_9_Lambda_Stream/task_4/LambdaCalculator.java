package Lesson_9_Lambda_Stream.task_4;


import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

class LambdaCalculator {
    double calculator() {
        double result = 0;

        try (Scanner in = new Scanner(System.in)) {
            double num1 = numberFilling(1, in);
            DoubleBinaryOperator operator = calculationOperator(in);
            operator.applyAsDouble(1,1);  // ловимо помилку якщо присутня
            double num2 = numberFilling(2, in);

            result = operator.applyAsDouble(num1,num2);

        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.err.println("Упсс, ви ввели невірні данні");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
        return result;
    }
    private double numberFilling(int sequence, Scanner in) throws IllegalArgumentException {
        Function<String, Double> numberRead = Double::parseDouble;
        System.out.println("Введть " + sequence + "-е число");

        double num = numberRead.apply(in.nextLine());
        if (num == 0 && sequence == 2) {
            throw new IllegalArgumentException("Ділення на нуль неможливе");
        } else return num;
    }
    private DoubleBinaryOperator calculationOperator(Scanner in) throws IllegalArgumentException {
        System.out.println("Введіть знак арифметичної дії:");
        char operation = in.nextLine().charAt(0);

        return (x, y) -> {
            if (operation == '/') {
                return x / y;
            } else if (operation == '*') {
                return x * y;
            } else if (operation == '-') {
                return x - y;
            } else if (operation == '+') {
                return x + y;
            } else throw new IllegalArgumentException("Ви ввели невірний знак арифметичної дії");
        };
    }
}
