package org.example.Lesson_01.task_02;

import org.example.Lesson_01.task_02.quest.CaveOfRobbers;
import org.example.Lesson_01.task_02.quest.DragonGorge;
import org.example.Lesson_01.task_02.quest.IngredientsForPotion;

public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight("Boris");
        System.out.println("___________________________________________________________________________________");
        System.out.println(knight.doQuestAndGetResult(new IngredientsForPotion()));
        System.out.println("___________________________________________________________________________________");
        System.out.println(knight.doQuestAndGetResult(new CaveOfRobbers()));
        System.out.println("___________________________________________________________________________________");
        System.out.println(knight.doQuestAndGetResult(new DragonGorge()));
        System.out.println("___________________________________________________________________________________");
    }
}
