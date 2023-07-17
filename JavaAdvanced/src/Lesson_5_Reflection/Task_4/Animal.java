package Lesson_5_Reflection.Task_4;




public class Animal {

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
