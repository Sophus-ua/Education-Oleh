package Lesson_3.Task_3;

class Main {

        public static void main(String[] args) {
        Plane privateJet = new Plane(1450000, 1200, 2011, 3750, 9);
        Car honda = new Car(36000, 180, 2017);
        Ship lexusLY650 = new Ship(2200000, 120, 2014, 84, "Одеса");

        privateJet.info();
        honda.info();
        lexusLY650.info();
        }
}
