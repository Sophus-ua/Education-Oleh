package Lesson_2_DAO.task_2.Dao;


import Lesson_2_DAO.task_3.Jewelry.Necklace;

import java.util.List;

public interface INecklaceDAO {
    List<Necklace> getListOfNecklaces ();

    void writeListOfNecklaces(List<Necklace> listOfNecklaces);
}
