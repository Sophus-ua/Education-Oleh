package Lesson_2.Work_3;

class Car {
    int year = 2010;
    double speed = 150.0;
    int weight = 1300;
    String color = "black";
    Car() {}
    Car(int year) {
        this.year = year;
    }
    Car(int year, double speed) {
        this.year = year;
        this.speed = speed;
    }
    Car(int year, double speed, int weight) {
        this.year = year;
        this.speed = speed;
        this.weight = weight;
    }
    Car(int year, double speed, int weight, String color) {
        this.year = year;
        this.speed = speed;
        this.weight = weight;
        this.color = color;
    }
}
