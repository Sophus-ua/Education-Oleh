package Lesson_5_Reflection.Task_3;

import Lesson_5_Reflection.Task_2.AutoReflection;

class Main {
    public static void main(String[] args) {
        try{
            AutoReflection reflection = new AutoReflection("Lesson_5_Reflection.Task_3.ExampleClass");
            reflection.modifiersShow();
            reflection.fieldsShow();
            reflection.constructorsShow();
            reflection.methodsShow();
        }catch (ClassNotFoundException e){
            System.err.println("Класс не був знайдений");
        }catch (NullPointerException e){
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
