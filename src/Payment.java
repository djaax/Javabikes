import java.util.Scanner;

public class Payment {
	private String bookingRef, paymentMethod;
	private int receiptNo;
	private double amount;

	// Credit Card
	private String ccNumber, ccExpiryDate, ccSecurityCode;
	private String mpMobilePhone;

	Payment(String newBookingRef, double newAmount, int newReceiptNo) {
		Scanner input = new Scanner(System.in);

		bookingRef 		= newBookingRef;
		amount 			= newAmount;
		receiptNo 		= newReceiptNo+1;
		ccNumber 		= null;
		ccExpiryDate		= null;
		ccSecurityCode 	= null;
		mpMobilePhone 	= null;
		
		System.out.println("Do you want to pay with credit card or MobilePay?");
		System.out.println("Press 1 for credit card and 2 for MobilePay.");
		int prompt = input.nextInt();
		
		switch (prompt) {
			case 1: 	paymentMethod = "creditcard";
					payWithCreditCard();
					break;
			case 2: 	paymentMethod = "mobilepay";
					payWithMobilePay();
					break;
		}
	}

	public void payWithCreditCard() {
		System.out.println("You chose Credit Card.");
		ccNumber 		= ccInputNumber();
		ccExpiryDate 	= ccInputExpiryDate();
		ccSecurityCode	= ccInputSecurityCode();
	}
	
	public String getBookingRef() {
		return bookingRef;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public int getReceiptNo() {
		return receiptNo;
	}

	public String ccGetNumber() {
		return ccNumber;
	}

	public String ccGetLastFour() {
		return ccNumber.substring(ccNumber.length()-4);
	}

	public String ccGetExpiryDate() {
		return ccExpiryDate;
	}

	public String ccGetCvvCode() {
		return ccSecurityCode;
	}

	private String ccInputNumber() {
		Scanner input = new Scanner(System.in);
		String cardNumber;

		do {
			System.out.print("Enter your card number (16 digits):");
			cardNumber = input.nextLine();
		} while(cardNumber.length() != 16);

		return cardNumber;
	}

	private String ccInputExpiryDate() {
		Scanner input = new Scanner(System.in);
		String expDate;
		
		do {
			System.out.print("Enter your expiry date (MM/YYYY):");
			expDate = input.nextLine();
		} while(!expDate.matches("\\d{2}/\\d{4}"));

		return expDate;
	}
	
	private String ccInputSecurityCode() {
		Scanner input = new Scanner(System.in);
		String cvv;
			
		do {
			System.out.print("Enter your CVV (3 digits):");
			cvv = input.nextLine();
		} while(cvv.length() != 3);

		return cvv;
	}

	public String payWithMobilePay() {
		mpMobilePhone = mpInputNumber();
		return mpMobilePhone;
	}

	private String mpInputNumber() {
		Scanner input = new Scanner(System.in);
		String telNumber;

		do {
			System.out.print("Enter your telephone number:");
			telNumber = input.nextLine();
		} while(telNumber.length() == 0);

		return telNumber;
	}

	public void print() {
		System.out.println("\n\n\tYOUR RECEIPT");
		System.out.printf("\t  | %-18s | %-8s | %-12s |\n", "Booking Reference", "Amount", "Receipt No");
		System.out.printf("\t  | %-18s | %-8s | %-12s |\n\n",
				this.getBookingRef(), this.getAmount(), this.getReceiptNo());
	}
}