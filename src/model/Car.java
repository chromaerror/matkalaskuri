package model;

public class Car {
	
	// VARIABLES
	private String make, model;
	private double consumption;
	
	// TO STRING
	@Override
	public String toString() {
		return "make=" + this.getMake() + ", model=" + this.getModel() + ", consumption=" + this.getConsumption();
	}
	
	// GETTERS
	public double getConsumption() { return this.consumption; }
	public String getMake() { return this.make; }
	public String getModel() { return this.model; }
	
	// SETTERS
	public boolean setConsumption(double newValue) {
		try {
			this.consumption = newValue;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void setMake(String make) { this.make = make; }
	public void sestModel(String model) { this.model = model; }
	
	// CONSTRUCTORS
	public Car() {
		this.make = "";
		this.model = "";
		this.consumption = 0.0;
	}
	
	public Car(String make) {
		this.make = make;
		this.model = "";
		this.consumption = 0.0;
	}
	
	public Car(String make, String model) {
		this.make = make;
		this.model = model;
		this.consumption = 0.0;
	}
	
	public Car(String make, String model, double consumption) {
		this.make = make;
		this.model = model;
		this.consumption = consumption;
	}
	
	public double calculateUsedFuel(double distance) {
		double consumptionPerHundred;
		consumptionPerHundred = this.consumption * (distance / 100);
		return consumptionPerHundred;
		
	}
	
	
}
