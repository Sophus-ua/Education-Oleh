package Lesson_4_Abstract_Class_Interface.Task_2;

abstract class AbstractHandler {
    String name;
    AbstractHandler(String name) {this.name = name;}

    abstract void open();

    abstract void create();

    abstract void change();

    abstract void save();
}
