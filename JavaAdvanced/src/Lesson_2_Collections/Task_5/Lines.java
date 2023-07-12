package Lesson_2_Collections.Task_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Lines {
    List<String> list;
    Lines (){
        list = new ArrayList<>();
    }
    void filling(){
        Scanner in = new Scanner(System.in);

        boolean replay = true;
        while (replay){
            System.out.println("Введіть рядок для додавання до списку або \033[4;31mEND\033[0m для завершення запису:");

            String into = in.nextLine();
            String end = "end";
            if (end.equalsIgnoreCase(into)){
                replay = false;
            }else{
                list.add(into);
            }
        }
    }

    public static void main(String[] args) {
        Lines myList = new Lines();
        myList.filling();

        Iterator<String> iterator = myList.list.iterator();
        System.out.println("\n\033[1;35mСтворенний список рядків:\033[0m");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
