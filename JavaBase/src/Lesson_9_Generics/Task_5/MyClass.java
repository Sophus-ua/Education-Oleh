package Lesson_9_Generics.Task_5;

public class MyClass<T>{
    static <T> T factoryMethod() {
        return  (T) new Object();
    }

    public static void main(String[] args) {
        MyClass instance = MyClass.factoryMethod();

    }
}
