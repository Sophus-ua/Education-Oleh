package Lesson_4_JPA_Hibernate.task_7;



import Lesson_4_JPA_Hibernate.task_7.entity.Animal;


import javax.persistence.*;
import java.util.List;

class AnimalHelper {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public AnimalHelper() {
        emf = Persistence.createEntityManagerFactory("myUnit");
        em = emf.createEntityManager();
    }

    public void addAnimal(Animal animal) {
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();

    }

    public void updateAnimal(Animal animal) {
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();

    }

    public Animal getAnimalById(Long id) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();

        return animal;
    }

    public void deleteAnimal(Animal animal) {
        em.getTransaction().begin();
        em.remove(animal);
        em.getTransaction().commit();

    }

    public List<Animal> getAllAnimals() {
        em.getTransaction().begin();
        Query query = em.createQuery("select animals from Animal animals");
        List<Animal> animals = query.getResultList();
        em.getTransaction().commit();

        return animals;
    }


    public void closeEntityManagerFactory() {
        emf.close();
    }
}
