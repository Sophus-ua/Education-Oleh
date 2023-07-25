package Lesson_8_Thread_Runnable_Problems.task_6;

class FirstClass extends Thread {
    SecondClass secondClass;
    void setSecondClass(SecondClass secondClass) {
        this.secondClass = secondClass;
    }
    @Override
    public void run() {
        secondClass.methodSecondClass(Thread.currentThread().getName());
        methodFirstClass(Thread.currentThread().getName());
    }
    synchronized void methodFirstClass(String threadName) {
        System.out.println("поток " + threadName + "\033[0m працює в методі першого класу...\033[0m");
        try {
//            secondClass.join();
            Thread.sleep(600);
        } catch (InterruptedException e) {
            System.err.println("Помилка " + e.getMessage());
        }
        System.out.println("поток " + threadName + "\033[0m завершив працювати в методі першого класу!!!\033[0m");
    }
}
