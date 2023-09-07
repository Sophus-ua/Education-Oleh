package Lesson_5_Hibernate;


import Lesson_5_Hibernate.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;

class BookHelper {
    private final SessionFactory sessionFactory;

    @FunctionalInterface
    private interface AuthorsWorksList {
        String getString(String authorName, String[] booksName);
    }

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    /* завдання 4-и */
    public void updateBookNameByID(long book_ID, String bookName) {
        try (Session session = sessionFactory.openSession()) {
            Book book = session.get(Book.class, book_ID);
            book.setName(bookName);

            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        }
    }

    /* завдання 5-ть */
    public String getAuthorsWorks(String authorName) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<String> query = cb.createQuery(String.class);


            Root<Book> bookRoot = query.from(Book.class);
            long authorId = new AuthorHelper().getIdByAuthorName(authorName);
            query.select(bookRoot.get("name"))
                    .where(cb.equal(bookRoot.get("authorId"), authorId));


            Query<String> bookResultQuery = session.createQuery(query);
            List<String> bookNamesList = bookResultQuery.getResultList();
            String[] bookNamesArray = bookNamesList.toArray(new String[0]);

            AuthorsWorksList authorsWorksList = (x, y) -> {
                StringBuilder books = new StringBuilder();
                for (int i = 0; i < y.length; i++) {
                    if (i == 0) books.append(y[i]);
                     else books.append(", ").append(y[i]);
                }
                return "Автор: " + x + "; його книги: " + books + ";";
            };

            return authorsWorksList.getString(authorName,bookNamesArray);
        }
    }

    public Book addBook(Book book) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();

            return book;
        }
    }

}
