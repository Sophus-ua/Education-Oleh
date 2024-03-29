package Lesson_3_Inheritance_Polymorphism.Task_3;

class Plane extends Vehicle {
    int height, passengers;
    Plane(int price, int speed, int year, int height, int passengers) {
        super(price, speed, year);
        this.height = height;
        this.passengers = passengers;
    }
    void info() {
        System.out.println("_____Літак_____");
        System.out.println("Координати широта: " + this.coordinateLatitude + "; довгота: " + this.coordinateLongitude + ";");
        System.out.println("Ціна: " + this.price);
        System.out.println("Швидкість: " + this.speed);
        System.out.println("Рік: " + this.year);
        System.out.println("Висота: " + this.height);
        System.out.println("Кількість пассажирів: " + this.passengers);
        System.out.println();
    }
}
