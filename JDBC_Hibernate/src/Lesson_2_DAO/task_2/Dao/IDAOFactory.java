package Lesson_2_DAO.task_2.Dao;



public interface IDAOFactory {
    IGemDAO getGemDAO();
    INecklaceDAO getNecklaceDAO();
}
