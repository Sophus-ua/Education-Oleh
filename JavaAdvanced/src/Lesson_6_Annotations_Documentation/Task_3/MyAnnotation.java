package Lesson_6_Annotations_Documentation.Task_3;

import java.lang.annotation.*;

/**
 * моя аннотація
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@interface MyAnnotation {
    int value();
}
