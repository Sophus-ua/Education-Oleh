package Lesson_1_Iterator_Comparator.Task_3.interface_comparable;

class Car implements Comparable<Car> {
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
    @Override
    public int compareTo(Car o) {
        int temp = this.speed - o.speed;
        if (temp != 0) return temp;
        temp = this.price - o.price;
        if (temp != 0) return temp;
        temp = this.model.compareTo(o.model);
        if (temp != 0) return temp;
        return this.color.compareTo(o.color);
    }
}
