package wipro;

class Worker {
    protected String name;
    protected double salaryRate;

    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    public double pay(int hours) {
        return 0;
    }

    public String getName() {
        return name;
    }
}


class DailyWorker extends Worker {
    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double pay(int hours) {
        int daysWorked = hours / 8;
        return daysWorked * salaryRate;
    }
}

class SalariedWorker extends Worker {
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double pay(int hours) {
        return 40 * salaryRate; 
    }
}



public class Wipro_13 {

	public static void main(String[] args) {
		 DailyWorker d1 = new DailyWorker("Mani", 500);     
	        SalariedWorker s1 = new SalariedWorker("Kiran", 100); 

	        System.out.println("Pay for Daily Worker " + d1.getName() + ": ₹" + d1.pay(48));   // 48 hrs => 6 days
	        System.out.println("Pay for Salaried Worker " + s1.getName() + ": ₹" + s1.pay(48)); // Always 40 * 100

	}

}
/*Pay for Daily Worker Mani: ₹3000.0
Pay for Salaried Worker Kiran: ₹4000.0
*/