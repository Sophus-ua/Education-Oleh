package Lesson_5_Hibernate;

import Lesson_5_Hibernate.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


class AuthorHelper {

    private final SessionFactory sessionFactory;


    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }


    /* завдання 4-и */
    public void updateAuthorNameByID(long author_ID, String authorName) {
        try (Session session = sessionFactory.openSession()) {
            Author author = session.get(Author.class, author_ID);
            author.setName(authorName);

            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        }
    }


    /* завдання 6-сть */
    public void add200Authors() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            for (int i = 1; i < 201; i++) {
                session.save(new Author("автор № " + i));
                if (i % 10 == 0)
                    session.flush();
            }
            session.getTransaction().commit();
        }
    }

    public long getIdByAuthorName(String name) {
        long id;
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("select id from Author where name = ?1", Long.class);
            query.setParameter(1, name);
            id = query.getResultList().get(0);
        }
        return id;
    }

    public void addAuthor(Author author) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        }
    }
}

