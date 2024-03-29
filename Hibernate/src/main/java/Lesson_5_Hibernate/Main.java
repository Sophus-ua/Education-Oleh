package Lesson_5_Hibernate;


import Lesson_5_Hibernate.entity.Author;
import Lesson_5_Hibernate.entity.Book;

class Main {
    private void addShevchenkoBooks(AuthorHelper authorHelper, BookHelper bookHelper){
        Author author = new Author();
        author.setName("Тарас Шевченко");

        authorHelper.addAuthor(author);
        long idOfAuthor = authorHelper.getIdByAuthorName("Тарас Шевченко");

        Book book1 = new Book();
        book1.setName("Кобзар");
        book1.setAuthorId(idOfAuthor);
        Book book2 = new Book();
        book2.setName("Заповіт");
        book2.setAuthorId(idOfAuthor);
        bookHelper.addBook(book1);
        bookHelper.addBook(book2);
    }



    public static void main(String[] args) {
        AuthorHelper authorHelper = new AuthorHelper();
        BookHelper bookHelper = new BookHelper();

        new Main().addShevchenkoBooks(authorHelper,bookHelper);

        /* завдання 6-сть */
        authorHelper.add200Authors();

        /* завдання 4-и */
        authorHelper.updateAuthorNameByID(1, "Тарас Григорович Шевченко");
        bookHelper.updateBookNameByID(1, "Сон");

        /* завдання 5-ть */
        String authorsWorks = bookHelper.getAuthorsWorks("Тарас Григорович Шевченко");
        System.out.println("\033[1;36m" + authorsWorks + "\033[0m");
    }
}
