package Lesson_8_Thread_Runnable_Problems.task_3;

class Count {
    int n;
    Count() {n = 0;}
    synchronized void show() {
        if (n == 50) Thread.currentThread().interrupt();
        else {
            System.out.println(Thread.currentThread().getName() + " " + ++n);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Помилка " + e.getMessage());
            }
        }
    }
}
