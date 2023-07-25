package Lesson_8_Thread_Runnable_Problems.task_4;


class FirstClass {
    Main work;
    FirstClass(Main work) {
        this.work = work;
    }
    void show() {
        synchronized (work.monitor) {
            try {
                if (!work.firstTurn) work.monitor.wait();
                work.monitor.wait(600);
            } catch (InterruptedException e) {
                System.out.println("Помилка " + e.getMessage());
            } finally {
                System.out.println("\033[0;93mперший клас...\033[0m");
                work.firstTurn = false;
                work.monitor.notify();
            }
        }
    }
}

