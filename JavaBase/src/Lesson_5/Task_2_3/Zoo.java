package Lesson_5.Task_2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Zoo {
    List<String> animals;
    Zoo() {
        animals = new ArrayList<>();
    }
    void recording() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть 8-мь тварин які присутні в зоопарку:");

        for(int i = 0; i < 8; i++) {
            animals.add(i, in.next());
        }
    }

    void delete (){
        ListIterator<String> listIterator = animals.listIterator(animals.size());

        while (listIterator.hasPrevious()){
            int orderOfElement = listIterator.previousIndex()+1;
            listIterator.previous();
            if (orderOfElement == 3 || orderOfElement == 5 || orderOfElement == 7 ) {
                listIterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Zoo main = new Zoo();

        main.recording();
        System.out.println("\u001b[1;35m" + main.animals.toString() + "\u001b[0m");

        main.delete();
        System.out.println("Розмір списку: " + main.animals.size());
        System.out.println("\u001b[1;35m" + main.animals.toString() + "\u001b[0m");
    }
}
