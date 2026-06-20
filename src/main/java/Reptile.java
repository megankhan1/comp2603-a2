public class Reptile extends Animal implements Trackable {
    private boolean isVenomous;
    private double lengthCm;

    public Reptile(String species, String nickname, String island, double weightKg, String healthStatus, boolean isVenomous, double lengthCm){
        super(species, nickname, island, weightKg, healthStatus);
        this.isVenomous = isVenomous;
        this.lengthCm = lengthCm;
    }

    @Override
    public String getType(){
        return "Reptile";
    }

    @Override
    public double getDailyFoodCostTTD(){
        return 25.0 + getWeightKg() * 2.0;
    }

    public boolean isVenomous(){
        return this.isVenomous;
    }

    public double getLengthCm(){
        return this.lengthCm;
    }
}
