package Lesson_2_DAO.task_3.ListSerializations;


import Lesson_2_DAO.task_3.Jewelry.Necklace;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class CatalogueOfNecklaces implements Externalizable {
    private List<Necklace> listOfNecklace;

    public CatalogueOfNecklaces(){
        listOfNecklace = new ArrayList<>();
    }


    public int getNumberOfNecklaces(){
        return listOfNecklace.size();
    }

    public void addNecklaceList (List<Necklace> necklaces){
        this.listOfNecklace.addAll(necklaces);
    }
    public void addNewNecklaceToList (Necklace necklace){
        listOfNecklace.add(necklace);
    }

    public Necklace getNecklace(int id) {
        return listOfNecklace.get(id);
    }

    public List<Necklace> getListOfNecklace() {
        return listOfNecklace;
    }


    public void deleteNecklaceFromCatalog (int id){
        listOfNecklace.remove(id);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(listOfNecklace);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        listOfNecklace = (List<Necklace>) in.readObject();
    }
}
