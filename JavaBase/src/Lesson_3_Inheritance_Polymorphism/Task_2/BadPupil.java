package Lesson_3_Inheritance_Polymorphism.Task_2;

class BadPupil extends Pupil {
    BadPupil(String name) {
        super(name);
    }
    @Override
    void study() {
        System.out.println("Навчається не старанно, пропускає періодично уроки");
    }
    @Override
    void read() {
        System.out.println("Практично не читає");
    }
    @Override
    void write() {
        System.out.println("Пише з велико. кількістью помилок і помарок");
    }
    @Override
    void relax() {
        System.out.println("Відпочиває нерідко з алкоголем і цигарками");
    }
}
