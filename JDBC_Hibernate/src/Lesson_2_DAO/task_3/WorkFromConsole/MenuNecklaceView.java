package Lesson_2_DAO.task_3.WorkFromConsole;


import Lesson_2_DAO.task_3.Jewelry.Calculations;
import Lesson_2_DAO.task_3.Jewelry.Gem;
import Lesson_2_DAO.task_3.Jewelry.Necklace;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            printMassage(4);
            printMassage(1);
            printMassage(5);
            int count = 1;
            for (Necklace n : ConsoleAdministrator.getCatalogue().getListOfNecklace()) {
                System.out.println("Порядкове ID намиста: \033[1;36m" + count + "\033[0m Ім'я: \033[1;36m" + n.getName() + "\033[0m");
                count++;
            }
            printMassage(6);

            String input = in.next().strip();
            in.nextLine();

            if (input.equalsIgnoreCase("end")) break;

            try {
                int id;
                id = (Integer.parseInt(input) - 1);
                ConsoleAdministrator.getCatalogue().getNecklace(id);
                menuNecklace(in,id);
            } catch (NumberFormatException e) {
                printMassage(2);
            } catch (NullPointerException | IndexOutOfBoundsException e) {
                printMassage(7);
            }

        }
    }

    private void menuNecklace(Scanner in, int id) {
        inMenuNeckLace = true;
        while (inMenuNeckLace) {
            printMassage(4);
            printMassage(1);
            printMassage(3);

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
                printMassage(2);
                continue;
            }

            requestProcessing(in, id, point);
        }
    }

    private void requestProcessing(Scanner in, int id, int point) {
        Necklace necklace = ConsoleAdministrator.getCatalogue().getNecklace(id);
        switch (point) {
            case 1:
                System.out.printf("Ціна намиста \033[1;36m %.2f$\033[0m%n", getPriceOfNecklace(in, necklace));
                break;
            case 2:
                System.out.printf("Загальна вага \033[1;36m %.2f \033[0m%n", necklace.getTotalCaratWeight());
                break;
            case 3:
                System.out.println("Список камнів в намисті по цінності починаючи з дорожчих:");
                for (Gem gem : necklace.getGems())
                    System.out.println(gem.toString());
                break;
            case 4:
                System.out.println("Введіть чистоту каменю(ів) \033[1;32m1-10\033[0m");
                printListOfQueryGems(in, necklace, point);
                break;
            case 5:
                System.out.println("Введіть насиченності кольору каменю(ів) \033[1;32m1-10\033[0m");
                printListOfQueryGems(in, necklace, point);
                break;
            case 6:
                System.out.println("Введіть нове ім'я намиста в каталозі:");
                necklace.setName(in.nextLine());
                System.out.println("Ім'я намиста змінено");
                break;
            case 7:
                ConsoleAdministrator.getCatalogue().deleteNecklaceFromCatalog(id);
                System.out.println("намисто видалене з каталогу");
                inMenuNeckLace = false;
                break;
            default:
                printMassage(2);
        }
    }

    private void printListOfQueryGems(Scanner in, Necklace necklace, int point) {
        String into = in.next().strip();
        in.nextLine();

        List<Gem> gems = new ArrayList<>();
        try {
            int i = Integer.parseInt(into);

            if (i > 10 || i < 1) throw new NumberFormatException();
            if (point == 4)
                gems = necklace.findGemsByClarity(i);
            if (point == 5)
                gems = necklace.findGemsByColorSaturation(i);
            if (gems.isEmpty()) throw new Exception("Таких каменів нема в намисті");

            for (Gem gem : gems)
                System.out.println(gem.toString());

        } catch (NumberFormatException e) {
            printMassage(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private double getPriceOfNecklace(Scanner in, Necklace necklace) {
        printMassage(4);
        printMassage(8);
        String input = in.nextLine().strip();

        if (input.isEmpty()) {
            return Calculations.calculateNecklacePrice(necklace, 0);
        }
        try {
            int discount = Integer.parseInt(input);
            if (discount <= 100 && discount > 0) {
                System.out.println("Знижка \033[1;32m" + discount + "%\033[0m");
                return Calculations.calculateNecklacePrice(necklace, discount);
            }
            printMassage(9);
            return Calculations.calculateNecklacePrice(necklace, 0);
        } catch (NumberFormatException e) {
            return Calculations.calculateNecklacePrice(necklace, 0);
        }
    }


    private void printMassage(int id) {
        switch (id) {
            case 1:
                System.out.println("...введіть \"\033[1;33mEND\033[0m\" для \033[1;32mзавершення і виходу\033[0m в головне меню");
                break;
            case 2:
                System.err.println("ви ввели невірні дані, спробуйте ще раз.");
                break;
            case 3:
                System.out.println("\033[1;32m 1 \033[0m- ціна намиста");
                System.out.println("\033[1;32m 2 \033[0m- загальна вага камнів в каратах");
                System.out.println("\033[1;32m 3 \033[0m- список камнів в намисті по цінності починаючи з дорожчих");
                System.out.println("\033[1;32m 4 \033[0m- пошук камнів в намисті по чистоті");
                System.out.println("\033[1;32m 5 \033[0m- пошук камнів в намисті по насиченності кольору");
                System.out.println("\033[1;32m 6 \033[0m- зміна імені намиста");
                System.out.println("\033[1;32m 7 \033[0m- видалення намиста");
                break;
            case 4:
                System.out.println("\033[1;35m_________________________________________________________________________________\033[0m");
                break;
            case 5:
                System.out.println("Всього \033[1;32m" + ConsoleAdministrator.getCatalogue().getNumberOfNecklaces() + "\033[0m намист");
                System.out.println("\033[4;32mСписок намист\033[0m:");
                break;
            case 6:
                System.out.println("Введіть порядковий \033[1;32mID намиста\033[0m для перегляду властивостей");
                break;
            case 7:
                System.err.println("Намиста з таким id не знайдено :(");
                break;
            case 8:
                System.out.println("Введіть \033[1;32mвідсоток знижки\033[0m, якщо присутня або \033[1;32mENTER\033[0m для продовження");
                break;
            case 9:
                System.out.println("Знижка відсутня");
                break;
        }
    }
}
