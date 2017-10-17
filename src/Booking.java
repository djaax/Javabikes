import java.time.LocalDate;

public class Booking {
	LocalDate date;
	String bookingRef;
	int bikeId, customerId;
	double price;
	
	Booking(int newBikeId, double newPrice, int activeCustomerId) {
		date 		= LocalDate.now();
		bikeId 		= newBikeId;
		price 		= newPrice;
		customerId 	= activeCustomerId;
		bookingRef  = makeBookingRef();
	}
	
	public String makeBookingRef() {
		return date + "/" + bikeId + "/" + customerId;
	}
	
	public String getBookingRef() {
		return bookingRef;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public int getBikeId() {
		return bikeId;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setBikeId(int newBikeId) {
		bikeId = newBikeId;
	}
	
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	
	public void setCustomerId(int newCustomerId) {
		customerId = newCustomerId;
	}
	
	public void print() {
		System.out.println("\n\n\tYOUR BOOKING");
		System.out.printf("\t  | %-15s | %-7s | %-8s | %-11s | %-10s |\n", "Booking Ref", "Bike ID", "Price", "Customer ID", "Date");
		System.out.printf("\t  | %-15s | %-7s | %-8s | %-11s | %-10s |\n\n",
				this.getBookingRef(), this.getBikeId(), this.getPrice(), this.getCustomerId(), this.getDate());
	}
}