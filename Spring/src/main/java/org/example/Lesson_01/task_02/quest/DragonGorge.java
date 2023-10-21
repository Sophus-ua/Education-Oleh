package org.example.Lesson_01.task_02.quest;

public class DragonGorge implements IQuest {
    private final String name;
    private final String personIssuingTheQuest;
    private final String questLocation;
    private final String goal;

    public DragonGorge() {
        name = "Ущелина Дракона";
        personIssuingTheQuest = "Мер міста Валалай";
        questLocation = "Великий каньон";
        goal = "Знайти яйце древнього Дракона";
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
        LIGHTNING_STRUCK("Приближаючись до ущелини раптово почався шторм і влицаря влучила блискавка, від чого він загинув на місці",
                false, 0),
        DRAGON_FLEW("Лицар нарешті добрався до ущелини і побачив гніздо з яйцем. Але раптово прилетів дракон і з'їв лицаря.",
                false, 0),
        FIGHTING_DRAGON("Прибувши на місце зненацька з'явився дракон. Після довгої битви лицар вже майже переміг дракона але зненацька він дихнув на нього полум'ям і лицар загинув",
                false, 0),
        TOOK_THE_EGG("Прибувши в ущелину лицар побачив гніздо з драконом. Але на щастя Дракон спав і лицар підкравшись зміг вкрасти яйце і повернутись з ним в місто.",
                true, 300);

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
