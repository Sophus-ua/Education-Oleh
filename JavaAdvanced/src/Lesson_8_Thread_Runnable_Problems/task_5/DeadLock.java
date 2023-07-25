package Lesson_8_Thread_Runnable_Problems.task_5;

class DeadLock {
    public static void main(String[] args) {
        FirstClass firstClass = new FirstClass();
        SecondClass secondClass = new SecondClass();

        firstClass.setSecondClass(secondClass);
        secondClass.setFirstClass(firstClass);

        Thread firstThread = new Thread(firstClass,"\033[1;32mfirstThread");
        Thread secondThread = new Thread(secondClass,"\033[1;33msecondThread");

        firstThread.start();
        secondThread.start();
    }
}
