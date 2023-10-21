package org.example.Lesson_01.task_02;

import lombok.Data;
import org.example.Lesson_01.task_02.quest.IQuest;
import org.example.Lesson_01.task_02.quest.IResultOfQuest;

import java.util.Random;

@Data
public class Knight {
    private String name;
    private boolean isAlive;
    private int experience;

    Knight(String name) {
        this.name = name;
        isAlive = true;
        experience = 0;
    }

    public String doQuestAndGetResult(IQuest quest) {
        if (!isAlive) return this.toString();

        IResultOfQuest[] results = quest.possibleResults();
        int randomIndex = new Random().nextInt(results.length);
        IResultOfQuest result = results[randomIndex];
        isAlive = result.isAlive();
        experience += result.gainedExperience();

        return String.format("Рицарь на ім'я %1s отримав квест %2s від %3s. " +
                        "\nЦіль квесту була %4s, після чого рицарь вирушив в %5s. \n%6s \n%7s",
                name, quest.nameOfQuest(), quest.personIssuingTheQuest(), quest.goal(),
                quest.questLocation(), result.result(), this
        );
    }

    @Override
    public String toString(){
        if (!isAlive)
            return String.format("\033[0;31mНажаль Лицарь %s загинув і спочиває вічним сном:(\033[0m", name);

        return String.format("\033[0;33mЛицарь %s, досвід - %d\033[0m", name, experience);
    }
}
