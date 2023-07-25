package Lesson_8_Thread_Runnable_Problems.task_3;

class PriorityRunner implements  Runnable{
    Count n;
    PriorityRunner(Count n) {
        this.n = n;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            n.show();
        }
    }
}
