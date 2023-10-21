package org.example.Lesson_01.task_02.quest;

public class IngredientsForPotion implements IQuest{
    private final String name;
    private final String personIssuingTheQuest;
    private final String questLocation;
    private final String goal;

    public IngredientsForPotion() {
        name = "Лікарське зілля";
        personIssuingTheQuest = "Знахарка Ганна";
        questLocation = "Лісова галявина глибоко в лісі";
        goal = "зібрати трави для лікарського зілля щоб вилікувати сина мера";
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
        NOT_FIND_CLEARING("Лицар довго блукав по лісу але так і не знайшов потрібну галявину. Син мера помер",
                true, 0),
        NOT_COLLECT_ALL_INGREDIENTS("Лицар знайшов галявину, зібравши трави він повернувся до знахарки, " +
                "але виявилось що по дорозі він загубив червону квітку. Знахарка не встигла приготувати зілля і син мера помер. ",
                true, 20),
        COLLECT_ALL_INGREDIENTS("Лицар знайшов галявину, зібравши трави він повернувся до знахарки, \" +\n" +
                "                \"та приготувала лікувальне зілля але воно не подіяло і син мера помер",
                true, 50),
        GOT_INTO_SWAMP("Лицар довго шукав галявину і заблукав, коли настала темрява він забрів в болото і загинув",
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