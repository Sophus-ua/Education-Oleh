package Lesson_2_DAO.task_3.WorkFromConsole;


import Lesson_2_DAO.task_3.Jewelry.Gem;
import Lesson_2_DAO.task_3.Jewelry.Necklace;

import java.util.Scanner;
import java.util.function.BiConsumer;


public enum SwitchMenuNecklaceView {
    NECKLACE_PRICE("\033[1;32m 1 \033[0m- ціна намиста"),
    NECKLACE_GEMS_WEIGHT("\033[1;32m 2 \033[0m- загальна вага камнів в каратах"),
    NECKLACE_GEMS_LIST("\033[1;32m 3 \033[0m- список камнів в намисті по цінності починаючи з дорожчих"),
    GEMS_SEARCH_BY_CLARITY("\033[1;32m 4 \033[0m- пошук камнів в намисті по чистоті"),
    GEMS_SEARCH_BY_COLOR_SATURATION("\033[1;32m 5 \033[0m- пошук камнів в намисті по насиченності кольору"),
    NECKLACE_CHANGE_NAME("\033[1;32m 6 \033[0m- зміна імені намиста"),
    DELETE_NECKLACE("\033[1;32m 7 \033[0m- видалення намиста");

    private final String option;

    SwitchMenuNecklaceView(String option) {
        this.option = option;
    }

    static void printOptions() {
        for (SwitchMenuNecklaceView value : SwitchMenuNecklaceView.values())
            System.out.println(value.option);
    }

    BiConsumer<Scanner, Necklace> getBiConsumerExecuteAction(Scanner in, Necklace necklace, SwitchMenuNecklaceView necklaceViewEnum) {
        MenuNecklaceView menuNecklaceView = new MenuNecklaceView();

        switch (necklaceViewEnum) {
            case NECKLACE_PRICE:
                return (x, y) -> System.out.printf("Ціна намиста \033[1;36m %.2f$\033[0m%n", menuNecklaceView.getPriceOfNecklace(in, necklace));

            case NECKLACE_GEMS_WEIGHT:
                return (x, y) -> System.out.printf("Загальна вага \033[1;36m %.2f \033[0m%n", necklace.getTotalCaratWeight());

            case NECKLACE_GEMS_LIST:
                return (x, y) -> {
                    System.out.println("Список камнів в намисті по цінності починаючи з дорожчих:");
                    for (Gem gem : necklace.getGems())
                        System.out.println(gem.toString());
                };
            case GEMS_SEARCH_BY_CLARITY:
                return (x, y) -> {
                    System.out.println("Введіть чистоту каменю(ів) \033[1;32m1-10\033[0m");
                    menuNecklaceView.printListOfQueryGems(in, necklace, true, false);
                };
            case GEMS_SEARCH_BY_COLOR_SATURATION:
                return (x, y) -> {
                    System.out.println("Введіть насиченності кольору каменю(ів) \033[1;32m1-10\033[0m");
                    menuNecklaceView.printListOfQueryGems(in, necklace, false, true);
                };
            case NECKLACE_CHANGE_NAME:
                return (x, y) -> {
                    System.out.println("Введіть нове ім'я намиста в каталозі:");
                    necklace.setName(in.nextLine());
                    System.out.println("Ім'я намиста змінено");
                };
            case DELETE_NECKLACE:
                return (x, y) -> {
                    ConsoleAdministrator.getCatalogue().deleteNecklaceFromCatalog(necklace);
                    System.out.println("намисто видалене з каталогу");
                    menuNecklaceView.setInMenuNeckLace(false);
                };
            default:
                return (x, y) -> System.err.println("Помилка в SwitchMenuNecklaceView.biConsumerExecuteAction()");
        }
    }

}
