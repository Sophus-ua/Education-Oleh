package Lesson_1.Book;

import java.util.Scanner;

public class Book {
    public Book() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть назву книги:");
        Title title = new Title();
        title.setTitle(in.nextLine());
        System.out.println("Введіть ім'я автора:");
        Author author = new Author();
        author.setAuthor(in.nextLine());
        System.out.println("Введіть опис змісту:");
        Content content = new Content();
        content.setContent(in.nextLine());
        System.out.println();
        System.out.println("Назва книги: " + title.show());
        System.out.println("Автор: " + author.show());
        System.out.println("Зміст: " + content.show());
    }

    static class Title {
        String title;

        Title() {
        }

        String show() {
            return this.title;
        }

        void setTitle(String title) {
            this.title = title;
        }
    }

    static class Author {
        String author;

        Author() {
        }

        String show() {
            return this.author;
        }

        void setAuthor(String title) {
            this.author = title;
        }
    }

    static class Content {
        String content;

        Content() {
        }

        String show() {
            return this.content;
        }

        void setContent(String title) {
            this.content = title;
        }
    }
}
