package Lesson_3.Task_4;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть ключ доступу або нажміть Enter:");
        String keyExpert = "expert";
        String keyPro = "pro";
        String key = in.nextLine().toLowerCase();
        if (key.equals(keyPro)) {
            DocumentWorker user = new ProDocumentWorker();
            user.openDocument();
            user.editDocument();
            user.saveDocument();
        } else if (key.equals(keyExpert)) {
            DocumentWorker user = new ExpertDocumentWorker();
            user.openDocument();
            user.editDocument();
            user.saveDocument();
        } else {
            DocumentWorker user = new DocumentWorker();
            user.openDocument();
            user.editDocument();
            user.saveDocument();
        }

    }
}
