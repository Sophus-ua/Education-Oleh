package Lesson_6_Annotations_Documentation.Task_2;


import java.util.Scanner;

/**
 * The Main class to start the calculation
 * @author Slyvinskyi Oleh
 */
public class Main {
    /**
     * start of work with calculations
     * @param args some arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calculator myCalc = new Calculator();

        myCalc.numFill(true,in);
        myCalc.operationFill(in);
        myCalc.numFill(false,in);
        myCalc.roundingFill(in);
        in.close();

        double result = myCalc.calculationWithAnnotation();
        System.out.println("\033[1;35mрезультат: \033[0;97m" + result + "\033[0m");
    }
}
