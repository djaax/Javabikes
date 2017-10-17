import java.util.Scanner;

public class Bike {
	private int id;
	private String description, brand, type;
	private Boolean isAvailable;

	private int dailyPrice 	= 100;
	private int weeklyPrice 	= 500;
	private double vat	 	= 0.25;

	public Bike (int newId, String newType, String newDescription, String newBrand, Boolean newIsAvailable) {
		Scanner input = new Scanner(System.in);
		
		id 			= newId;
		type 		= newType;
		description	= newDescription;
		brand		= newBrand;
		isAvailable = newIsAvailable;
	}

	public int getBikeId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public double calcPrice(int days) {
		int remainingDays 	= days%7;
		int weeks 			= (days-remainingDays)/7;
		double price 		= (remainingDays*dailyPrice + weeks*weeklyPrice)*(1+vat);

		return price;
	}

	public String getBrand() {
		return brand;
	}

	public String getDescription() {
		return description;
	}

	public Boolean checkAvailability() {
		return isAvailable;
	}

	public void select() {
		isAvailable = false;
		System.out.println("You have selected bike ID: "+id);
	}
	
	public void printBike() {
		System.out.println("\n\n\tAVAILABLE BIKES: \n");

		System.out.printf("\t  | %-2s | %-15s | %-12s | %-9s |\n", "ID", "Type", "Description", "Brand");
		System.out.printf("\t  | %-2d | %-15s | %-12s | %-9s |\n",
				this.getBikeId(), this.getType(), this.getDescription(), this.getBrand());
	}

}