package Lesson_1_Iterator_Comparator.Task_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(i, 2*i-9);
        }

        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next().toString() + "  ");
        }
    }
}
