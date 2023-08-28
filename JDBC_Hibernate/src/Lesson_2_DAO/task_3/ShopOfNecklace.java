package Lesson_2_DAO.task_3;

import Lesson_2_DAO.task_3.ListSerializations.CatalogueOfNecklaces;
import Lesson_2_DAO.task_3.ListSerializations.NecklaceListSerializations;
import Lesson_2_DAO.task_3.WorkFromConsole.ConsoleAdministrator;



public class ShopOfNecklace {

    public static void startWork(CatalogueOfNecklaces catalogue){
        ConsoleAdministrator consoleMenu = new ConsoleAdministrator(catalogue);
        consoleMenu.startMenu();
    }


    public static void main(String[] args) {
        NecklaceListSerializations necklacesSerialization = new NecklaceListSerializations();
        CatalogueOfNecklaces catalogue = necklacesSerialization.readNecklacesFile();

        ShopOfNecklace.startWork(catalogue);

        necklacesSerialization.writeNecklacesToFile(catalogue);
    }
}
