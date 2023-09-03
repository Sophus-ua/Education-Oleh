package Lesson_2_DAO.task_3.Jewelry;



public enum TypeOfGem {
    DIAMOND(10000,1.25, 0.5, 0.3),
    PEARL(5000,1.1, 0.9, 0.9),
    EMERALD(4000,1.1, 0.7, 0.8),
    RUBY(3000,1.2, 0.6, 0.7),
    AQUAMARINE(3000,1.05, 0.8, 0.7),
    TOPAZ(2500,1.1, 0.7, 0.6),
    SAPPHIRE(2000,1.15, 0.7, 0.9),
    AMETHYST(2500,1.05, 0.9, 0.5),
    GARNET(2000,1.05, 0.7, 0.9),
    CITRINE(2000,1.05, 0.8, 0.7),
    FIANIT(1500,	1.1, 0.8, 0.6),
    OPAL(1500,1.1, 0.9, 0.8),
    MALACHITE(1000,1.0, 0.7, 0.6),
    AGATE(1000,1.0, 0.8, 0.7);
    private double basePrice, weightFactor, clarityFactor, colorFactor;

    TypeOfGem (double basePrice, double weightFactor, double clarityFactor, double colorFactor){
        this.basePrice = basePrice;
        this.weightFactor = weightFactor;
        this.clarityFactor = clarityFactor;
        this.colorFactor = colorFactor;
    }
    public int getPlaceInHierarchy(){
        return this.ordinal()+1;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public double getWeightFactor() {
        return weightFactor;
    }

    public double getClarityFactor() {
        return clarityFactor;
    }

    public double getColorFactor() {
        return colorFactor;
    }
}
