package Lesson_6_Annotations_Documentation.Task_4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Main {
    public static void main(String[] args) {
        MathCalculation instanceOfClass = new MathCalculation();
        Class<?> reflectionLink = instanceOfClass.getClass();
//         Class<?> reflectionLink = MathCalculation.class;
//         Class<?> reflectionLink = Class.forName("Lesson_6_Annotations_Documentation.Task_4.MathCalculation");

        try {
            Method method = reflectionLink.getMethod("mathSum", int.class, int.class);
            Math annotation = method.getAnnotation(Math.class);

            method.invoke(instanceOfClass, annotation.num1(), annotation.num2());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Помилка" + e.getMessage());
        }
    }
}
