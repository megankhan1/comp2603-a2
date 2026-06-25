public class Marine extends Animal implements Trackable {
    private double maxDepthM;
    private int tankSizeLitres;

    public Marine(String species, String nickname, String island, double weightKg, String healthStatus, double maxDepthM, int tankSizeLitres) {
        super(species, nickname, island, weightKg, healthStatus);
        this.maxDepthM = maxDepthM;
        this.tankSizeLitres = tankSizeLitres;
    }

    @Override
    public String getType() {
        return "Marine";
    }

    @Override
    public double getDailyFoodCostTTD() {
        return 50.0 + getWeightKg() * 3.0;
    }

    public double getMaxDepthM() {
        return this.maxDepthM;
    }

    public int getTankSizeLitres() {
        return this.tankSizeLitres;
    }

    public boolean canRelocateTo(String targetIsland){
        if(!targetIsland.equals(this.getIsland()))
            return true;
        return false;
    }

    public double getRelocationCost(){
        return 2000.0 + getTankSizeLitres() * 5.0;
    }

    public void relocateTo(String island){
        setIsland(island);
    }
}

