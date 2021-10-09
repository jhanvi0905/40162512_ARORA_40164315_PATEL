// -----------------------------------------------------
// Assignment 1
// © Jhanvi Arora, Zalakben Rajendrakumar Patel
// Written by: Jhanvi Arora (40162512), Zalakben Rajendrakumar Patel (40164315)
// -----------------------------------------------------
import java.util.Scanner;

/**
 * Class maintaining Inventory of computer objects
 */
public class ComputerDriver {
	/*
	declared password
	 */
	String password = "password";

	/**
	 * Main menu Function
	 * @param inventory list of computer objects
	 */
	public void mainMenu(Computer[] inventory) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println("\nWhat do you want to do?");
			System.out.println("1. Enter new computers");
			System.out.println("2. Change information of a computer");
			System.out.println("3. Display all computers by a specific brand");
			System.out.println("4. Display all computers under a certain a price.");
			System.out.println("5. Quit");
			System.out.println("Please enter your choice > ");
			option = sc.nextInt();
			switch (option) {
			case 1:
				if (passwordAuthentication())
					addComputer(inventory);
				break;
			case 2:
				if (passwordAuthentication())
					updateComputer(inventory);
				break;
			case 3:
				findComputersWithBrand(inventory);
				break;
			case 4:
				findComputersWithLowerPrice(inventory);
				break;
			case 5:
				System.out.println("Quitting the program...");
				return;
			default:
				System.out.println("Wrong option!");
			}
		} while (option >= 1 && option <= 5);

	}

	/**
	 * validates password
	 * @return boolean true or false
	 */
	public boolean passwordAuthentication() {
		int NoOfTries = 0;
		Scanner sc = new Scanner(System.in);
		int flag = 0;
		do {
			System.out.println("Enter your password");
			String EnteredPass = sc.next();
			if (EnteredPass.equals(password)) {
				System.out.println("Authentication Successful");
				flag = 1;
				break;
			}
			NoOfTries++;
		} while (NoOfTries < 3);
		return flag == 1;
	}

	/**
	 * Adds a new computer in inventory and performs requried validations
	 * @param inventory computer list
	 */
	public void addComputer(Computer[] inventory) {
		int existingComputers = 0;
		int count = 1;
		int size = inventory.length;
		while (existingComputers < size && inventory[existingComputers] != null) {
			existingComputers++;
		}
		System.out.println("Existing computers : " + existingComputers);
		System.out.println("Number of Computers to enter in the inventory");
		Scanner sc = new Scanner(System.in);
		int noOfCompToAdd = sc.nextInt();
		if (size - existingComputers >= noOfCompToAdd) {
			for (int x = existingComputers; x < existingComputers + noOfCompToAdd; x++) {
				System.out.println("\nEnter information for Computer " + count);
				System.out.println("Enter the Brand name of the computer");
				String l_brand = sc.next();
				System.out.println("Enter the Model of the Computer");
				String l_model = sc.next();
				System.out.println("Enter the Serial Number of the Computer");
				long l_sn = sc.nextLong();
				System.out.println("Enter the Price of the Computer");
				double l_pr = sc.nextDouble();
				Computer l_c = new Computer(l_brand, l_model, l_sn, l_pr);
				inventory[x] = l_c;
				System.out.println("Computer added successfully.");
				count++;
			}
		} else {
			System.out.println("\nCannot add " + noOfCompToAdd + " computers, Only " + (size - existingComputers)
					+ " places remaining in inventory!");
		}
	}

	/**
	 * Updates the specified computer in inventory
	 * @param inventory computer inventory list
	 */
	public void updateComputer(Computer[] inventory) {
		boolean continueUpdate = true;
		System.out.println("Enter the computer number in inventory to update");
		Scanner sc = new Scanner(System.in);
		int indexToUpdate = sc.nextInt();
		if (indexToUpdate < inventory.length && inventory[indexToUpdate] != null) {
			System.out.println(inventory[indexToUpdate].toString());

			while (continueUpdate) {
				System.out.println("What information would you like to\n" + "change?\n" + "1. brand\n" + "2. model\n"
						+ "3. SN\n" + "4. price\n" + "5. Quit\n" + "Enter your choice >");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the new brand name");
					String newBrand = sc.next();
					inventory[indexToUpdate].setBrand(newBrand);
					System.out.println(inventory[indexToUpdate].toString());
					break;
				case 2:
					System.out.println("Enter the new model name");
					String newModel = sc.next();
					inventory[indexToUpdate].setModel(newModel);
					System.out.println(inventory[indexToUpdate].toString());
					break;
				case 3:
					System.out.println("Enter the new Serial Number");
					long newSn = sc.nextLong();
					inventory[indexToUpdate].setSN(newSn);
					System.out.println(inventory[indexToUpdate].toString());
					break;
				case 4:
					System.out.println("Enter the new Price");
					double newPr = sc.nextDouble();
					inventory[indexToUpdate].setPrice(newPr);
					System.out.println(inventory[indexToUpdate].toString());
					break;
				case 5:
					continueUpdate = false;
				default:
					System.out.println("Plese enter valid choice between number 1 to 5.");
					break;
				}
			}
		} else {
			Scanner st = new Scanner(System.in);
			System.out.println("No computer found at this location, do you want to add computer ?");
			String yn = st.next();
			if (yn.equals("yes") || yn.equals("Yes") || yn.equals("Y") || yn.equals("y")) {
				addComputer(inventory);
			}
		}
	}

	/**
	 * Finds all computer in inventory of a specific brand
	 * @param inventory inventory list of computer objects
	 */
	public void findComputersWithBrand(Computer[] inventory) {
		Scanner st = new Scanner(System.in);
		System.out.println("Enter a brand name to find matching computers.");
		String brandName = st.next();
		ComputerDriver.findComputersBy(brandName, inventory);
	}

	/**
	 * Helper function of searching computers by brand
	 * @param brandName Brand Name to search computers of
	 * @param inventory inventory computer list
	 */
	public static void findComputersBy(String brandName, Computer[] inventory) {
		for (Computer computer : inventory) {
			if (computer != null && computer.getBrand().equalsIgnoreCase(brandName)) {
				System.out.println(computer);
			}
		}
	}

	/**
	 * Finds the computer with lower price than specified price
	 * @param inventory computer list
	 */
	public void findComputersWithLowerPrice(Computer[] inventory) {
		Scanner st = new Scanner(System.in);
		System.out.println("Enter price to find suitable computers having smaller price than entered one.");
		double price = st.nextDouble();
		ComputerDriver.findCheaperThan(price, inventory);
	}

	/**
	 * Helper function to find lower priced computers
	 * @param price price to check against
	 * @param inventory computer list
	 */
	public static void findCheaperThan(double price, Computer[] inventory) {
		for (Computer computer : inventory) {
			if (computer != null && computer.getPrice() < price) {
				System.out.println(computer);
			}
		}
	}

	public static void main(String[] args) {
		ComputerDriver cd = new ComputerDriver();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter maximum number of Computers your compute store can contain: ");
		int size = sc.nextInt();
		Computer[] inventory = new Computer[size];
		cd.mainMenu(inventory);
	}
}
