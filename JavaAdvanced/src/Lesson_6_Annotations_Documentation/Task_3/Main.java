package Lesson_6_Annotations_Documentation.Task_3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) {
        BaseClass instance = new BaseClass();
        Class<?> reflectionLink = instance.getClass();
        try {
            Method method = reflectionLink.getDeclaredMethod("baseClassMethod", String.class, Object[].class);
            method.invoke(instance, "Перевірка", new Integer[]{1, 2, 3});
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            System.out.println("Помилка " + e.getMessage());
        }


        Class<?> reflectionLink2 = SubClass.class;
        MyAnnotation annotation = reflectionLink2.getAnnotation(MyAnnotation.class);
        String annotationValue = String.valueOf(annotation.value());
        System.out.println("Аннотація класу SubClass: " + annotationValue);
    }
}
