package Lesson_5_Reflection.Task_4;


import java.io.Serializable;

public class Animal implements Serializable {
    //Серіалізація для уроку 7
    public String name;
    protected int age;
    private boolean madeAnalyses;

    public Animal() {
        name = "Мурка";
        age = 5;
        madeAnalyses = false;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", madeAnalyses=" + madeAnalyses +
                '}';
    }
}
