package Lesson_2_DAO.task_3.Jewelry;



public class Calculations {

    public static double calculateGemPrice (Gem gem, int percentageDiscount){
        double colorCalculate = (1.0 - gem.getColorSaturation() / 10.0);
        if (gem.getTypeName().equalsIgnoreCase("DIAMOND"))
            colorCalculate = (10.0 - 10.0 / gem.getColorSaturation());

        double price = (TypeOfGem.valueOf(gem.getTypeName()).getBasePrice() * TypeOfGem.valueOf(gem.getTypeName()).getWeightFactor() * gem.getCaratWeight())
                / (1.0 + (TypeOfGem.valueOf(gem.getTypeName()).getClarityFactor()
                * (10.0 - 10.0 / gem.getClarity()) + (TypeOfGem.valueOf(gem.getTypeName()).getColorFactor() * colorCalculate)));

        price *= gem.getCount() * ((100.0-percentageDiscount)/100.0);
        return price;
    }

    public static double calculateNecklacePrice (Necklace necklace, int percentageDiscount){
        double necklacePrice = 0.0;
        for (Gem gem : necklace.getGems()){
            necklacePrice += calculateGemPrice(gem, percentageDiscount);
        }
        return necklacePrice;
    }
}
