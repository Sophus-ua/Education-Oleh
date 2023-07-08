package Lesson_1_Iterator_Comparator.Task_3.interface_comparator_with_anonymous;

import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args) {
        Car c1 = new Car(150, 4000, "BMW", "Red");
        Car c2 = new Car(180, 6000, "Opel", "Black");
        Car c3 = new Car(180, 8000, "Acura", "Yellow");
        Car c4 = new Car(180, 8000, "Mercedes", "Green");
        Car c5 = new Car(180, 8000, "Mercedes", "White");

        Car[] c = {c1, c2, c3, c4, c5};
        Arrays.sort(c, new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                int temp = o1.speed - o2.speed;
                if (temp == 0) {
                    temp = o1.price - o2.price;
                    if(temp == 0){
                        temp = o1.model.compareTo(o2.model);
                        if(temp == 0){
                            return o1.color.compareTo(o2.color);
                        }else return temp;
                    }else return temp;
                } else return temp;
            }
        });

        for (Car temp : c) {
            System.out.println(temp);
        }
    }
}
