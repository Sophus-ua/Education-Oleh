package Lesson_2.Work_4;

class Car {
    int year, weight;
    double speed;
    String color;
    Car() {
        this(2010);
    }
    Car(int year) {
        this(year, 150.0);
    }
    Car(int year, double speed) {
        this(year, speed, 1300);
    }
    Car(int year, double speed, int weight) {
        this(year, speed, weight, "black");
    }
    Car(int year, double speed, int weight, String color) {
        this.year = year;
        this.weight = weight;
        this.speed = speed;
        this.color = color;
    }
}
