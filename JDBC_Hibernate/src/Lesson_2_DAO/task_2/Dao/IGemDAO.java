package Lesson_2_DAO.task_2.Dao;


import Lesson_2_DAO.task_3.Jewelry.Gem;
import Lesson_2_DAO.task_3.Jewelry.Necklace;

import java.util.List;

public interface IGemDAO {
    List<Gem> getGemsByNecklaceId(int necklaceId);

    void writeGemsByNecklaceId(Necklace necklace);

}
