package wipro;

abstract class Person {
    abstract void eat();
    abstract void exercise();
}

class Athlete extends Person {
    @Override
    void eat() {
        System.out.println("Athlete eats a high-protein, balanced diet.");
    }

    @Override
    void exercise() {
        System.out.println("Athlete exercises daily with strength and cardio training.");
    }
}

class LazyPerson extends Person {
    @Override
    void eat() {
        System.out.println("Lazy person eats fast food and snacks.");
    }

    @Override
    void exercise() {
        System.out.println("Lazy person rarely exercises and prefers watching TV.");
    }
}

// Main class
public class Wipro_21 {
    public static void main(String[] args) {
        Person athlete = new Athlete();
        Person lazy = new LazyPerson();

        System.out.println("=== Athlete ===");
        athlete.eat();
        athlete.exercise();

        System.out.println("\n=== Lazy Person ===");
        lazy.eat();
        lazy.exercise();
    }
}
/*=== Athlete ===
Athlete eats a high-protein, balanced diet.
Athlete exercises daily with strength and cardio training.

=== Lazy Person ===
Lazy person eats fast food and snacks.
Lazy person rarely exercises and prefers watching TV.
*/
