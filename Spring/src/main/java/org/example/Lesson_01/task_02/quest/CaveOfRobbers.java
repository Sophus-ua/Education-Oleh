package org.example.Lesson_01.task_02.quest;

public class CaveOfRobbers implements IQuest {
    private final String name;
    private final String personIssuingTheQuest;
    private final String questLocation;
    private final String goal;

    public CaveOfRobbers() {
        name = "Печера грабіжників";
        personIssuingTheQuest = "Комендант Міста Бімбабва";
        questLocation = "Дальня окраїна лісу біля озера Зара";
        goal = "затримати грабіжників і доправити їх на суд";
    }

    @Override
    public IResultOfQuest[] possibleResults() {
        return ResultsOfQuest.values();
    }

    @Override
    public String nameOfQuest() {
        return name;
    }

    @Override
    public String personIssuingTheQuest() {
        return personIssuingTheQuest;
    }

    @Override
    public String questLocation() {
        return questLocation;
    }

    @Override
    public String goal() {
        return goal;
    }

    public enum ResultsOfQuest implements IResultOfQuest {
        ROBBERS_WHERE_ARRESTED("Після тривалої боротьби лицарь зміг перемогти і затримати грабіжників.",
                true, 100),
        ROBBERS_FOUGHT_BACK("Після тривалої боротьби лицарь був змушенний відступити.",
                true, 10),
        ROBBERS_FLED("Після тривалої боротьби грабіжникам вдалося втекти.",
                true, 50),
        ROBBERS_SET_UP_AMBUSH("Лицарь потрапив в засідку і загинув.",
                false, 0);

        private final String result;
        private final boolean isAlive;
        private final int experience;

        ResultsOfQuest(String result, boolean isAlive, int experience) {
            this.result = result;
            this.isAlive = isAlive;
            this.experience = experience;
        }

        public String getResult() {
            return result;
        }

        @Override
        public int gainedExperience() {
            return experience;
        }

        @Override
        public String result() {
            return result;
        }

        @Override
        public boolean isAlive() {
            return isAlive;
        }
    }
}
