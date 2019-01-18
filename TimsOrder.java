import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author Justin Baja - 000356032
 * 
 * This class creates an order of Tims Products
 * 
 *
 */
public class TimsOrder {
	
	/** Size of the order **/
	private int size;
	/** Name of the customer **/
	private String name;
	/** Array of Tims Products **/
	private TimsProduct[] order;

	private TimsOrder(String name, int size) {
		this.name = name;
		this.size = size;
	}
	/** Get users information about their order**/
	public static TimsOrder create() {
		Scanner input = new Scanner(System.in);
		/** validation for user input **/
		boolean valid = false;
		/** Customers order size **/
		int userInput = 0;
		
		System.out.println("Hello, Welcome to Tim Hortans!\nMay I get your name please?");
		String userName = input.nextLine();
		
		/** Runs the loop until user enters a valid number **/
		while(!valid) {
			try {
				System.out.println("How many items would you like ?");
				userInput = input.nextInt();
				valid = true;
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid number");
				input.next();
				System.out.println();
			}
		}
		/** An array of customers order **/
		TimsProduct[] order = new TimsProduct[userInput];
		/** Position of customers order in an array **/
		int position = 0;
		/** Runs until all items are ordered **/
		int count = userInput;
		/** Total order Price **/
		double price = 0;
		
		/** Runs until all the orders are added to **/
		while(count > 0) {
			try {
				System.out.println("1. Mug \n"
						+ "2. Donut \n"
						+ "3. Green Tea \n"
						+ "4. Hat");
				userInput = input.nextInt();
				
				switch(userInput) {
					case 1:
						/** Gets users Mug information **/
						Mug mug = Mug.create();
						order[position] = mug;
						price += mug.getRetailPrice();
						position++;
						count--;
						break;
					case 2:
						/** Gets users Donut information **/
						Donut donut = Donut.create();
						order[position] = donut;
						price += donut.getRetailPrice();
						position++;
						count--;
						break;
					case 3:
						/** Gets users GreenTea information **/
						GreenTea greenTea = GreenTea.create();
						order[position] = greenTea;
						price += greenTea.getRetailPrice();
						position++;
						count--;
						break;
					case 4:
						/** Gets users Hat information **/
						Hat hat = Hat.create();
						order[position] = hat;
						price += hat.getRetailPrice();
						position++;
						count--;
						break;
				}
				/** Rounds to 2 decimal places **/
				price = (double) Math.round(price * 100) / 100;
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid Item, please enter a valid items number");
				input.next();
				System.out.println();
			}
		}
		/** Prints out the order **/
		for(int i = 0; i < order.length; i++) {
			System.out.println(order[i]);
		}
		System.out.println("Your total is: " + price);
		TimsOrder timsOrder = new TimsOrder(userName,userInput);
		
		return timsOrder;
	}
	
	/** Returns the total amount due **/
	public double getAmountDue() {
		double price = 0;
		order = new TimsProduct[size];
		for(int i = 0; i < order.length; i++) {
			price = order[i].getRetailPrice();
		}
		return price;
	}
	
	@Override
	public String toString() {
		return "Order for: " + name;
	}
}
