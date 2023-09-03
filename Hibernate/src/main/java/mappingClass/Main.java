package mappingClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setAge(7);
        animal.setName("Мавр");
        animal.setTail(true);
        animal.setId(1);


        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(animal);
        session.getTransaction().commit();
        session.close();
    }
}
