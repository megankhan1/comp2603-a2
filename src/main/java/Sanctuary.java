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
}
