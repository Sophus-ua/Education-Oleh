package Lesson_5_Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;


class HibernateUtil {

    private static SessionFactory factory;
    private static final Logger LOG = Logger.getLogger( HibernateUtil.class.getName() );

    private HibernateUtil(){}

    public synchronized static SessionFactory getSessionFactory() {
        if (factory == null){
            try {
                factory = new Configuration()
                        .configure("hibernate_Lesson5.cfg.xml")
                        .buildSessionFactory();
            } catch (HibernateException e) {
                LOG.error(e);
            }
        }
        return factory;
    }
}
