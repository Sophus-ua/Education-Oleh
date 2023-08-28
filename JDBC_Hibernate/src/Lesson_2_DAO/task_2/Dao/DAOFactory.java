package Lesson_2_DAO.task_2.Dao;

public class DAOFactory implements IDAOFactory {
    private static IDAOFactory factory;

    private DAOFactory(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Драйвер завантажений");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized IDAOFactory getInstance(){
        if (factory == null)
            factory = new DAOFactory();
        return factory;
    }

    @Override
    public INecklaceDAO getNecklaceDAO() {
        return new NecklaceJDBCDAO();
    }

    @Override
    public IGemDAO getGemDAO() {
        return new GemJDBCDAO();
    }
}
