package Lesson_3_Inheritance_Polymorphism.Task_2;

class Pupil {
    String name;
    Pupil(String name) {
        this.name = name;
    }

    void study() {
        System.out.println("навчається");
    }

    void read() {
        System.out.println("читає");
    }

    void write() {
        System.out.println("пише");
    }

    void relax() {
        System.out.println("відпочиває");
    }
}