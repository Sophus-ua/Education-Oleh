package Lesson_4_JPA_Hibernate.task_7.entity;


import javax.persistence.*;


@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int age;
    private String name;
    private boolean tail;


    @Override
    public String toString() {
        return "ID " + getId() + ", ім'я " + getName() + ", вік " + getAge() + ", хвіст? " + tail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTail() {
        return tail;
    }

    public void setTail(boolean tail) {
        this.tail = tail;
    }
}
