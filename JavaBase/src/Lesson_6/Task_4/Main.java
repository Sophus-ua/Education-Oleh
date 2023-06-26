package Lesson_6.Task_4;

import java.util.Scanner;

class Main {
    void choice() {
        Scanner in = new Scanner(System.in);

        boolean again = true;
        while(again) {
            System.out.println("\"H\" - Honda\n\"M\" - Mazda\n\"T\" - Toyota\n\"N\" - Nissan");
            switch (in.next().toLowerCase()) {
                case "h":
                    System.out.println(Vehicles.HONDA);
                    again = false;
                    break;
                case "m":
                    System.out.println(Vehicles.MAZDA);
                    again = false;
                    break;
                case "t":
                    System.out.println(Vehicles.TOYOTA);
                    again = false;
                    break;
                case "n":
                    System.out.println(Vehicles.NISSAN);
                    again = false;
                    break;
                default:
                    System.err.println("Упсс, ви ввели недійсний вибір, спробуйте ще раз:");
            }
        }

    }
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Виберіть автомобіль з наявних:");
        main.choice();
    }
}
