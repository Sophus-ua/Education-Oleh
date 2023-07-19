package Lesson_6_Annotations_Documentation.Task_4;


class MathCalculation {
    @Math(num1 = 1, num2 = 10)
    public void mathSum(int num1, int num2) {
        System.out.println(num1 + num2);
    }
}
