package Lesson_5_Lists.Task_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Friends {
    List<String> arrayList;
    Friends() {arrayList = new ArrayList<>();}
    void edit() {
        arrayList.add("Кирил");
        arrayList.add("Олена");
        arrayList.add("Микита");
        arrayList.add("Сергій");
        arrayList.add("Анна");
        arrayList.add("Валентин");
        arrayList.add("Деніс");
        arrayList.add("Пилип");
        arrayList.add("Жанна");
        arrayList.add("Світлана");
        arrayList.add("Олексій");
    }

    public static void main(String[] args) {
        Friends main = new Friends();

        main.edit();
        System.out.println("Основний список: " + main.arrayList);

        Collections.sort(main.arrayList);
        System.out.println("   1-й спосіб:   " + main.arrayList);

        String[] array = new String[main.arrayList.size()];
        main.arrayList.toArray(array);
        Arrays.sort(array);
        System.out.println("   2-й спосіб:   " + Arrays.toString(array));
    }
}
