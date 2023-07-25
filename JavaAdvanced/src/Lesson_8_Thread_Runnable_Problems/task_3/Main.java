package Lesson_8_Thread_Runnable_Problems.task_3;


class Main {
    public static void main(String[] args) {
        Count n = new Count();
        Thread priorityRunner = new Thread(new PriorityRunner(n), "PriorityRunner");
        Thread priorityThread = new Thread(new PriorityThread(n), "priorityThread");

        Thread.currentThread().setPriority(1);
        priorityRunner.setPriority(5);
        priorityThread.setPriority(10);

        priorityRunner.start();
        priorityThread.start();
        for (int i = 0; i < 50; i++) {
            n.show();
        }
    }
}

