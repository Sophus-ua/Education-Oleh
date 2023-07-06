package Lesson_7_Exceptions.Task_5;

import java.util.Scanner;

class Calculator {
    private double a, b;
    private char operation;

    void calculations (){
        switch (operation){
            case '+' :
                System.out.println("Результат: " +(a+b));
                break;
            case '-' :
                System.out.println("Результат: " +(a-b));
                break;
            case '*' :
                System.out.println("Результат: " +(a*b));
                break;
            case '/' :
                try {
                    if (b == 0) throw new ArithmeticException("\033[0;31mДілення на нуль неможливе :(\033[0m");
                    System.out.println("Результат: " +(a/b));
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
        }
    }
    double inDoubleCheck (){
        Scanner in = new Scanner(System.in);
        double num = 0;

        boolean replay = true;
        while (replay){
            try{
                if (!in.hasNextDouble()) {
                    throw new Exception("\033[0;31mВи ввели невірні данні, спробуйте ще раз\033[0m");
                }
                num = in.nextDouble();
                replay = false;
            }catch (Exception e) {
                System.out.println(e.getMessage());
                in.nextLine();
            }
        }
        return num;
    }
    char operationCheck (){
        Scanner in = new Scanner(System.in);
        String check = "+-*/";
        char operation = ' ';

        boolean replay = true;
        while (replay){
            operation = in.next().charAt(0);
            try {
                if (!check.contains(Character.toString(operation))) {
                    throw new Exception("\033[0;31mУпс ви ввели невірну дію, спробуйте ще раз:\033[0m");
                }
                replay = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
                in.nextLine();
            }
        }
        return operation;
    }

    public static void main(String[] args) {
        Calculator main = new Calculator();

        System.out.println("Введіть перший аргумент:");
        main.a = main.inDoubleCheck();

        System.out.println("Введіть знак потрібної дії \" +  -  *  / \"");
        main.operation = main.operationCheck();

        System.out.println("Введіть другий аргумент:");
        main.b = main.inDoubleCheck();

        main.calculations();
    }
}
