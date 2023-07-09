package Lesson_1_Iterator_Comparator.Task_3.interface_comparator_with_anonymous;

class Car{
    int speed, price;
    String model, color;
    Car(int speed, int price, String model, String color) {
        this.speed = speed;
        this.price = price;
        this.model = model;
        this.color = color;
    }
    public String toString() {
        return this.speed + " " + this.price + " " + this.model + " " + this.color;
    }
}
