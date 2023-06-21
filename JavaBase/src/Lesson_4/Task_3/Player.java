package Lesson_4.Task_3;

class Player implements Playable, Recodable {
    Player() {
    }
    @Override
    public void play() {
        System.out.println("\u001b[1;36m>>> Playing >>> \u001b[0m");
    }
    @Override
    public void pause() {
        System.out.println("\u001b[1;33m|| Pause ||\u001b[0m");
    }
    @Override
    public void stop() {
        System.out.println("\u001b[1;31m[] Stop []\u001b[0m");
    }
    @Override
    public void record() {
        System.out.println("\u001b[1;35m... Recording ...\u001b[0m");
    }
}
