package Lesson_4_Abstract_Class_Interface.Task_3;

import java.util.Scanner;

class Main {
    Main() {
    }
    boolean action(String input) {
        Player player = new Player();
        switch (input.toLowerCase()) {
            case "г":
                player.play();
                return true;
            case "п":
                player.pause();
                return true;
            case "с":
                player.stop();
                return false;
            case "з":
                player.record();
                return true;
            default:
                System.err.println("Упссс, введіть доступну дію:");
                return true;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть дію яку потрібно виконати:");

        boolean replay = true;
        while (replay){
            System.out.println("Г:  Грати >>>   П:  Пауза ||");
            System.out.println("З:  Запис ...   \u001b[0;31mС:  Стоп []\u001b[0m");
            replay = main.action(in.next());
        }
    }
}
