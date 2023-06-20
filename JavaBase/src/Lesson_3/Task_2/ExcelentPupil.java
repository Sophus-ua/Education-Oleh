package Lesson_3.Task_2;

class ExcelentPupil extends Pupil {
    ExcelentPupil(String name) {
        super(name);
    }
    @Override
    void study() {
        System.out.println("Навчається відповідально і наполегливо");
    }
    @Override
    void read() {
        System.out.println("Читає багато научної літератури");
    }
    @Override
    void write() {
        System.out.println("Пише каліграфічно без помилок");
    }
    @Override
    void relax() {
        System.out.println("Відпочиває активно з користью для здоров'я");
    }
}
