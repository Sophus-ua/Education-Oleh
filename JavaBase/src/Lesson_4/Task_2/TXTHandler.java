package Lesson_4.Task_2;

class TXTHandler extends AbstractHandler {

    TXTHandler (String name) {
        super(name);
    }
    @Override
    void open() {
        System.out.println("Відкриття TXT файлу: " + super.name);
    }
    @Override
    void create() {
        System.out.println("Створення TXT файлу: " + super.name);
    }
    @Override
    void change() {
        System.out.println("Зміна TXT файлу: " + super.name);
    }
    @Override
    void save() {
        System.out.println("Збереження TXT файлу: " + super.name);
    }
}
