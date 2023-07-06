package Lesson_5_Lists.Task_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    List<String> arrayList;
    Main() {arrayList = new ArrayList<>();}
    void edit() {
        this.arrayList.add("Оксана федорчук");
        this.arrayList.add("Катерина Макаревич");
        this.arrayList.add("Світлана назаренко");
        this.arrayList.add("Олексій Коршиков");
        this.arrayList.add("Олег Стеценко");
        this.arrayList.add("Олексій Кухар");
        this.arrayList.add("Анна Корчевнікова");
        this.arrayList.add("Анастасія Козел");
        this.arrayList.add("Лідія Черновецька");
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        main.edit();

        System.out.println("Введіть ім'я і фамілію найкращого вчителя: ");
        int indexOfBestTeacher = main.arrayList.indexOf(in.nextLine());
        System.out.println("Введіть ім'я і фамілію самого вредного вчителя: ");
        int indexOfHarmfulTeacher = main.arrayList.indexOf(in.nextLine());

        System.out.println(main.arrayList);
        System.out.println("Індекс в списку найкращого вчителя: " + indexOfBestTeacher);
        System.out.println("Індекс в списку самого вредного вчителя: " + indexOfHarmfulTeacher);
    }
}
