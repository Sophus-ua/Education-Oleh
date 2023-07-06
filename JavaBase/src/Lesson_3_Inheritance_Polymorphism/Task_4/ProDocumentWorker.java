package Lesson_3_Inheritance_Polymorphism.Task_4;

class ProDocumentWorker extends DocumentWorker {
    ProDocumentWorker() {
    }

    void editDocument() {
        System.out.println("Документ відредаговано");
    }

    void saveDocument() {
        System.out.println("Документ збережено у старому форматі, збереження в інших форматах доступне у версії \033[0;35mЕксперт\033[0m");
    }
}
