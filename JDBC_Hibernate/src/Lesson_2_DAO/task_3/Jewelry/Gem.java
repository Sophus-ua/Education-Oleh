package Lesson_2_DAO.task_3.Jewelry;

import java.io.*;


public class Gem implements Externalizable {
    private int count;
    private String typeName;
    private double caratWeight;
    private int clarity, colorSaturation;

    public Gem(){}

    public Gem (int count, TypeOfGem type, double caratWeight, int clarity, int colorSaturation) throws IllegalArgumentException {
        setCount(count);
        setTypeName(type.name());
        setCaratWeight(caratWeight);
        setClarity(clarity);
        setColorSaturation(colorSaturation);
    }

    public void setCaratWeight (double caratWeight) throws IllegalArgumentException {
        if (caratWeight > 0){
            this.caratWeight = caratWeight;
        } else {
            throw new IllegalArgumentException ("Вага має бути більше нуля");}

    }
    public void setClarity (int clarity) throws IllegalArgumentException {
        if (clarity >= 1 &&  clarity <= 10){
            this.clarity = clarity;
        } else {
            throw new IllegalArgumentException ("Прозорість має бути у діапазоні від 1 до 10");}
    }

    public void setColorSaturation (int colorSaturation) throws IllegalArgumentException {
        if (colorSaturation >= 1 &&  colorSaturation <= 10){
            this.colorSaturation = colorSaturation;
        } else {
            throw new IllegalArgumentException ("Насиченість кольору має бути у діапазоні від 1 до 10");}
    }

    public String getTypeName() {
        return typeName;
    }

    public int getClarity() {
        return clarity;
    }

    public int getColorSaturation() {
        return colorSaturation;
    }

    public double getCaratWeight() {
        return caratWeight;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString () {
        return "Кількість: \033[1;36m" + count + "  \033[0;95m" + typeName + "\033[0m вагою \033[1;32m" + caratWeight + "\033[0m каратів; чистота \033[1;32m"
                + clarity + "\033[0m; насиченість кольору \033[1;32m" + colorSaturation + "\033[0m;";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(typeName);
        out.writeInt(clarity);
        out.writeInt(colorSaturation);
        out.writeDouble(caratWeight);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.typeName = (String) in.readObject();
        this.clarity = in.readInt();
        this.colorSaturation = in.readInt();
        this.caratWeight = in.readDouble();
    }
}
