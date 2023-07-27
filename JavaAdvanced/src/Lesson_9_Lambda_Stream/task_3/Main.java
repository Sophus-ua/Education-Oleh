package Lesson_9_Lambda_Stream.task_3;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Book> booksJackLondon = new ArrayList<>() {
            {
                add(new Book("White Fang", "Jack London", 1906));
                add(new Book("The Sea-Wolf", "Jack London", 1904));
                add(new Book("The Call of the Wild", "Jack London", 1903));
            }
        };

        System.out.println("\033[0;32mСтворенний список книг:\033[0m");
        for (Book book : booksJackLondon) {
            System.out.println(book.toString());
        }

        booksJackLondon.sort(booksJackLondon.get(0).getComparator());

        System.out.println("\n\033[0;32mВідсортованний список книг по року видавництва:\033[0m");
        for (Book book : booksJackLondon) {
            System.out.println(book.toString());
        }
    }
}
