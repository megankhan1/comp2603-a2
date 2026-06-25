public class Driver {
    public static void main(String [] args){
        Bird b = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        System.out.println(b);

        b.logSighting("2026-06-10", "Caroni Swamp");
        System.out.println(b.getSightingCount());
        System.out.println(b.getLastSighting());

        Bird b2 = new Bird("Scarlet", "Emerald", "Trinidad", 0.40, "Healthy", 60.0, true);
        System.out.println(b2.getLastSighting());

        Sanctuary s = new Sanctuary("S", "Trinidad", 100);

        s.addAnimal(b);
        s.addAnimal(b2);

        s.printRoster();

        Bird b3 = new Bird("Dove", "Polly", "Trinidad", 0.25, "Healthy", 60.0, true);
        Marine m = new Marine("Fish", "Nemo", "Trinidad", 500, "Healthy", 10, 15);

        s.addAnimal(b3);

        Reptile r = new Reptile("Lizard", "Lizzy", "Trinidad", 45.0, "Healthy", false, 5);
        Reptile r2 = new Reptile("Lizard", "Mr Kiplin", "Trinidad", 30.0, "Healthy", false, 10);

        s.addAnimal(r);
        s.addAnimal(r2);
        s.addAnimal(m);

        System.out.println(b3.canRelocateTo("Jamaica"));
        System.out.println(m.canRelocateTo("Jamaica"));

        System.out.println(s.getDailyFoodBudget());
        System.out.println(s.getMostExpensiveAnimal());
    }
}
