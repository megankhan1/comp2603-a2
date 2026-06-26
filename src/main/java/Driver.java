public class Driver {
    public static void main(String [] args){
        Sanctuary caroni = new Sanctuary("Caroni", "Trinidad", 20);
        Sanctuary blueLagoon = new Sanctuary("Blue Lagoon", "Jamaica", 15);

        Bird b = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        Bird b2 = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
        Bird b3 = new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
        Reptile r = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
        Reptile r2 = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
        Marine m = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000);

        caroni.addAnimal(b);
        caroni.addAnimal(b2);
        caroni.addAnimal(b3);
        caroni.addAnimal(m);
        caroni.addAnimal(r);
        caroni.addAnimal(r2);

        Bird b4 = new Bird("Doctor Bird", "Flash", "Jamaica", 0.01, "Healthy", 12.0, true);
        Marine m2 = new Marine("Kawksbill Turtle", "Shelly", "Jamaica", 80.0, "Injured", 50.0, 3000);
        Marine m3 = new Marine("Nurse Shark", "Gills", "Jamaica", 110.0, "Healthy", 75.0, 5000);

        blueLagoon.addAnimal(b4);
        blueLagoon.addAnimal(m2);
        blueLagoon.addAnimal(m3);

        System.out.println("=== Caroni Bird Sanctuary roster ===");

        caroni.printRoster();

        System.out.println("=== Blue Lagoon Marine Park roster ===");

        blueLagoon.printRoster();

        System.out.println("=== Daily food budgets ===");

        System.out.println("Caroni Bird Sanctuary: " + caroni.getDailyFoodBudget());

        System.out.println("Blue Lagoon Marine Park: " + blueLagoon.getDailyFoodBudget());

        System.out.println("=== Birds at Caroni ===");

        for(Animal a : caroni.getAnimalsOfType("Bird")){
            System.out.println(a);
        }

        System.out.println("=== Relocatable animals at Caroni ===");

        for(Animal a : caroni.getRelocatableAnimals()){
            System.out.println(a);
        }

        System.out.println("=== Sighting logs ===");

        b.logSighting("25-06-2026", "Caroni Swamp");
        m.logSighting("25-06-2026", "Caroni Swamp");

        System.out.println(b.getSightingCount());
        System.out.println(b.getLastSighting());

        System.out.println(m.getSightingCount());
        System.out.println(m.getLastSighting());

        System.out.println("=== Transfer Atlas to Blue Lagoon ===");

        System.out.println(caroni.transferAnimal(6, blueLagoon));

        blueLagoon.printRoster();

        System.out.println("=== Attempt to transfer Brutus (Reptile) ===");

        System.out.println(caroni.transferAnimal(4, blueLagoon));

        System.out.print("=== Most expensive animal at each sanctuary ===\n");

        System.out.println(caroni.getMostExpensiveAnimal());

        System.out.println(blueLagoon.getMostExpensiveAnimal());

        System.out.println("=== Daily food budgets ===");

        System.out.println("Caroni Bird Sanctuary: " + caroni.getDailyFoodBudget());

        System.out.println("Blue Lagoon Marine Park: " + blueLagoon.getDailyFoodBudget());
    }
}
