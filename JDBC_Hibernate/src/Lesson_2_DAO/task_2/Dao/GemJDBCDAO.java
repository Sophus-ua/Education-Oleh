package Lesson_2_DAO.task_2.Dao;


import Lesson_2_DAO.task_3.Jewelry.Gem;
import Lesson_2_DAO.task_3.Jewelry.Necklace;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GemJDBCDAO implements IGemDAO {
    @Override
    public List<Gem> getGemsByNecklaceId(int necklaceId) {
        List<Gem> gems = new ArrayList<>();


        String str = "select count, typeName, caratWeight, clarity, colorSaturation " +
                "from Gems where necklace_ID = ?;";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(str)) {

            statement.setInt(1, necklaceId);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                Gem gem = new Gem();
                gem.setCount(result.getInt(1));
                gem.setTypeName(result.getString(2));
                gem.setCaratWeight(result.getDouble(3));
                gem.setClarity(result.getInt(4));
                gem.setColorSaturation(result.getInt(5));

                gems.add(gem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Помилка з'єднання з базою данних");
        }

        return gems;
    }



    @Override
    public void writeGemsByNecklaceId(Necklace necklace) {
        if (necklace != null && checkNecklaceID(necklace.getID()))
            for (Gem gem : necklace.getGems())
                writeGem(gem, necklace.getID());
    }


    private void writeGem(Gem gem, int necklaceID) {
        String str = "insert into Gems (necklace_ID, count, typeName, caratWeight, clarity, colorSaturation) " +
                "values (?,?,?,?,?,?);";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(str)) {

            statement.setInt(1, necklaceID);
            statement.setInt(2, gem.getCount());
            statement.setString(3, gem.getTypeName());
            statement.setDouble(4, gem.getCaratWeight());
            statement.setInt(5, gem.getClarity());
            statement.setInt(6, gem.getColorSaturation());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Помилка з'єднання з базою данних");
        }
    }

    private boolean checkNecklaceID(int id) {
        int count = 0;

        String str = "select count(id) from List_of_necklaces where id = ?;";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(str)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            count = result.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Помилка з'єднання з базою данних");
        }

        if (count > 0) return true;
        else return false;
    }


    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Catalogue_of_necklaces", "root", "root");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
