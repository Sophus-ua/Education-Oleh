package Lesson_6_Extended_capabilities_Hibernate;

import Lesson_6_Extended_capabilities_Hibernate.Entity.Author;
import Lesson_6_Extended_capabilities_Hibernate.Entity.Book;
import Lesson_6_Extended_capabilities_Hibernate.Helpers.AuthorHelper;
import Lesson_6_Extended_capabilities_Hibernate.Helpers.BookHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

class HomeWork {
    /* завдання 3 */
    public void deleteBooks(BookHelper bookHelper){
        try {
            bookHelper.deleteBooksByAuthorName("Mark", "Ploirier");
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }
        try {
            bookHelper.deleteBookByID(5);
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }
    }

    /* завдання 2 */
    public void updateNameWhereMoreThan7(AuthorHelper authorHelper) {
        List<Author> authorList = authorHelper.getAuthorList();
        for (Author a : authorList){
            if(a.getLastName().length() > 6)
                try {
                    authorHelper.changeFirstNameByID(a.getId(),"1");
                } catch (LibraryException e){
                    System.out.println(e.getMessage());
                }
        }
    }

    public void addAuthorsAndBooks(AuthorHelper authorHelper, BookHelper bookHelper) {
        UnaryOperator<Author> unaryAuthor = x -> {
            Author author = null;
            try {
                author = authorHelper.addAuthor(x);
            } catch (LibraryException e) {
                System.err.println(e.getMessage());
            }
            return author;
        };
        Author firsAuthor = unaryAuthor.apply(new Author("Стивен", "Кинг"));
        Author secondAuthor = unaryAuthor.apply(new Author("Питер", "Страуб"));
        Author thirdAuthor = unaryAuthor.apply(new Author("Оуэн", "Кинг"));
        Author foursAuthor = unaryAuthor.apply(new Author("Mark", "Poirier"));


        UnaryOperator<Book> unaryBook = x -> {
            Book book = null;
            try {
                book = bookHelper.addBook(x);
            } catch (LibraryException e) {
                System.err.println(e.getMessage());
            }
            return book;
        };
        Book firstBook = new Book("Талісман");
        firstBook.setAuthors(new ArrayList<>(Arrays.asList(firsAuthor, secondAuthor)));
        unaryBook.apply(firstBook);
        Book secondBook = new Book("Чорний Будинок");
        secondBook.setAuthors(new ArrayList<>(Arrays.asList(firsAuthor, secondAuthor)));
        unaryBook.apply(secondBook);
        Book thirdBook = new Book("Сплячі красуні");
        thirdBook.setAuthors(new ArrayList<>(Arrays.asList(firsAuthor, thirdAuthor)));
        unaryBook.apply(thirdBook);
        Book fourthBook = new Book("Intro to Alien Invasion");
        fourthBook.setAuthors(new ArrayList<>(Arrays.asList(thirdAuthor, foursAuthor)));
        unaryBook.apply(fourthBook);
        Book fifthBook = new Book("Гра Джеральда");
        fifthBook.setAuthors(new ArrayList<>(Arrays.asList(firsAuthor)));
        unaryBook.apply(fifthBook);
    }
}
