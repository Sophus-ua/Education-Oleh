package org.example.Lesson_01.task_02.quest;

import java.util.List;

public interface IQuest {
    IResultOfQuest[] possibleResults();
    String nameOfQuest();
    String personIssuingTheQuest();
    String questLocation ();
    String goal();
}
