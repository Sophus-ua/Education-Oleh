package Lesson_4_JPA_Hibernate.task_7;

import Lesson_4_JPA_Hibernate.task_7.entity.Animal;

import java.util.List;


class Main {
    public static void main(String[] args) {
        String str1 = "\033[4;32m";
        String str2 = "\033[0m";

        Animal animal1 = new Animal();
        animal1.setAge(5);
        animal1.setName("Cat");
        animal1.setTail(true);

        Animal animal2 = new Animal();
        animal2.setAge(7);
        animal2.setName("Dog");
        animal2.setTail(true);

        Animal animal3 = new Animal();
        animal3.setAge(3);
        animal3.setName("Snake");
        animal3.setTail(true);

        AnimalHelper animalHelper = new AnimalHelper();
        animalHelper.addAnimal(animal1);
        animalHelper.addAnimal(animal2);
        animalHelper.addAnimal(animal3);


        Animal animal = animalHelper.getAnimalById((long) 3);
        System.out.println(str1 + animal + str2);
        animal3.setAge(4);
        animalHelper.updateAnimal(animal);
        System.out.println(str1 + animalHelper.getAnimalById((long) 3) + str2);
        animalHelper.deleteAnimal(animal);

        List<Animal> animals = animalHelper.getAllAnimals();
        for (Animal a : animals)
            System.out.println(str1 + a + str2);

        animalHelper.closeEntityManagerFactory();
    }
}
