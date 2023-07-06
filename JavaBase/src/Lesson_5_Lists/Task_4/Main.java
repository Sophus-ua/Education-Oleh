package Lesson_5_Lists.Task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

class Main {
    List<Integer> myArrayList;
    Main() {myArrayList = new ArrayList<>();}

    void fillingArray(){
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            myArrayList.add(random.nextInt(90) + 10);
        }
    }
    void iterationAdd1(){
        ListIterator<Integer> listIterator = myArrayList.listIterator();
        while(listIterator.hasNext()) {
            Integer num = listIterator.next();
            listIterator.set(num+1);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.fillingArray();
        System.out.println(main.myArrayList);

        main.iterationAdd1();
        System.out.println(main.myArrayList);
    }
}
