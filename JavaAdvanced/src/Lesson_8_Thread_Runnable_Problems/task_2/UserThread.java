package Lesson_8_Thread_Runnable_Problems.task_2;

class UserThread implements  Runnable{
    @Override
    public void run() {
        System.out.println("виконується поток " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Помилка " + e.getMessage());
        }
        System.out.println("завершення потоку " + Thread.currentThread().getName());
    }
}
