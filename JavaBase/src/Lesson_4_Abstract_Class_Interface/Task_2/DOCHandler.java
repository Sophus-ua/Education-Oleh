package Lesson_4_Abstract_Class_Interface.Task_2;

class DOCHandler extends AbstractHandler {

    DOCHandler (String name) {super(name);}
    @Override
    void open() {
        System.out.println("Відкриття DOC файлу: " + super.name);
    }
    @Override
    void create() {
        System.out.println("Створення DOC файлу: " + super.name);
    }
    @Override
    void change() {
        System.out.println("Зміна DOC файлу: " + super.name);
    }
    @Override
    void save() {
        System.out.println("Збереження DOC файлу: " + super.name);
    }
}
