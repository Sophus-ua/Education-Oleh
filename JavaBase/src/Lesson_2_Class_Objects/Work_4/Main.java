package Lesson_2_Class_Objects.Work_4;

class Main {
    public static void main(String[] args) {
        Car audi = new Car();
        System.out.printf("%s Audi %d року, швидкість %.0f км/год, вага %dкг;\n", audi.color, audi.year, audi.speed, audi.weight);

        Car volkswagen = new Car(2012);
        System.out.printf("%s Volkswagen %d року, швидкість %.0f км/год, вага %dкг;\n", volkswagen.color, volkswagen.year, volkswagen.speed, volkswagen.weight);

        Car bmw = new Car(2014, 170.0);
        System.out.printf("%s BMW %d року, швидкість %2.0f км/год, вага %dкг;\n", bmw.color, bmw.year, bmw.speed, bmw.weight);

        Car rangeRover = new Car(2017, 180.0, 1400);
        System.out.printf("%s Range Rover %d року, швидкість %.0f км/год, вага %dкг;\n", rangeRover.color, rangeRover.year, rangeRover.speed, rangeRover.weight);

        Car skoda = new Car(2016, 140.0, 1350, "blue");
        System.out.printf("%s Skoda %d року, швидкість %.0f км/год, вага %dкг;\n", skoda.color, skoda.year, skoda.speed, skoda.weight);
    }
}
