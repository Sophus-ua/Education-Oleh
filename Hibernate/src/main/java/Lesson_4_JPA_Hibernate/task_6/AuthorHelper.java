package Lesson_4_JPA_Hibernate.task_6;

import Lesson_4_JPA_Hibernate.task_6.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;


class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }


    public long getIdByAuthorName(String name) {
        Session session = sessionFactory.openSession();
        Query<Long> query = session.createQuery("select id from Author where name = ?1", Long.class);
        query.setParameter(1, name);
        long id = query.getResultList().get(0);
        session.close();

        return id;
    }



    public List<Author> getAuthorList() {
        Session session = sessionFactory.openSession();
        Query<Author> query = session.createQuery("from Author", Author.class);
        List<Author> authorList = query.list();
        session.close();

        return authorList;
    }

    public Author getAuthorById(long id) {
        Session session = sessionFactory.openSession();
        Author author = (Author) session.get(Author.class, id);
        session.close();

        return author;
    }

    public Author addAuthor(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();

        return author;
    }
}
