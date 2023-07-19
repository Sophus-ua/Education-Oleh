package Lesson_6_Annotations_Documentation.Task_2;

/**
 * the class that performs the calculation
 * @author Slyvinskyi Oleh
 */
class Calculation {
    /**
     * @param num_1 first number
     * @param num_2 second number
     * @return result of addition without rounding
     */
    @CalcAnnotation(operation = '+')
    private double add(double num_1, double num_2) {
        return num_1 + num_2;
    }
    /**
     * @param num_1 first number
     * @param num_2 second number
     * @return result of addition with rounding
     */
    @CalcAnnotation(operation = '+', rounding = true)
    private double addRounding(double num_1, double num_2) {
        return Math.round(num_1 + num_2);
    }
    /**
     * @param num_1 first number
     * @param num_2 second number
     * @return result of subtraction without rounding
     */
    @CalcAnnotation(operation = '-')
    private double subtract(double num_1, double num_2) {
        return num_1 - num_2;
    }
    /**
     * @param num_1 first number
     * @param num_2 second number
     * @return result of subtraction with rounding
     */
    @CalcAnnotation(operation = '-', rounding = true)
    private double subtractRounding(double num_1, double num_2) {
        return Math.round(num_1 - num_2);
    }
    /**
     * @param num_1 first number
     * @param num_2 second number
     * @return result of multiplication without rounding
     */
    @CalcAnnotation(operation = '*')
    private double multiply(double num_1, double num_2) {
        return num_1 * num_2;
    }
    /**
     * @param num_1 first number
     * @param num_2 second number
     * @return result of multiplication with rounding
     */
    @CalcAnnotation(operation = '*', rounding = true)
    private double multiplyRounding(double num_1, double num_2) {
        return Math.round(num_1 * num_2);
    }
    /**
     * @param num_1 first number
     * @param num_2 second number
     * @return result of division without rounding
     */
    @CalcAnnotation(operation = '/')
    private double divide(double num_1, double num_2) {
        return num_1 / num_2;
    }
    /**
     * @param num_1 first number
     * @param num_2 second number
     * @return result of division with rounding
     */
    @CalcAnnotation(operation = '/', rounding = true)
    private double divideRounding(double num_1, double num_2) {
        return Math.round(num_1 / num_2);
    }
}
