package Lesson_2_DAO.task_3.Jewelry;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Necklace implements Externalizable {
    private List<Gem> gems;
    private String name;
    private int ID;

    public Necklace(){
        this.gems = new ArrayList<>();
    }
    public Necklace(int id) {
        this.gems = new ArrayList<>();
        setName("Намисто");
        setID(id);
    }

    public List<Gem> getGems() {
        return gems;
    }

    public void addGem (Gem gem){
        gems.add(gem);
        sortGemsInNecklace(gems);
    }

    public void addGems (List<Gem> gems){
        this.gems.addAll(gems);
        sortGemsInNecklace(gems);
    }
    public double getTotalCaratWeight() {
        double totalCaratWeight = 0.0;
        for (Gem gem : gems) {
            totalCaratWeight += (gem.getCaratWeight() * gem.getCount());
        }
        return totalCaratWeight;
    }

    public List<Gem> findGemsByClarity (int clarity){
        List<Gem> foundStones = new ArrayList<>();
        for (Gem gem : gems){
            if (gem.getClarity() == clarity)
                foundStones.add(gem);
        }
        return foundStones;
    }

    public List<Gem> findGemsByColorSaturation (int colorSaturation){
        List<Gem> foundStones = new ArrayList<>();
        for (Gem gem : gems){
            if (gem.getColorSaturation() == colorSaturation)
                foundStones.add(gem);
        }
        return foundStones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private void sortGemsInNecklace(List<Gem> gems) {
        gems.sort((gem1, gem2) -> {
            int priceComparison = Double.compare(Calculations.calculateGemPrice(gem2, 0),
                    Calculations.calculateGemPrice(gem1, 0));
            if (priceComparison == 0)
                return Integer.compare(TypeOfGem.valueOf(gem1.getTypeName()).getPlaceInHierarchy(), TypeOfGem.valueOf(gem2.getTypeName()).getPlaceInHierarchy());
            else return priceComparison;
        });
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(gems);
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.gems = (List<Gem>) in.readObject();
        this.name = (String) in.readObject();
    }

}
