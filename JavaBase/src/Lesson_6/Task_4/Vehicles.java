package Lesson_6.Task_4;

enum Vehicles {
    HONDA(30000), MAZDA(27000), TOYOTA(32000), NISSAN(24000);
    private final int Price;
    Vehicles(int price) {
        this.Price = price;
    }
    private String getColor() {
        return "Black";
    }
    @Override
    public String toString() {
        return this.getColor() + " " + this.name() + " ціною " + this.Price;
    }
}
