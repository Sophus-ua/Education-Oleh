package Lesson_2_DAO.task_3.WorkFromConsole;


import Lesson_2_DAO.task_3.Jewelry.Calculations;
import Lesson_2_DAO.task_3.Jewelry.Gem;
import Lesson_2_DAO.task_3.Jewelry.Necklace;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

class MenuNecklaceView {
    private boolean inMenuListOfNecklaces;
    private boolean inMenuNeckLace;

    MenuNecklaceView(){
        inMenuListOfNecklaces = false;
        inMenuNeckLace = false;
    }

    void menuListOfNecklaces(Scanner in) {
        inMenuListOfNecklaces = true;
        while (inMenuListOfNecklaces) {
            OutputConstants.printMessage(OutputConstants.dashedLine, false);
            OutputConstants.printMessage(OutputConstants.end, false);
            System.out.println("Всього \033[1;32m" + ConsoleAdministrator.getCatalogue().getNumberOfNecklaces() + "\033[0m намист");
            System.out.println("\033[4;32mСписок намист\033[0m:");
            int count = 1;
            for (Necklace n : ConsoleAdministrator.getCatalogue().getListOfNecklace()) {
                System.out.println("Порядкове ID намиста: \033[1;36m" + count + "\033[0m Ім'я: \033[1;36m" + n.getName() + "\033[0m");
                count++;
            }
            System.out.println("Введіть порядковий \033[1;32mID намиста\033[0m для перегляду властивостей");

            String input = in.next().strip();
            in.nextLine();

            if (input.equalsIgnoreCase("end")) break;

            try {
                int id;
                id = (Integer.parseInt(input) - 1);
                ConsoleAdministrator.getCatalogue().getNecklace(id);
                menuNecklace(in,id);
            } catch (NumberFormatException e) {
                OutputConstants.printMessage(OutputConstants.inputErrorData, true);
            } catch (NullPointerException | IndexOutOfBoundsException e) {
                System.err.println("Намиста з таким id не знайдено :(");
            }

        }
    }

    private void menuNecklace(Scanner in, int id) {
        inMenuNeckLace = true;
        while (inMenuNeckLace) {
            OutputConstants.printMessage(OutputConstants.dashedLine, false);
            OutputConstants.printMessage(OutputConstants.end, false);
            SwitchMenuNecklaceView.printOptions();

            String input = in.next().toLowerCase().strip();
            in.nextLine();
            if (input.equals("end")) {
                inMenuListOfNecklaces = false;
                break;
            }

            int point;
            try {
                point = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                OutputConstants.printMessage(OutputConstants.inputErrorData, true);
                continue;
            }

            requestProcessing(in, id, point);
        }
    }

    private void requestProcessing(Scanner in, int id, int point) {
        Necklace necklace = ConsoleAdministrator.getCatalogue().getNecklace(id);

        boolean foundMatch = false;
        for (SwitchMenuNecklaceView necklaceViewEnum : SwitchMenuNecklaceView.values())
            if (point == necklaceViewEnum.ordinal()+1) {
                foundMatch = true;
                BiConsumer<Scanner, Necklace> biConsumer = necklaceViewEnum.biConsumerExecuteAction(in, necklace, necklaceViewEnum);
                biConsumer.accept(in, necklace);
            }
        if (!foundMatch) OutputConstants.printMessage(OutputConstants.inputErrorData, true);
    }

    void printListOfQueryGems(Scanner in, Necklace necklace, boolean clarity, boolean colorSaturation) {
        String into = in.next().strip();
        in.nextLine();

        List<Gem> gems = new ArrayList<>();
        try {
            int i = Integer.parseInt(into);

            if (i > 10 || i < 1) throw new NumberFormatException();
            if (clarity)
                gems = necklace.findGemsByClarity(i);
            if (colorSaturation)
                gems = necklace.findGemsByColorSaturation(i);
            if (gems.isEmpty()) throw new Exception("Таких каменів нема в намисті");

            for (Gem gem : gems)
                System.out.println(gem.toString());

        } catch (NumberFormatException e) {
            OutputConstants.printMessage(OutputConstants.inputErrorData, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    double getPriceOfNecklace(Scanner in, Necklace necklace) {
        OutputConstants.printMessage(OutputConstants.dashedLine, false);
        System.out.println("Введіть \033[1;32mвідсоток знижки\033[0m, якщо присутня або \033[1;32mENTER\033[0m для продовження");
        String input = in.nextLine().strip();

        if (input.isEmpty())
            return Calculations.calculateNecklacePrice(necklace, 0);

        try {
            int discount = Integer.parseInt(input);
            if (discount <= 100 && discount > 0) {
                System.out.println("Знижка \033[1;32m" + discount + "%\033[0m");
                return Calculations.calculateNecklacePrice(necklace, discount);
            }
            System.out.println("Знижка відсутня");
            return Calculations.calculateNecklacePrice(necklace, 0);
        } catch (NumberFormatException e) {
            return Calculations.calculateNecklacePrice(necklace, 0);
        }
    }

    void setInMenuNeckLace(boolean inMenuNeckLace){
        this.inMenuNeckLace = inMenuNeckLace;
    }

}
