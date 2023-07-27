package Lesson_9_Lambda_Stream.task_3;

import java.util.Comparator;


class Book {
    final private String title;
    final private String author;
    final private int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    Comparator<Book> getComparator() {
        return Comparator.comparingInt(book -> book.yearOfPublication);
    }

    @Override
    public String toString () {
        return yearOfPublication + " \"" + title + "\", " + author;
    }
}





