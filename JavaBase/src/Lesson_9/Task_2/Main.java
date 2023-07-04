package Lesson_9.Task_2;

import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        MyList<Integer> notebook = new MyList<>();

        for (int i = 0; i<3; i++){
            Scanner in = new Scanner(System.in);
            boolean replay = true;
            while (replay){
                System.out.println("Введіть " + (i+1) + "-ий запис");
                try {notebook.add(in.nextInt());
                    replay = false;
                }catch (InputMismatchException e){
                    System.out.println("Ви ввели невірний тип данних ");
                    in.nextLine();
                }
            }
            in.close();
        }

        System.out.println("Розмір списку " + notebook.size() + " елемента(ів)");
        System.out.println("Другий елемент списку: " + notebook.get(1));
    }
}
