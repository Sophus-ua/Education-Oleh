package Lesson_3_Inheritance_Polymorphism.Task_6;

import java.util.Random;

class Printer {
    final String AnsiReset = "\u001b[0m";
    String ansiColor;
    void print(String value) {
        Random random = new Random();
        String[] ansiColors = {"\u001b[0;31m", "\u001b[0;33m", "\u001b[0;34m", "\u001b[0;35m", "\u001b[0;36m", "\u001b[0;37m"};
        int randomIndex = random.nextInt(ansiColors.length);
        this.ansiColor = ansiColors[randomIndex];
        System.out.println("\n" + ansiColor + value + AnsiReset);
    }
}
