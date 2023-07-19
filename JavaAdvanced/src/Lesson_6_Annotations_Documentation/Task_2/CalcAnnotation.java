package Lesson_6_Annotations_Documentation.Task_2;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * annotation interface to the Calculation class
 * @author Slyvinskyi Oleh
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CalcAnnotation {
    /**
     * @return char of operation
     */
    char operation();

    /**
     * @return rounding boolean
     */
    boolean rounding() default false;
}
