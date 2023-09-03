package Lesson_2_DAO.task_3.WorkFromConsole;

import java.util.Scanner;
import java.util.function.Consumer;

public enum SwitchConsoleAdministrator {
    NECKLACE_CREATION("для початку створення нового намиста"),
    NECKLACE_VIEW("для входу в меню створенних намист"),
    ONE_GEM_CREATING("дізнатись ціну бажаного драгоцінного каменя"),
    QUIT("\033[1;31mВИХІД\033[0m з программи");

    private final String option;
    SwitchConsoleAdministrator(String option) {
        this.option = option;
    }

    static void printOptions() {
        for (SwitchConsoleAdministrator value : SwitchConsoleAdministrator.values())
            System.out.println("\033[1;32m " + (value.ordinal()+1) + " \033[0m- " + value.option);
    }
    Consumer<Scanner> getConsumerExecuteAction(Scanner in, SwitchConsoleAdministrator switchConsoleAdministrator){
        MenuNecklaceCreation mNecklaceCreation = new MenuNecklaceCreation();
        MenuNecklaceView mNecklaceView = new MenuNecklaceView();

        switch(switchConsoleAdministrator){
            case NECKLACE_CREATION:
                return x -> mNecklaceCreation.selectNumberOfGems(in);
            case NECKLACE_VIEW:
                return x -> mNecklaceView.menuListOfNecklaces(in);
            case ONE_GEM_CREATING:
                return x -> {
                    mNecklaceCreation.setOneGemCreatingMenu(true);
                    mNecklaceCreation.selectTypeOfGems(in, 1);
                };
            case QUIT:
                return x -> {
                    in.close();
                    ConsoleAdministrator.setInMenu(false);
                };
            default:
                return x-> System.err.println("Помилка в SwitchConsoleAdministrator.executeAction()");
        }
    }
}
