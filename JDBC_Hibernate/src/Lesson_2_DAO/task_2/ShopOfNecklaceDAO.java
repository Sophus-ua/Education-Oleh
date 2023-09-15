package Lesson_2_DAO.task_2;

import Lesson_2_DAO.task_2.Dao.*;
import Lesson_2_DAO.task_3.ListSerializations.CatalogueOfNecklaces;
import Lesson_2_DAO.task_3.ShopOfNecklace;



class ShopOfNecklaceDAO {
    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        INecklaceDAO necklaceDAO = factory.getNecklaceDAO();
        IGemDAO gemDAO = factory.getGemDAO();

        CatalogueManager catalogueManager = new CatalogueManager();
        CatalogueOfNecklaces catalogue = catalogueManager.catalogueReader(necklaceDAO,gemDAO);

        ShopOfNecklace.startWork(catalogue);
        catalogueManager.catalogueWriter(necklaceDAO,gemDAO,catalogue);
    }
}
