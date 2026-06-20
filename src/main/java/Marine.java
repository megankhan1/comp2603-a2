public class Marine extends Animal implements Trackable {
    private double maxDepthM;
    private int tankSizeLitres;

    public  Marine(String species, String nickname, String island, double weightKg, String healthStatus, double maxDepthM, int tankSizeLitres){
        super(species, nickname, island, weightKg, healthStatus);
        this.maxDepthM = maxDepthM;
        this.tankSizeLitres = tankSizeLitres;
    }

    @Override
    public String getType(){
        return "Marine";
    }

    @Override
    public double getDailyFoodCostTTD(){
        return 50.0 + getWeightKg() * 3.0;
    }

    public double getMaxDepthM(){
        return this.maxDepthM;
    }
    public int getTankSizeLitres(){
        return this.tankSizeLitres;
    }
}
