package Lesson_6_Annotations_Documentation.Task_3;


import java.util.Arrays;

@MyAnnotation(11)
class BaseClass {
    @SafeVarargs
    final <T> void baseClassMethod (String someString, T... args) {
        System.out.println(someString + " " + Arrays.toString(args));
    }
}
