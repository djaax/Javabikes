import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
	private Boolean err = false;
	Scanner input = new Scanner(System.in);
	List<Customer> customers = new ArrayList<Customer>();

	public void addCustomer(Customer newCustomer) {
		customers.add(newCustomer);
	}

	public Customer login() {
		err = true;
		Boolean check = true;
		Customer activeCustomer = null;
		
		if ( check ) {
			int maxTries = 3;
			for (int tries = 1; tries <= 3; tries++) {
				int triesLeft = maxTries - tries;
				System.out.println("Login using your username and password");
				System.out.println("Username:");
				String usernameInput = input.nextLine();
				System.out.println("Password:");
				String passwordInput = input.nextLine();
				
				for ( Customer customer : customers ) {
					Boolean creentialsChecks = customer.checkCredentials(usernameInput, passwordInput);
					if ( creentialsChecks ) {
						System.out.println("You are now logged in…");
						activeCustomer = customer;
						break;
					} else {
						System.out.println("You pressed wrong password and/or username. You have " + triesLeft + " tries left.");
					}
					
					if ( triesLeft == 0 ) {
						System.out.println("Sorry you have exceeded the number of tries. Please try again after few hours");
					}
				} break;
			}
		} else {
			System.out.print("Goodbye!");
		}
		
		return activeCustomer;
	}

	public void isInArray(String username, String password) {
		for ( Customer customer : customers ) {
			Boolean creentialsChecks = customer.checkCredentials(username, password);
			
			if ( creentialsChecks ) {
				System.out.println("User is already stored in ArrayList.");
				break;
			} else {
				System.out.println("User is not in ArrayList.");
			}
		}
	}
}