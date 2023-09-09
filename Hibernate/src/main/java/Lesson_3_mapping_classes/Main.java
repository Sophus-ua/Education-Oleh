package Lesson_3_mapping_classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class Main {
    public static void main(String[] args) {
        AnimalMapping animalMapping = new AnimalMapping();
        animalMapping.setAge(7);
        animalMapping.setName("Мавр");
        animalMapping.setTail(true);
        animalMapping.setId(1);


        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(animalMapping);
        session.getTransaction().commit();
        session.close();
    }
}
