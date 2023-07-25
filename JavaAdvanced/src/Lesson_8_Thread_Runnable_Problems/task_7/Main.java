package Lesson_8_Thread_Runnable_Problems.task_7;

class Main {
    public static void main(String[] args) {
        DaemonClass daemonClass = new DaemonClass();
        Thread daemonThread = new Thread(daemonClass,"Daemon");
        daemonThread.setDaemon(true);

        daemonThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
