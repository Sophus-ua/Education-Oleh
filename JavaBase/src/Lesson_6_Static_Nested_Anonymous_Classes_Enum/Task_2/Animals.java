package Lesson_6_Static_Nested_Anonymous_Classes_Enum.Task_2;

enum Animals {
    CAT(4), DOG(5), PARROT(2), RACCOON(7), FISH(1);
    private final int age;
    Animals(int age) {this.age = age;}
    @Override
    public String toString() {return this.name() + " вік: " + this.age + ";";}
}
