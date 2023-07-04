package Lesson_9.Task_3;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        MyDictionary<Object> myDictionary = new MyDictionary<>();
        Object concept;

        Scanner in = new Scanner(System.in);
        for (int i = 0; i<2; i++){
            System.out.println("Введіть поняття:");
            concept = in.nextLine();
            System.out.println("Введіть пояснення цього поняття:");
            myDictionary.addPairOfElements(concept,in.nextLine());
        }
        in.close();

        myDictionary.indexer(1);
        myDictionary.numberOfElements();
    }
}
