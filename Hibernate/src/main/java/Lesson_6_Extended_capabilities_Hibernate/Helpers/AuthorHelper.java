package Lesson_6_Extended_capabilities_Hibernate.Helpers;


import Lesson_6_Extended_capabilities_Hibernate.Entity.Author;
import Lesson_6_Extended_capabilities_Hibernate.Entity.Book;
import Lesson_6_Extended_capabilities_Hibernate.LibraryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;


public class AuthorHelper {

    private final SessionFactory factory;
    private Session openedSession;

    public AuthorHelper() {
        factory = HibernateUtil.getSessionFactory();
    }

    public Author getAuthorById(long id) throws LibraryException {
        return getAuthorById(id, true);
    }

    private Author getAuthorById(long id, boolean toCloseSession) throws LibraryException {
        Session session = factory.openSession();
        Author author = session.get(Author.class, id);
        if (toCloseSession) session.close();
        else this.openedSession = session;

        if (author == null) throw new LibraryException("Автора з таким ID нема в базі данних");
        else return author;
    }

    public long getIdOfAuthor(String firstName, String lastName) throws LibraryException {
        try (Session session = factory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);

            Root<Author> authorRoot = cq.from(Author.class);
            Selection[] selections = {authorRoot.get("id")};
            cq.select(cb.construct(Long.class, selections))
                    .where(cb.and(
                                    cb.equal(authorRoot.<String>get("firstName"), firstName),
                                    cb.equal(authorRoot.<String>get("lastName"), lastName)
                            )
                    );

            Query query = session.createQuery(cq);
            List<Long> authorsID = query.getResultList();
            if (authorsID.isEmpty()) throw new LibraryException("Автора з таким ім'ям не має в базі данних");
            return authorsID.get(0);
        }
    }

    public Author addAuthor(Author author) throws LibraryException {
        long authorID = -1;
        try {
            authorID = getIdOfAuthor(author.getFirstName(), author.getLastName());
        } catch (LibraryException ignored) {}

        try (Session session = factory.openSession()) {
            if (authorID == -1) {
                session.beginTransaction();
                session.save(author);
                session.getTransaction().commit();

                return author;
            } else return getAuthorById(authorID);
        }
    }

    public void updateAuthor(Author author) throws LibraryException {
        try (Session session = factory.openSession()) {
            List<Author> authors = getAuthorList();
            for (Author a : authors)
                if (a.equals(author)) throw new LibraryException("Такий автор вже є в базі з ID: " + a.getId());

            session.beginTransaction();
            session.update(author);
            session.getTransaction().commit();
        }
    }

    public void changeFirstNameByID(long id, String newAuthorFirstName) throws LibraryException {
        Author author;
        try (Session session = factory.openSession()) {
            author = getAuthorById(id);
        }
        author.setFirstName(newAuthorFirstName);
        updateAuthor(author);
    }

    /* завдання 3 */
    public void deleteBooksByAuthorID(long id) throws LibraryException {
        try (Session session = factory.openSession()) {
            Author author = getAuthorById(id, false);
            List<Book> books = author.getBooks();
            if (books == null || books.isEmpty())
                throw new LibraryException("Книг цього автора немає в базі данних");

            int count = 0;
            for (Book b : books) {
                new BookHelper().deleteBookByID(b.getId());
                count++;
            }
            System.out.println("\033[4;36mБуло видалено " + count + " книг автора " + author.getFirstName() + " " + author.getLastName() + "\033[0m");
        } finally {
            getOpenedSession().close();
        }
    }

    public List<Author> getAuthorList() {
        try (Session session = factory.openSession();) {
            Query query = session.createQuery("from Author", Author.class);
            List<Author> authorList = query.getResultList();

            return authorList;
        }
    }

    /* завдання 5 */
    public List<Author> findAuthorsByLastName (String lastName) throws LibraryException {
        try(Session session = factory.openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Author> cQuery = cb.createQuery(Author.class);

            Root<Author> authorRoot = cQuery.from(Author.class);
            cQuery.select(authorRoot).where(cb.equal(authorRoot.get("lastName"), lastName));

            Query query = session.createQuery(cQuery);
            List<Author> authors = query.getResultList();

            if (authors == null) throw new LibraryException("Автора з таким 'Last Name' немає в базі");
            return authors;
        }
    }

    private Session getOpenedSession() {
        return openedSession;
    }
}
