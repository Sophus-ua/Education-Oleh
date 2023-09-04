package Lesson_4_JPA_Hibernate.task_6;

import Lesson_4_JPA_Hibernate.task_6.entity.Author;
import Lesson_4_JPA_Hibernate.task_6.entity.Book;

import java.util.List;

class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.setName("Тарас Шевченко");

        AuthorHelper authorHelper = new AuthorHelper();
        authorHelper.addAuthor(author);
        long idOfAuthor = authorHelper.getIdByAuthorName("Тарас Шевченко");


        Book book1 = new Book();
        book1.setName("Кобзар");
        book1.setAuthor_id(idOfAuthor);
        Book book2 = new Book();
        book2.setName("Заповіт");
        book2.setAuthor_id(idOfAuthor);
        BookHelper bookHelper = new BookHelper();
        bookHelper.addBook(book1);
        bookHelper.addBook(book2);


        Book book = bookHelper.getBookById(1);
        System.out.println("\n\033[0;36m" + book + "\n");

        List<Book> booksList = bookHelper.getBookList();
        for(Book b : booksList)
            System.out.println(b);
        System.out.println("\033[0m");
    }
}
