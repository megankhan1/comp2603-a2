import java.util.ArrayList;

public class Sanctuary {
    private String name;
    private String island;
    private int capacity;
    private ArrayList<Animal> animals;

    public Sanctuary(String name, String island, int capacity){
        this.name = name;
        this.island = island;
        this.capacity = capacity;

        animals = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public String getIsland(){
        return this.island;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public ArrayList <Animal> getAnimals(){
        return animals;
    }

    public boolean addAnimal(Animal a){
        if(a == null)
            return false;
        if(animals.size() >= capacity)
            return false;
        if(!a.getIsland().equals(island))
            return false;

        animals.add(a);
        return true;
    }

    public Animal removeAnimal(int animalId){
        for(Animal a : animals){
            if(a.getAnimalId() == animalId){
               Animal aR = a;
               animals.remove(a);
               return aR;
            }
        }
        return null;
    }

    public int getAnimalCount(){
        return animals.size();
    }

    public void printRoster(){
        for(Animal a : animals){
            System.out.println("  " + a);
        }
    }

    @Override
    public String toString(){
        return name + " (" + island + ") [" +  getAnimalCount() + "/" + getCapacity() + " animals]";
    }

    public ArrayList<Animal> getAnimalsOfType(String type){
        ArrayList<Animal> byType = new ArrayList<>();
        for(Animal a : animals) {
            if (a.getType().equals(type)) {
                byType.add(a);
            }
        }
        return byType;
    }

    public double getDailyFoodBudget(){
        double total = 0.0;

        for(Animal a : animals){
            total += a.getDailyFoodCostTTD();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public Animal getMostExpensiveAnimal(){
        double maxCost = 0.0;
        Animal maxA = null;
        for(Animal a : animals){
            if(a == null)
                return null;
            else if(a.getDailyFoodCostTTD() > maxCost){
                maxCost = a.getDailyFoodCostTTD();
                maxA = a;
            }
        }
        return maxA;
    }

    public ArrayList<Animal> etRelocatableAnimals(){
        ArrayList<Animal> relocatable = new ArrayList<>();
        for(Animal a : animals){
            if(a instanceof Relocatable){
                relocatable.add(a);
            }
        }
        return relocatable;
    }

    public boolean transferAnimal(int animalId, Sanctuary target){
        Animal a = removeAnimal(animalId);
        if(a == null){
            return false;
        }
        if(!(a instanceof Relocatable)){
            addAnimal(a);
            return false;
        }
        Relocatable r = (Relocatable) a;
        r.relocateTo(target.getIsland());
        if(!target.addAnimal(a)){
            r. relocateTo(this.getIsland());
            addAnimal(a);
            return false;
        }
        return true;
    }
}
