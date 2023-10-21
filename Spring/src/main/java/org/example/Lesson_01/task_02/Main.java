package org.example.Lesson_01.task_02;

import org.example.Lesson_01.task_02.quest.CaveOfRobbers;
import org.example.Lesson_01.task_02.quest.DragonGorge;
import org.example.Lesson_01.task_02.quest.IngredientsForPotion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson_01.xml");
        Knight knightBoris = context.getBean("knightBoris", Knight.class);
        CaveOfRobbers caveOfRobbers = context.getBean("CaveOfRobbers", CaveOfRobbers.class);
        DragonGorge dragonGorge = context.getBean("DragonGorge", DragonGorge.class);
        IngredientsForPotion ingredientsForPotion = context.getBean("IngredientsForPotion", IngredientsForPotion.class);

        System.out.println("___________________________________________________________________________________");
        System.out.println(knightBoris.doQuestAndGetResult(ingredientsForPotion));
        System.out.println("___________________________________________________________________________________");
        System.out.println(knightBoris.doQuestAndGetResult(caveOfRobbers));
        System.out.println("___________________________________________________________________________________");
        System.out.println(knightBoris.doQuestAndGetResult(dragonGorge));
        System.out.println("___________________________________________________________________________________");
    }
}
