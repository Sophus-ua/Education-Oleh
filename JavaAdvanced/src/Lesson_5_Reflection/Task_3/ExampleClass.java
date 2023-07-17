package Lesson_5_Reflection.Task_3;

final public class ExampleClass {
    int number;
    private String name;
    private char letter;

    ExampleClass(){}
    ExampleClass(int number){
        this.number = number;
    }
    ExampleClass(String name, char letter){
        this.letter = letter;
        this.name = name;
    }
    ExampleClass(char letter, String name, int number){
        this.letter = letter;
        this.name = name;
        this.number = number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void letterSomeMethod(char letter, int number, String name) {
        this.letter = letter;
    }
}
