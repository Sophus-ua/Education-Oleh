package Lesson_4.Task_2;

import java.util.Scanner;

class Main {
    AbstractHandler file;
    Main() {
    }
    void separation(String str) {
        int index = str.indexOf(".");
        String name = str.substring(0, index);
        String type = str.substring(index + 1);
        this.creation(type, name);
    }
    void creation(String type, String name) {
        if (type.equalsIgnoreCase("xml")) {
            this.file = new XMLHandler(name);
        } else if (type.equalsIgnoreCase("txt")) {
            this.file = new TXTHandler(name);
        } else if (type.equalsIgnoreCase("doc")) {
            this.file = new DOCHandler(name);
        } else {
            System.err.println("Ви ввели неправильний тип файла!!!");
        }

    }

    public static void main(String[] args) {
        Main example = new Main();
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть повну назву документу з розширенням типу: \u001b[0;32mfileName.txt\u001b[0m");
        example.separation(in.next());

        example.file.create();
        example.file.open();
        example.file.change();
        example.file.save();
    }
}
