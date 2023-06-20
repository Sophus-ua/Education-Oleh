package Lesson_3.Task_3;

class Car extends Vehicle {
    Car(int price, int speed, int year) {
        super(price, speed, year);
    }
    void info() {
        System.out.println("_____Машина_____");
        System.out.println("Координати широта: " + this.coordinateLatitude + "; довгота: " + this.coordinateLongitude + ";");
        System.out.println("Ціна: " + this.price);
        System.out.println("Швидкість: " + this.speed);
        System.out.println("Рік: " + this.year);
        System.out.println();
    }
}
