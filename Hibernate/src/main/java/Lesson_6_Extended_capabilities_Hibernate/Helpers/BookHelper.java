package Lesson_6_Extended_capabilities_Hibernate.Helpers;


import Lesson_6_Extended_capabilities_Hibernate.Entity.Book;
import Lesson_6_Extended_capabilities_Hibernate.LibraryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

public class BookHelper {

    private final SessionFactory factory;

    public BookHelper() {
        factory = HibernateUtil.getSessionFactory();
    }



    public Book getBookById(long id) throws LibraryException {
        try (Session session = factory.openSession()) {
            Book book = session.get(Book.class, id);
            if (book == null) throw new LibraryException("Книги з таким ID немає в базі данних");
            return book;
        }
    }


    public long getIdOfBook(String title) throws LibraryException {
        try (Session session = factory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);

            Root<Book> bookRoot = cq.from(Book.class);
            Selection[] selections = {bookRoot.get("id")};
            cq.select(cb.construct(Long.class, selections))
                    .where(cb.equal(bookRoot.<String>get("title"), title));

            Query query = session.createQuery(cq);
            List<Long> booksID = query.getResultList();

            if (booksID.isEmpty()) throw new LibraryException("Книги з такою назвою немає");
            return booksID.get(0);
        }
    }

    /* завдання 3 */
    public void deleteBookByID(long bookID) throws LibraryException {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Book book = session.get(Book.class, bookID);
            if (book == null) throw new LibraryException("Книги з таким ID не має в базі");
            session.delete(book);
            session.getTransaction().commit();
        }
    }

    /* завдання 3 */
    public void deleteBooksByAuthorName(String authorFirstName, String authorLastName) throws LibraryException {
        long authorID = new AuthorHelper().getIdOfAuthor(authorFirstName, authorLastName);
        new AuthorHelper().deleteBooksByAuthorID(authorID);
    }

    public Book addBook(Book book) throws LibraryException {
        long bookID = -1;
        try {
            bookID = getIdOfBook(book.getTitle());
        } catch (LibraryException ignored) {}

        if (bookID == -1) {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.save(book);
                session.getTransaction().commit();

                return book;
            }
        } else return getBookById(bookID);
    }
}
