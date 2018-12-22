import java.util.Scanner;

import gui.Gui;
import model.Car;

public class MainClass {

	public static void main(String[] args) {
		String startAddress = "Lintukallionrinne 7, Vantaa";
		String destination = "Riihitontuntie 1, Vantaa";
		Gui frame = new Gui();
		frame.setVisible(true);
		//showMenu();
		/*double distance = 0.0;
		try {
			distance = Api.getDistance(startAddress, destination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Car car = new Car("Audi", "A4", 7.89);
		System.out.println("From " + startAddress + " to " + destination + " is " + distance + " kilometers.");
		System.out.println(car.getMake() + " " + car.getModel() + " spends "  + car.calculateUsedFuel(distance) +
				" litres of fuel on this trip of " + distance + "km");*/
	}
	
	public static void showMenu() {
		
		Scanner sc = new Scanner(System.in);
		Car car = new Car();
		
		String startLocation, endLocation;
		double consumption;
		
		System.out.print("Insert starting location (Address, ZIP code) ");
		startLocation = sc.nextLine();
		System.out.print("Insert ending location (Address, ZIP code) ");
		endLocation = sc.nextLine();
		while(true) {
			System.out.print("Please insert fuel consumption (l/100km) ");
			try {
				consumption = Double.parseDouble(sc.nextLine());
				car.setConsumption(consumption);
				break;
			} catch(Exception e) {
				System.out.println("Consumption has to be a number");
			}
		}
		
		
		sc.close();
		
	}
}
