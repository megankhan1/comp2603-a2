public class Bird extends Animal implements Trackable {
    private double wingspanCm;
    private boolean canFly;

    public Bird(String species, String nickname, String island, double weightKg, String healthStatus, double wingspanCm, boolean canFly){
        super(species, nickname, island, weightKg, healthStatus);
        this.wingspanCm = wingspanCm;
        this.canFly = canFly;
    }

    @Override
    public String getType() {
        return "Bird";
    }

    @Override
    public double getDailyFoodCostTTD(){
        return 15.0 + getWeightKg() * 50.0;
     }

     public double getWingspanCm(){
        return this.wingspanCm;
     }

     public boolean canFly(){
        return this.canFly;
     }
}
