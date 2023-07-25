package Lesson_8_Thread_Runnable_Problems.task_2;


class Main {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new UserThread(), "first");
        Thread secondThread = new Thread(new UserThread(), "second");
        firstThread.start();
        secondThread.start();

        System.out.println("виконується поток " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Помилка " + e.getMessage());
        }
        System.out.println("завершення потоку " + Thread.currentThread().getName());
    }
}
