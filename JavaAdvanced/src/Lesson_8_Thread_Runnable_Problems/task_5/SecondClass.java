package Lesson_8_Thread_Runnable_Problems.task_5;

class SecondClass extends Thread {
    FirstClass firstClass;
    void setFirstClass(FirstClass firstClass) {
        this.firstClass = firstClass;
    }
    @Override
    public void run() {
        firstClass.methodFirstClass(Thread.currentThread().getName());
        methodSecondClass(Thread.currentThread().getName());
    }
    synchronized void methodSecondClass(String threadName) {
        System.out.println("\033[1;90mпоток " + threadName + "\033[1;90m працює в методі другого класу...\033[0m");
        try {
            firstClass.join();
            Thread.sleep(600);
        } catch (InterruptedException e) {
            System.err.println("Помилка " + e.getMessage());
        }
        System.out.println("\033[1;90mпоток " + threadName + "\033[1;90m завершив працювати в методі другого класу!!!\033[0m");
    }
}
