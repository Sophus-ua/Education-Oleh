package Lesson_2_DAO.task_3.WorkFromConsole;


import Lesson_2_DAO.task_3.Jewelry.Gem;
import Lesson_2_DAO.task_3.Jewelry.Necklace;

import java.util.Scanner;
import java.util.function.BiConsumer;


public enum SwitchMenuNecklaceView {
    NECKLACE_GEMS_LIST("список камнів в намисті по цінності починаючи з дорожчих"),
    NECKLACE_PRICE("ціна намиста"),
    NECKLACE_GEMS_WEIGHT("загальна вага камнів в каратах"),
    GEMS_SEARCH_BY_CLARITY("пошук камнів в намисті по чистоті"),
    GEMS_SEARCH_BY_COLOR_SATURATION("пошук камнів в намисті по насиченності кольору"),
    NECKLACE_CHANGE_NAME("зміна імені намиста"),
    DELETE_NECKLACE("видалення намиста");

    private final String option;

    SwitchMenuNecklaceView(String option) {
        this.option = option;
    }

    static void printOptions() {
        for (SwitchMenuNecklaceView value : SwitchMenuNecklaceView.values())
            System.out.println("\033[1;32m " + (value.ordinal()+1) + " \033[0m- " + value.option);
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
                    menuNecklaceView.setInMenuNeckLace(false);
                    System.out.println("намисто видалене з каталогу");
                };
            default:
                return (x, y) -> System.err.println("Помилка в SwitchMenuNecklaceView.biConsumerExecuteAction()");
        }
    }

}
