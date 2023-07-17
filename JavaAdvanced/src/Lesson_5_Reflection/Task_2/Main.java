package Lesson_5_Reflection.Task_2;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Введіть ім'я классу до якого потрібно застосувати Рефлексію:");

        //як приклад Lesson_5_Reflection.Task_3.ExampleClass
        try(Scanner in = new Scanner(System.in)){
            AutoReflection autoReflection = new AutoReflection(in.nextLine());
            autoReflection.modifiersShow();
            autoReflection.fieldsShow();
            autoReflection.constructorsShow();
            autoReflection.methodsShow();
        }catch (ClassNotFoundException e){
            System.err.println("Класс не був знайдений");
        }catch (NullPointerException e){
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
