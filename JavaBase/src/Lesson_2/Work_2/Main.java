package Lesson_2.Work_2;

class Main {
    public static void main(String[] args) {
        Car lexus = new Car();
        System.out.println(lexus.color + " Lexus: " + lexus.year + " рік;");

        Car acura = new Car(2015);
        System.out.println(acura.color + " Acura: " + acura.year + " рік;");

        Car infinity = new Car(2018, "red");
        System.out.println(infinity.color + " Infinity: " + infinity.year + " рік;");
    }
}
