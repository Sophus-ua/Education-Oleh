package Lesson_8_Thread_Runnable_Problems.task_7;

class DaemonClass extends Thread {
    @Override
    public void run(){
        showDetails();
    }
    void showDetails () {
        System.out.println("Ім'я потоку \033[1;33m" + Thread.currentThread().getName());
        System.out.println("\033[0mЧи є потік daemon? \033[1;33m" + Thread.currentThread().isDaemon());
        System.out.println("\033[0mІм'я классу потоку \033[1;33m" + Thread.currentThread().getClass().getName());
        System.out.println("\033[0mПріоритет потоку \033[1;33m" + Thread.currentThread().getPriority());
        System.out.println("\033[0mунікальний id потоку \033[1;33m" + Thread.currentThread().getId());
        System.out.println("\033[0mhashCode потоку \033[1;33m" + Thread.currentThread().hashCode());
        System.out.println("\033[0mЧи живий цей потік? \033[1;33m" + Thread.currentThread().isAlive());
        System.out.println("\033[0mЧи прирваний цей потік? \033[1;33m" + Thread.currentThread().isInterrupted());
        System.out.println("\033[0mстан потоку \033[1;33m" + Thread.currentThread().getState());
    }
}
