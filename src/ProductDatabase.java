import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDatabase {		
	private List<Bike> bikes;

	ProductDatabase() {
		bikes = new ArrayList<Bike>();
	}
	
    public void addBike(Bike bike) {
    		bikes.add(bike);
    }

    public void getByType(String type) {
    		System.out.println("\n\n\tALL BIKE TYPE: "+type+"\n");
    		System.out.printf("\t  | %-2s | %-15s | %-12s | %-9s |\n", "ID", "Type", "Description", "Brand");

    		for ( Bike bike : bikes ) {
    			if ( bike.getType().contains(type) ) {
    				System.out.printf("\t  | %-2d | %-15s | %-12s | %-9s |\n",
    						bike.getBikeId(), bike.getType(), bike.getDescription(), bike.getBrand());
    			}
    		}
    }

    public void getByBrand(String brand) {
    		System.out.println("\n\n\tALL BIKE BRAND: "+brand+"\n");
		System.out.printf("\t  | %-2s | %-15s | %-12s | %-9s |\n", "ID", "Type", "Description", "Brand");

		for ( Bike bike : bikes ) {
			if ( bike.getBrand().contains(brand) ) {
				System.out.printf("\t  | %-2d | %-15s | %-12s | %-9s |\n",
						bike.getBikeId(), bike.getType(), bike.getDescription(), bike.getBrand());
			}
		}
    }

    public void getAll() {
    		System.out.println("\n\n\tALL BIKE\n");
		System.out.printf("\t  | %-2s | %-15s | %-12s | %-9s |\n", "ID", "Type", "Description", "Brand");

		for ( Bike bike : bikes ) {
			System.out.printf("\t  | %-2d | %-15s | %-12s | %-9s |\n",
					bike.getBikeId(), bike.getType(), bike.getDescription(), bike.getBrand());
		}
    	}
    
    public void print() {		
		System.out.println("\n\n\tAVAILABLE BIKES:\n");

		System.out.printf("\t  | %-2s | %-4s | %-15s | %-12s |\n", "ID", "Type", "Description", "Brand");
		for (Bike bike : bikes) {
			if (bike.checkAvailability()) {
				System.out.printf("\t  | %-2d | %-4s | %-15s | %-12s |\n",
						bike.getBikeId(), bike.getType(), bike.getDescription(), bike.getBrand());
			}
		}
    }
}

/*
 * 	public void addBike() {
		Scanner input = new Scanner(System.in);
	
		System.out.println("Bike type (m/w/k):");
		type = input.nextLine();
	
		System.out.println("Bike description:");
		description = input.nextLine();
	
		System.out.println("Bike brand:");
		brand = input.nextLine();
	
		System.out.println("Bike is available:");
		isAvailable = input.nextBoolean();
	
		Bike newBike = new Bike(id, type, description, brand, isAvailable); 
		bikes.add(newBike);
	}
*/
 */