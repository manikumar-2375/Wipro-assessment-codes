package wipro;

class Vehicle {
    String color;
    int wheels;
    String model;

    
    Vehicle(String color, int wheels, String model) {
        this.color = color;
        this.wheels = wheels;
        this.model = model;
    }

   
    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("No of Wheels: " + wheels);
    }
}


class Car extends Vehicle {
    Car(String color, int wheels, String model) {
        super(color, wheels, model);  
    }

    void carFeature() {
        System.out.println("Car Feature: AC and Bluetooth Audio");
    }
}


class Truck extends Vehicle {
    Truck(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    void truckFeature() {
        System.out.println("Truck Feature: Heavy Load Carrier");
    }
}


class Bus extends Vehicle {
    Bus(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    void busFeature() {
        System.out.println("Bus Feature: 50-seater with Luggage space");
    }
}

public class Road_17 {
	
	

	public static void main(String[] args) {
		
		Car car = new Car("Red", 4, "Hyundai i20");
        Truck truck = new Truck("Blue", 6, "Tata Lorry");
        Bus bus = new Bus("Yellow", 6, "Volvo Bus");

        System.out.println("=== Car ===");
        car.displayInfo();
        car.carFeature();

        System.out.println("\n=== Truck ===");
        truck.displayInfo();
        truck.truckFeature();

        System.out.println("\n=== Bus ===");
        bus.displayInfo();
        bus.busFeature();

	}

}
/*=== Car ===
Model: Hyundai i20
Color: Red
No of Wheels: 4
Car Feature: AC and Bluetooth Audio

=== Truck ===
Model: Tata Lorry
Color: Blue
No of Wheels: 6
Truck Feature: Heavy Load Carrier

=== Bus ===
Model: Volvo Bus
Color: Yellow
No of Wheels: 6
Bus Feature: 50-seater with Luggage space
*/