package Lesson_2_DAO.task_3.WorkFromConsole;

import Lesson_2_DAO.task_3.ListSerializations.CatalogueOfNecklaces;

import java.util.Scanner;

public class ConsoleAdministrator {
    private final MenuNecklaceCreation mNecklaceCreation;
    private final MenuNecklaceView mNecklaceView;
    private static CatalogueOfNecklaces catalogue;

    public ConsoleAdministrator(CatalogueOfNecklaces catalogue) {
        mNecklaceCreation = new MenuNecklaceCreation();
        mNecklaceView = new MenuNecklaceView();
        ConsoleAdministrator.catalogue = catalogue;
    }

    public void startMenu() {
        Scanner in = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println("\033[1;35m_________________________________________________________________________________\033[0m");
            System.out.println("Введіть:");
            System.out.println("\033[1;32m 1 \033[0m- для початку створення нового намиста");
            System.out.println("\033[1;32m 2 \033[0m- для входу в меню створенних намист");
            System.out.println("\033[1;32m 3 \033[0m- дізнатись ціну бажаного драгоцінного каменя");
            System.out.println("\033[1;32m 4 \033[0m- \033[1;31mВИХІД\033[0m з программи");


            String input = in.next().toLowerCase().strip();
            in.nextLine();

            switch (input) {
                case "1":
                    mNecklaceCreation.selectNumberOfGems(in);
                    break;
                case "2":
                    mNecklaceView.menuListOfNecklaces(in);
                    break;
                case "3":
                    mNecklaceCreation.setOneGemCreatingMenu(true);
                    mNecklaceCreation.selectTypeOfGems(in, 1);
                    break;
                case "4":
                    in.close();
                    menu = false;
                    break;
                default:
                    System.err.println("ви ввели невірні данні, спробуйте ще раз");
            }


        }
    }
    public static CatalogueOfNecklaces getCatalogue() {
        return catalogue;
    }
}
