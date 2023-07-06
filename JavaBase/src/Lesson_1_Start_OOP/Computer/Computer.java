package Lesson_1_Start_OOP.Computer;

import java.util.Scanner;

class Computer {
    String object;
    public void setObject(String str) {
        this.object = str;
    }
    public String getObject() {
        return this.object;
    }

    public static void main(String[] args) {
        String[] Computers = new String[5];
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть імена п'ятьох компютерів:");

        for(int i = 0; i < Computers.length; i++) {
            Computer str = new Computer();
            str.setObject(in.next());
            Computers[i] = str.getObject();
        }

        System.out.println("Імена комп'ютерів записаних в масив:");

        for(int i = 0; i < Computers.length; i++) {
            System.out.println(i + 1 + ": " + Computers[i]);
        }

    }
}
