import java.util.Scanner;

public class Customer {
	private String name, streetname, dob, telephone, cpr, firstname, lastname, houseNumber;
	private String username, password;
	private int id, postcode, space, firstDot, secondDot, day, month, year;
	boolean err = true;
	char dash;

	Scanner input = new Scanner(System.in);

	Customer(int size) {
		System.out.println("NEW CUSTOMER");
		
		id 			= size+1;
		name 		= inputName();
		streetname 	= inputStreetname();
		houseNumber 	= inputHouseNumber();
		postcode 	= inputPostcode();
		dob 			= inputDOB();
		telephone 	= inputTelephone();
		cpr 			= inputCPR();
		username 	= makeUsername();
		password 	= makePassword();
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return firstname + " " + lastname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getID() {
		return id;
	}
	
	public String getAddress() {
		return streetname + " " + houseNumber + " " + postcode;
	}
	
	public String getDOB() {
		return dob;
	}
	
	public String getTelephone() {
		return username;
	}
	
	public String getCPR() {
		return cpr;
	}
	
	public void setStreetname(String newStreetname) {
		streetname = newStreetname;
	}
	
	public void setHouseNumber(String newHouseNumber) {
		houseNumber = newHouseNumber;
	}
	
	public void setPostcode(int newPostcode) {
		postcode = newPostcode;
	}
	
	public void setTelephone(String newTelephone) {
		telephone = newTelephone;
	}
	
	public void newPassword(String newPassword) {
		password = newPassword;
	}
	
	
	public Boolean checkCredentials(String testUsername, String testPassword) {
		if ( username.equals(testUsername) && password.equals(testPassword) ) {
			return true;
		} else {
			return false;
		}
	}

	private String inputName() {
		System.out.println("What is your full name?");

		name = input.nextLine();

		// Get firstname, lastname
		space = name.indexOf(" ");
		firstname = name.substring(0, space);
		lastname = name.substring(space + 1);

		return name;
	}

	private String makeUsername() {
		username = firstname.substring(0, 1).toLowerCase() + lastname.substring(0, 3).toLowerCase();
		System.out.printf("Your username is %s\n", username);
		return username;
	}

	private String makePassword() {
		password = lastname.substring(0, 3).toLowerCase() + cpr.substring(cpr.length() - 4).toLowerCase();
		System.out.printf("Your password is %s.\n", password);
		return password;
	}

	private String inputStreetname() {
		// Get address
		System.out.printf("Thank you %s. Please now enter the name of your street\n", firstname);
		streetname = input.nextLine();
		return streetname;
	}
	
	private String inputHouseNumber() {
		// Housenumber
		System.out.printf("Thank you %s. Please now enter your house number\n", firstname);
		houseNumber = input.nextLine();
		return houseNumber;
	}
	
	private int inputPostcode() {
		// Postcode
		System.out.printf("Thanks %s. Please enter your postcode\n", firstname);
		postcode = input.nextInt();
		// https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-nextint-or-other-nextfoo
		input.nextLine();
		
		while (postcode > 9999 || postcode < 1000 ) {
			System.out.println("Whoops! Please make sure you entered a valid 4-digit postcode. Try again:");
			postcode = input.nextInt();
		}
		
		while (postcode >= 2500 || postcode <= 1000) {
			System.out.println("Sorry! We only lend  out bikes within the main Copenhagen area!");
		}

		return postcode;
	}

	private String inputDOB() {
		// Get DOB
		System.out.println("Ok, next, please enter your birthday in the format DD.MM.YYYY");
		err = true;
		while (err) {
			dob = input.nextLine();
			
			firstDot = dob.indexOf('.');
			secondDot = dob.indexOf('.', 5);

			while (firstDot < 0 || secondDot < 0) {
				System.out.println("Whoops! Please make sure you entered a valid birthday in the format DD.MM.YYYY. Try again:");
				// I repeat myself :(
				dob = input.nextLine();
				firstDot = dob.indexOf('.');
				secondDot = dob.indexOf('.', 5);
				
				/*
				 * Would like to set err = true and repeat the loop without the rest of it getting executed
				 */
			}
			
			day = Integer.parseInt(dob.substring(0, firstDot));
			month = Integer.parseInt(dob.substring(++firstDot, secondDot));
			year = Integer.parseInt(dob.substring(++secondDot));
			
			// Validate DOB
			if (day > 31 || month > 12 || year > 2017 || year < 1900) {
				System.out.println("The date you entered is invalid, please try again:");
				err = true;
			} else {
				err = false;
			}
		}

		return dob;
	}

	private String inputTelephone() {
		// Get telephone
		err = true;
		while (err) {
			System.out.println("Please now enter your 8-digit telephone number:");
			telephone = input.nextLine();
		
			// Check format
			if (telephone.length() != 8) {
				System.out.println("The number you entered is invalid.");
				err = true;
			} else {
				err = false;
			}
		}

		return telephone;
	}

	private String inputCPR() {
		// Get CPR
		err = true;
		cpr = ""; // why needed?
		while (err) {
			System.out.println("Please enter your 10-digit CPR number in the following format xxxxxx-xxxx:");
			cpr = input.nextLine();
	
			// Checking CPR if 10-digit
			dash = cpr.charAt(6);
			if (cpr.length() != 11 || dash != '-' ) {
				System.out.println("There was an error!");
				err = true;
			} else {
				err = false;
			}
		}

		return cpr;
	}
	
	public void print() {
		System.out.println("\n\n\tYOUR INFORMATION");
		System.out.printf("\t  | %-2s | %-15s | %-11s | %-8s |\n", "ID", "Name", "CPR", "Username");
		System.out.printf("\t  | %-2s | %-15s | %-11s | %-8s |\n\n",
				this.getId(), this.getName(), this.getCPR(), this.getUsername());
	}
}