package Lesson_6_Extended_capabilities_Hibernate.Helpers;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



class HibernateUtil {

    private static SessionFactory factory;


    private HibernateUtil() {
    }

    public synchronized static SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration()
                    .configure("hibernate_Lesson6.cfg.xml")
                    .buildSessionFactory();
        }
        return factory;
    }
}
