package Lesson_4_JPA_Hibernate.task_6;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


class HibernateUtil {
    private static SessionFactory factory;
    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (factory == null){
            try {
                factory = new Configuration()
                        .configure("hibernate_Lesson4_task6.cfg.xml")
                        .buildSessionFactory();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }

        return factory;
    }

}
