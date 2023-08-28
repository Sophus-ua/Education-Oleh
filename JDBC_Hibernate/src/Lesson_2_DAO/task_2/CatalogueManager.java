package Lesson_2_DAO.task_2;

import Lesson_2_DAO.task_2.Dao.IGemDAO;
import Lesson_2_DAO.task_2.Dao.INecklaceDAO;
import Lesson_2_DAO.task_3.Jewelry.Gem;
import Lesson_2_DAO.task_3.Jewelry.Necklace;
import Lesson_2_DAO.task_3.ListSerializations.CatalogueOfNecklaces;

import java.util.List;

public class CatalogueManager {
    public void catalogueWriter(INecklaceDAO necklaceDAO, IGemDAO gemDAO, CatalogueOfNecklaces catalogue) {
        necklaceDAO.writeListOfNecklaces(catalogue.getListOfNecklace());
        for (Necklace necklace : catalogue.getListOfNecklace())
            gemDAO.writeGemsByNecklaceId(necklace);
    }

    public CatalogueOfNecklaces catalogueReader(INecklaceDAO necklaceDAO, IGemDAO gemDAO) {
        CatalogueOfNecklaces catalogue = new CatalogueOfNecklaces();
        try {
            catalogue.addNecklaceList(necklaceDAO.getListOfNecklaces());

            for (Necklace necklace : catalogue.getListOfNecklace()) {
                List<Gem> gems = gemDAO.getGemsByNecklaceId(necklace.getID());
                necklace.addGems(gems);
            }
            return catalogue;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return catalogue;
    }
}
