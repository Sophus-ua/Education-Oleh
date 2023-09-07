package Lesson_5_Hibernate.task_6;



import Lesson_5_Hibernate.task_6.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import javax.persistence.criteria.*;
import java.util.List;

class BookHelper {
    private final SessionFactory sessionFactory;

    static class AuthorsWorksList {
        private final String authorName;
        private final String[] booksName;

        AuthorsWorksList(String authorName, String[] booksName) {
            this.authorName = authorName;
            this.booksName = booksName;
        }

        @Override
        public String toString() {
            StringBuilder books = new StringBuilder();
            int count = 0;
            for (String b : booksName) {
                count++;
                if (count == 1)
                    books.append(b);
                else
                    books.append(", ").append(b);
            }

            return "Автор: " + authorName + "; його книги: " + books + ";";
        }
    }

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    /* завдання 4-и */
    public void updateBookNameByID(long book_ID, String bookName) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, book_ID);
        book.setName(bookName);

        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    /* завдання 5-ть */
    public AuthorsWorksList getAuthorsWorksList(String authorName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<String> query = cb.createQuery(String.class);


        Root<Book> bookRoot = query.from(Book.class);
        long authorId = new AuthorHelper().getIdByAuthorName(authorName);
        query.select(bookRoot.get("name"))
                .where(cb.equal(bookRoot.get("authorId"), authorId));


        Query<String> bookResultQuery = session.createQuery(query);
        List<String> bookNames = bookResultQuery.getResultList();

        session.close();
        return new AuthorsWorksList(authorName, bookNames.toArray(new String[0]));
    }

    public Book addBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();

        return book;
    }
}
