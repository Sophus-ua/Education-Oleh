package Lesson_4_Abstract_Class_Interface.Task_2;

class XMLHandler extends AbstractHandler {

    XMLHandler(String name) {
        super(name);
    }
    @Override
    void open() {
        System.out.println("Відкриття XML файлу: " + super.name);
    }
    @Override
    void create() {
        System.out.println("Створення XML файлу: " + super.name);
    }
    @Override
    void change() {
        System.out.println("Зміна XML файлу: " + super.name);
    }
    @Override
    void save() {
        System.out.println("Збереження XML файлу: " + super.name);
    }
}
