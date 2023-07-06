package Lesson_3_Inheritance_Polymorphism.Task_2;

import java.util.Scanner;

class ClassRoom {
    Pupil[] array;
    ClassRoom(int numberOfPupils) {
        this.array = new Pupil[numberOfPupils];
    }

    void edit (int numberOfPupils){
        for(int i = 0; i < numberOfPupils; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введіть ім'я " + (i + 1) + "-го учня:");
            String name = in.nextLine();

            boolean replay = true;
            while (replay){
                System.out.println("Введіть рівень старанності в навчанні літерою \"Г\"= гарний, \"З\"= задовільний, \"П\" = поганий:");
                char input = in.nextLine().toLowerCase().charAt(0);
                switch (input) {
                    case 'г':
                        Pupil person = new ExcelentPupil(name);
                        array[i] = person;
                        replay = false;
                        break;
                    case 'з':
                        Pupil person2 = new GoodPupil(name);
                        array[i] = person2;
                        replay = false;
                        break;
                    case 'п':
                        Pupil person3 = new BadPupil(name);
                        array[i] = person3;
                        replay = false;
                        break;
                    default:
                        System.err.println("Вибрана невірна літера");
                }
            }
        }
    }
    void infoAbout (Pupil [] array){
        for (Pupil temp : array){
            System.out.println("\n" + temp.name);
            temp.study();
            temp.read();
            temp.write();
            temp.relax();
        }
    }

    public static void main(String[] args) {
        ClassRoom A_10 = new ClassRoom(4);
        A_10.edit(4);
        A_10.infoAbout(A_10.array);
    }
}
