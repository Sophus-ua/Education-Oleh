package Lesson_3.Task_3;

class Ship extends Vehicle {
    int passengers;
    String port;

    Ship(int price, int speed, int year, int passengers,String port) {
        super(price, speed, year);
        this.passengers = passengers;
        this.port = port;
    }

    void info() {
        System.out.println("_____Яхта_____");
        System.out.println("Координати широта: " + this.coordinateLatitude + "; довгота: " + this.coordinateLongitude + ";");
        System.out.println("Ціна: " + this.price);
        System.out.println("Швидкість: " + this.speed);
        System.out.println("Рік: " + this.year);
        System.out.println("Кількість пассажирів: " + this.passengers);
        System.out.println("Порт прописки: " + this.port);
        System.out.println();
    }
}
