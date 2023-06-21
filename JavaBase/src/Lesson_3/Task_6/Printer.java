package Lesson_3.Task_6;

import java.util.Random;

class Printer {
    final String AnsiReset = "\u001b[0m";
    final String[] ansiColors = {"\u001b[0;31m", "\u001b[0;33m", "\u001b[0;34m", "\u001b[0;35m", "\u001b[0;36m", "\u001b[0;37m"};
    void print(String value) {
        Random random = new Random();
        int randomIndex = random.nextInt(this.ansiColors.length);
        String randomColor = ansiColors[randomIndex];
        System.out.println("\n" + randomColor + value + AnsiReset);
    }
}
