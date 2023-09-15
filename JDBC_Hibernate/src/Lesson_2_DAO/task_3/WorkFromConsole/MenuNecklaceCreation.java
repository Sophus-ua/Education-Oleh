package Lesson_2_DAO.task_3.WorkFromConsole;


import Lesson_2_DAO.task_3.Jewelry.Calculations;
import Lesson_2_DAO.task_3.Jewelry.Gem;
import Lesson_2_DAO.task_3.Jewelry.Necklace;
import Lesson_2_DAO.task_3.Jewelry.TypeOfGem;


import java.util.Scanner;


class MenuNecklaceCreation {
    private boolean necklaceCreatingMenu;
    private boolean oneGemCreatingMenu;
    private int idOfNewNecklace;

    MenuNecklaceCreation() {
        necklaceCreatingMenu = false;
        oneGemCreatingMenu = false;
        idOfNewNecklace = -1;
    }

    void selectNumberOfGems(Scanner in) {
        necklaceCreatingMenu = true;
        int totalCountOfGems = 0;
        int additionCycle = 1;

        while (necklaceCreatingMenu) {
            OutputConstants.printMessage(OutputConstants.dashedLine, false);
            if (additionCycle > 1)
                OutputConstants.printMessage(OutputConstants.end, false);

            System.out.println("введіть \033[1;32mкількість " + additionCycle + "-го \033[0mтипу камнів для намиста:");
            String input = in.next().toLowerCase().strip();
            in.nextLine();

            if (input.equals("end")) {
                OutputConstants.printMessage(OutputConstants.dashedLine, false);
                printCreatedNecklaceInfo();
                break;
            }

            try {
                int count = Integer.parseInt(input);
                totalCountOfGems += count;

                if (count < 1 || totalCountOfGems > 250) {
                    System.err.println("ви ввели занадто багато каменів, таке намисто не неможливе :)\n" +
                            "можна додати ще " + (250 - totalCountOfGems) + " каменів");
                    continue;
                }

                if (additionCycle == 1) idOfNewNecklace = ConsoleAdministrator.getCatalogue().getNumberOfNecklaces();
                selectTypeOfGems(in, count);
            } catch (NumberFormatException e) {
                OutputConstants.printMessage(OutputConstants.inputErrorData, true);
            }

            if (!necklaceCreatingMenu && additionCycle == 1) idOfNewNecklace = -1;
            if (necklaceCreatingMenu && additionCycle == 1) {
                System.out.println("Введіть ім'я створенного намиста:");
                String nameOfNecklace = in.nextLine().strip();
                ConsoleAdministrator.getCatalogue().getNecklace(idOfNewNecklace).setName(nameOfNecklace);
            }

            OutputConstants.printMessage(OutputConstants.dashedLine, false);
            printCreatedNecklaceInfo();
            additionCycle++;
        }
    }


    void selectTypeOfGems(Scanner in, int count) {
        while (true) {
            OutputConstants.printMessage(OutputConstants.dashedLine, false);
            OutputConstants.printMessage(OutputConstants.end, false);
            System.out.println("Доступні типи каменів:");

            for (TypeOfGem type : TypeOfGem.values()) {
                System.out.print("\033[0;95m" + type.name() + "\033[0m;  ");
            }

            System.out.println("\nВведіть тип каменю з доступних:");
            String input = in.next().toUpperCase().strip();
            in.nextLine();

            if (input.equals("END")) {
                necklaceCreatingMenu = false;
                break;
            }

            try {
                TypeOfGem selectedGemType = TypeOfGem.valueOf(input);
                selectGemAttributes(in, count, selectedGemType);
                break;
            } catch (IllegalArgumentException e) {
                OutputConstants.printMessage(OutputConstants.inputErrorData, true);
            }
        }
    }


    private void selectGemAttributes(Scanner in, int count, TypeOfGem selectedGemType) {
        while (true) {
            OutputConstants.printMessage(OutputConstants.dashedLine, false);
            OutputConstants.printMessage(OutputConstants.end, false);
            System.out.println("Введіть через пробіл(и) \033[1;32m числами вагу в каратах, чистоту(1-10) і насиченість кольору(1-10\033[0m)");


            String input = in.nextLine().toLowerCase().strip();
            String[] attributes = input.split("\\s+");

            if (attributes[0].equals("end")) {
                necklaceCreatingMenu = false;
                break;
            }

            double caratWeight;
            int clarity, colorSaturation;
            Gem gem;

            try {
                caratWeight = Double.parseDouble(attributes[0]);
                clarity = Integer.parseInt(attributes[1]);
                colorSaturation = Integer.parseInt(attributes[2]);

                gem = new Gem(count, selectedGemType, caratWeight, clarity, colorSaturation);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                OutputConstants.printMessage(OutputConstants.inputErrorData, true);
                continue;
            } catch (IllegalArgumentException e2) {
                System.err.println(e2.getMessage());
                continue;
            }
            if (oneGemCreatingMenu) {
                setOneGemCreatingMenu(false);
                System.out.printf("Ціна вибраного камня коштує \033[1;36m%.2f$\033[0m%n", +Calculations.calculateGemPrice(gem, 0));
                break;
            }

            creatingNecklace(gem);
            break;
        }
    }

    private void creatingNecklace(Gem gem) {
        try {
            ConsoleAdministrator.getCatalogue().getNecklace(idOfNewNecklace).addGem(gem);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            Necklace necklace = new Necklace(idOfNewNecklace + 1);
            necklace.addGem(gem);
            ConsoleAdministrator.getCatalogue().addNewNecklaceToList(necklace);
        }
    }

    private void printCreatedNecklaceInfo() {
        if (idOfNewNecklace == -1) System.out.println("Нема створенних намист");
        else {
            Necklace necklace = ConsoleAdministrator.getCatalogue().getNecklace(idOfNewNecklace);
            System.out.println("ID створеного намиста \033[1;36m" + necklace.getID() + "\033[0m");
            System.out.println("ім'я створеного намиста \033[1;36m" + necklace.getName() + "\033[0m");
        }
    }

    void setOneGemCreatingMenu(boolean oneGemCreatingMenu) {
        this.oneGemCreatingMenu = oneGemCreatingMenu;
    }



}
