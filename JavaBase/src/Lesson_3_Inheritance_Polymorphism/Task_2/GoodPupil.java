package Lesson_3_Inheritance_Polymorphism.Task_2;

class GoodPupil extends Pupil {
    GoodPupil(String name) {
        super(name);
    }
    @Override
    void study() {
        System.out.println("Навчається старанно");
    }
    @Override
    void read() {
        System.out.println("Читає періодично літературу по темі навчання");
    }
    @Override
    void write() {
        System.out.println("Пише без частих помилок");
    }
    @Override
    void relax() {
        System.out.println("Відпочиває за переглядом фільмів, іграми");
    }
}
