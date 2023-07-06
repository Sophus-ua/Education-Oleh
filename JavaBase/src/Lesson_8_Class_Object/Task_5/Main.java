package Lesson_8_Class_Object.Task_5;

class Main {
    public static void main(String[] args) {
        Animal galapagosTortoises = new Animal ("Васька",45, false);
        Animal tortoises = new Animal ("Васька",45, false);

        System.out.println(galapagosTortoises);
        System.out.println("\nПорівнюєм тварин: " + galapagosTortoises.equals(tortoises));
        System.out.println("Хешкод Галапагоської черепахи: " + galapagosTortoises.hashCode());
        System.out.println("Хешкод черепахи: " + tortoises.hashCode());
    }
}
