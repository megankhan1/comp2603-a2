public class Driver {
    public static void main(String [] args){
        Bird b = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        System.out.println(b);

        b.logSighting("2026-06-10", "Caroni Swamp");
        System.out.println(b.getSightingCount());
        System.out.println(b.getLastSighting());

        Bird b2 = new Bird("Scarlet", "Emerald", "Tobago", 0.35, "Healthy", 60.0, true);
        System.out.println(b2.getLastSighting());

        Sanctuary s = new Sanctuary("S", "Trinidad", 100);

        s.addAnimal(b);
        s.addAnimal(b2);

        s.printRoster();
    }
}
