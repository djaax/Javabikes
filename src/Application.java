import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(customers.size()));
		customers.add(new Customer(customers.size()));
		customers.add(new Customer(customers.size()));

		Login login = new Login();
		for ( Customer customer : customers ) {
	    		login.addCustomer(customer);
	    }

		Customer activeCustomer = login.login();
		activeCustomer.print();

		List<Bike> bikes = new ArrayList<Bike>();
		bikes.add(new Bike(1, "m", "Bike for men", "Opus Men", true));
		bikes.add(new Bike(2, "w", "Bike for women", "Opus Comfort", true));
		bikes.add(new Bike(3, "k", "Bike for kids", "Opus Kids", true));
		bikes.add(new Bike(4, "m", "Bike for men", "Herkules", true));
		bikes.add(new Bike(5, "w", "Bike for women", "Athene", true));
		bikes.add(new Bike(6, "k", "Bike for kids", "Cupid", true));
		bikes.add(new Bike(7, "m", "Bike for men", "Hermes", true));
		bikes.add(new Bike(8, "w", "Bike for women", "Aphrodite", false));
		bikes.add(new Bike(9, "k", "Bike for kids", "Thor", false));
		bikes.add(new Bike(10, "m", "Bike for men",  "Zeus", false));

	    ProductDatabase productDatabase = new ProductDatabase(); 
	    for ( Bike bike : bikes ) {
	    		productDatabase.addBike(bike);
	    }

	    productDatabase.print();

	    System.out.println("Which bike do you want to choose? (ID)");
		int bikeId = input.nextInt();

		Bike selectedBike = bikes.get(bikeId-1);
		selectedBike.select();
		
		System.out.println("How many days would you like to book your bike?");
		int days = input.nextInt();
		
		double toPay = selectedBike.calcPrice(days);
		
		List<Booking> bookings = new ArrayList<Booking>();
		Booking booking = new Booking(bikeId, toPay, activeCustomer.getId()); // activeCustomer.id
		bookings.add(booking);
		booking.print();
		
		System.out.println("Please pay " + toPay + " dkk.");
		
		List<Payment> payments = new ArrayList<Payment>();
		Payment payment = new Payment(booking.getBookingRef(), toPay, payments.size());
		payments.add(payment);
		payment.print();
		
		System.out.println("Thank you for your booking. Enjoy your ride!");
	}
}