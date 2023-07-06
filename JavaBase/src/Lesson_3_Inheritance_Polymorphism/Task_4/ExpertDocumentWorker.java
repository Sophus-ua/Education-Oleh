package Lesson_3_Inheritance_Polymorphism.Task_4;

class ExpertDocumentWorker extends ProDocumentWorker {
    ExpertDocumentWorker() {
    }

    void saveDocument() {
        System.out.println("Документ збережений в новому форматі");
    }
}
