package Lesson_8_Thread_Runnable_Problems.task_4;


class Main {
    final Object monitor;
    boolean firstTurn;
    Main() {
        monitor = new Object();
        firstTurn = true;
    }
    public static void main(String[] args) {
        Main work = new Main();
        FirstClass firstClass = new FirstClass(work);
        SecondClass secondClass = new SecondClass(work);

        for (; ; ){
            firstClass.show();
            secondClass.show();
        }
    }
}
