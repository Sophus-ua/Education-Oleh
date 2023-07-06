package Lesson_3_Inheritance_Polymorphism.Task_4;

class DocumentWorker {

    DocumentWorker(){}
    void openDocument() {
        System.out.println("Документ відкритий");
    }

    void editDocument() {
        System.out.println("Правка документа доступна у версії \033[0;32mПро\033[0m");
    }

    void saveDocument() {
        System.out.println("Збереження документа доступне у версії \033[0;32mПро\033[0m");
    }
}
