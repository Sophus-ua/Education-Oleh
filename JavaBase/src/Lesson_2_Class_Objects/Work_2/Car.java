package Lesson_2_Class_Objects.Work_2;

class Car {
    int year = 2010;
    String color = "black";
    Car(){}
    Car(int year) {
        this.year = year;
    }
    Car(int year, String color) {
        this.year = year;
        this.color = color;
    }
}
