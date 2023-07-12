package Lesson_2_Collections.Task_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class DoubleArrayList {
    List<String> myArray;
    DoubleArrayList(){
        this.myArray = new ArrayList<>();
    }
    void addFiveElements(){
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.printf("Введіть %s-ий елемент\n", (i+1));
            this.myArray.add(in.nextLine());
        }
    }
    void doubleElements(){
        int num = this.myArray.size();
        for (int i = 0; i < num; i++) {
            int processedIndex = i*2;
            this.myArray.add(processedIndex+1, this.myArray.get(processedIndex));
        }
    }

    public static void main(String[] args) {
        DoubleArrayList main = new DoubleArrayList();
        main.addFiveElements();
        main.doubleElements();

        System.out.print("Новий список: ");
        Iterator<String> iterator = main.myArray.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "; ");
        }
    }
}
