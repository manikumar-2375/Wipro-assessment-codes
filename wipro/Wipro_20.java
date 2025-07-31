package wipro;

abstract class Vehicles {
    abstract void startEngine();
    abstract void stopEngine();
}

class Cars extends Vehicles {
    @Override
    void startEngine() {
        System.out.println("Car engine started with key ignition.");
    }

    @Override
    void stopEngine() {
        System.out.println("Car engine stopped by turning off the key.");
    }
}

class Motorcycles extends Vehicles {
    @Override
    void startEngine() {
        System.out.println("Motorcycle engine started with self-start button.");
    }

    @Override
    void stopEngine() {
        System.out.println("Motorcycle engine stopped by pressing the stop switch.");
    }
}

// Main class
public class Wipro_20 {
    public static void main(String[] args) {
        Vehicles car = new Cars();               
        Vehicles bike = new Motorcycles();       

        System.out.println("=== Car ===");
        car.startEngine();
        car.stopEngine();

        System.out.println("\n=== Motorcycle ===");
        bike.startEngine();
        bike.stopEngine();
    }
}
/*=== Car ===
Car engine started with key ignition.
Car engine stopped by turning off the key.

=== Motorcycle ===
Motorcycle engine started with self-start button.
Motorcycle engine stopped by pressing the stop switch.
*/
