package Lesson_4_JPA_Hibernate.task_6;

import Lesson_4_JPA_Hibernate.task_6.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

class BookHelper {
    private SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();
        Query<Book> query = session.createQuery("from Book", Book.class);
        List<Book> bookList = query.list();
        session.close();

        return bookList;
    }

    public Book getBookById(long id) {
        Session session = sessionFactory.openSession();
        Book book = (Book) session.get(Book.class, id);
        session.close();

        return book;
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
