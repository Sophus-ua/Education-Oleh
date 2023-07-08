package Lesson_1_Iterator_Comparator.Task_3.interface_comparable;


import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Car c1 = new Car(190, 5000, "BMW", "Red");
        Car c2 = new Car(200, 8000, "Opel", "Black");
        Car c3 = new Car(200, 10000, "Acura", "Yellow");
        Car c4 = new Car(200, 10000, "Mercedes", "Green");
        Car c5 = new Car(200, 10000, "Mercedes", "White");

        Car[] c = {c1, c2, c3, c4, c5};
        Arrays.sort(c);

        for (Car temp : c) {
            System.out.println(temp);
        }
    }
}
