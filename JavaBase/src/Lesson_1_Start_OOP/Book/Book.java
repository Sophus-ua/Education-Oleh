package Lesson_1_Start_OOP.Book;

import java.util.Scanner;

class Book {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Title title = new Title();
        System.out.println("Введіть назву книги:");
        title.setTitle(in.nextLine());

        Author author = new Author();
        System.out.println("Введіть ім'я автора:");
        author.setAuthor(in.nextLine());

        Content content = new Content();
        System.out.println("Введіть опис змісту:");
        content.setContent(in.nextLine());

        System.out.println("\nНазва книги: " + title.show());
        System.out.println("Автор: " + author.show());
        System.out.println("Зміст: " + content.show());
    }
}

