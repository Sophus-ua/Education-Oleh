package Lesson_2_DAO.task_3.WorkFromConsole;

import Lesson_2_DAO.task_3.ListSerializations.CatalogueOfNecklaces;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsoleAdministrator {
    private static CatalogueOfNecklaces catalogue;
    private static boolean inMenu;

    public ConsoleAdministrator(CatalogueOfNecklaces catalogue) {
        ConsoleAdministrator.catalogue = catalogue;
        inMenu = true;
    }

    public void startMenu() {
        Scanner in = new Scanner(System.in);

        while (inMenu) {
            OutputConstants.printMessage(OutputConstants.dashedLine, false);
            System.out.println("Введіть:");
            SwitchConsoleAdministrator.printOptions();

            int point = 0;
            try {
                point = Integer.parseInt(in.next().strip());
                in.nextLine();
            } catch (NumberFormatException e) {
                OutputConstants.printMessage(OutputConstants.inputErrorData, true);
            }


            boolean foundMatch = false;
            for (SwitchConsoleAdministrator consoleEnum : SwitchConsoleAdministrator.values())
                if (point == consoleEnum.ordinal()+1){
                    foundMatch = true;
                    Consumer<Scanner> menuAction = consoleEnum.consumerExecuteAction(in, consoleEnum);
                    menuAction.accept(in);
                }
            if (!foundMatch) OutputConstants.printMessage(OutputConstants.inputErrorData, true);
        }
    }

    static void setInMenu (boolean inMenu){
        ConsoleAdministrator.inMenu = inMenu;
    }

    public static CatalogueOfNecklaces getCatalogue() {
        return catalogue;
    }
}
