import java.util.ArrayList;

public abstract class Animal {
    private static int nextId = 1;

    private int animalId;
    private String species;
    private String nickname;
    private String island;
    private double weightKg;
    private String healthStatus;
    private ArrayList<String> sightings;

    public Animal(String species, String nickname, String island, double weightKg, String healthStatus){
        if(species != null){
            this.species = species;
        }
        else{
            throw new IllegalArgumentException();
        }

        if(nickname != null){
            this.nickname = nickname;
        }
        else{
            throw new IllegalArgumentException();
        }

        if(island != null){
            this.island = island;
        }
        else{
            throw new IllegalArgumentException();
        }

        if(weightKg > 0){
            this.weightKg = weightKg;
        }
        else{
            throw new IllegalArgumentException();
        }

        if(healthStatus.equals("Healthy") || healthStatus.equals("Injured") || healthStatus.equals("Critical")){
            this.healthStatus = healthStatus;
        }
        else{
            throw new IllegalArgumentException();
        }

        this.animalId = nextId;

        nextId++;

        sightings = new ArrayList<>();
    }

    public int getAnimalId() {
        return this.animalId;
    }

    public String getSpecies() {
        return this.species;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getIsland() {
        return this.island;
    }

    public double getWeightKg() {
        return this.weightKg;
    }

    public String getHealthStatus() {
        return this.healthStatus;
    }

    protected ArrayList<String> getSigtings(){
        return this.sightings;
    }

    public void logSighting(String date, String location){
        sightings.add(date + " at " + location);
    }

    public int getSightingCount(){
        return sightings.size();
    }

    public String getLastSighting(){
        if(sightings.isEmpty()){
            return "No sightings recorded";
        }
        else{
            return sightings.get(sightings.size() - 1);
        }
    }

    public void updateHealth(String newStatus){
        if(newStatus.equals("Healthy") || newStatus.equals("Injured") || newStatus.equals("Critical")){
            this.healthStatus = newStatus;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public abstract String getType();

    public abstract double getDailyFoodCostTTD();

    public void setIsland(String island){
        this.island = island;
    }

    @Override
    public String toString(){
        return String.format("#%03d %s '%s' (%s) [%s] %.2f kg - %s",
                getAnimalId(), getSpecies(), getNickname(), getIsland(),
                getType(), getWeightKg(), getHealthStatus());
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Animal){
            Animal a = (Animal) obj;
            if(this.animalId == a.animalId)
                return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(animalId);
    }
}
