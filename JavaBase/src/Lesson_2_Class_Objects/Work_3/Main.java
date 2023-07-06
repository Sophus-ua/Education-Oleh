package Lesson_2_Class_Objects.Work_3;

class Main {
    public static void main(String[] args) {
        Car honda = new Car();
        System.out.printf("%s Honda %d року, швидкість %.0f км/год, вага %dкг;\n", honda.color, honda.year, honda.speed, honda.weight);

        Car toyota = new Car(2012);
        System.out.printf("%s Toyota %d року, швидкість %.0f км/год, вага %dкг;\n", toyota.color, toyota.year, toyota.speed, toyota.weight);

        Car acura = new Car(2015, 170.0);
        System.out.printf("%s Acura %d року, швидкість %.0f км/год, вага %dкг;\n", acura.color, acura.year, acura.speed, acura.weight);

        Car infinity = new Car(2017, 180.0, 1800);
        System.out.printf("%s Infinity %d року, швидкість %3.0f км/год, вага %dкг;\n", infinity.color, infinity.year, infinity.speed, infinity.weight);

        Car lexus = new Car(2020, 160.0, 1750, "blue");
        System.out.printf("%s Lexus %d року, швидкість %.0f км/год, вага %dкг;\n", lexus.color, lexus.year, lexus.speed, lexus.weight);
    }
}
