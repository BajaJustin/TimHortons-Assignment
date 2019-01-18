import java.util.Scanner;
/**
 * 
 * @author Justin Baja - 000356032
 * 
 *This class creates a Green Tea which is sold at Tims
 *
 */
public class GreenTea extends TimsProduct  implements Consumable {
	/** If the user wants there tea steeped **/
	private String steeped;
	/** Size of the tea **/
	private String size;
	/** Total sugar in users green tea **/
	private int sugar;

	private GreenTea(String name,String size, int sugar, String steeped, double cost,
			double price) {
		super(name,cost,price);
		this.size = size;
		this.sugar = sugar;
		this.steeped = steeped;
	}
	
	/** Get users information about the Green tea they want **/
	public static GreenTea create() {
		Scanner input = new Scanner(System.in);
		/** Changes to True if user enters valid input, false otherwise **/
		boolean valid = false;
		/** Name of product **/
		String product = "Green Tea";
		/** Users input **/
		int userInput = 0;
		/** Cost to make Green Tea **/
		double cost = 0.50;
		/** Retail price for Green tea **/
		double price = 1.80;
		/** Green Tea size **/
		String size = null;
		/** Total number of sugar in users Green Tea **/
		int sugar = 0;
		/** Steeped Green Tea **/
		String steeped = null;

		/** Runs and validates until user enters the currect size **/
		while (!valid) {
			try {
				System.out.println(
						"What size of a Green tea would you like? \n" + "1. S \n" + "2. M \n" + "3. L \n" + "4. XL");
				userInput = input.nextInt();

				switch (userInput) {
				case 1:
					size = "Small";
					valid = true;
					break;
				case 2:
					size = "Medium";
					valid = true;
					break;
				case 3:
					size = "Large";
					valid = true;
					break;
				case 4:
					size = "Extra Large";
					valid = true;
					break;
				}
			} 
			catch (Exception ex) {
				System.out.println("Invalid Size");
				input.next();
				System.out.println();
			}
		}
		/** Resets valid back to false **/
		valid = false;
		/** Runs and validates until user enters the valid number for sugar **/
		while (!valid) {
			try {
				System.out.println("How many sugars would you like? \n" + "0 \n" + "1 \n" + "2");
				userInput = input.nextInt();

				switch (userInput) {
				case 0:
					sugar = 0;
					valid = true;
					break;
				case 1:
					sugar = 1;
					valid = true;
					break;
				case 2:
					sugar = 2;
					valid = true;
					break;
				}
			} 
			catch (Exception ex) {
				System.out.println("Invalid number, please enter the currect number");
				input.next();
				System.out.println();
			}
		} // End of the while loop

		/** Resets validation **/
		valid = false;
		/** Run and validates until user enters valid data **/
		while (!valid) {
			try {
				System.out.println("Would you like your tea steeped? \n" + "1. Yes \n" + "2. No");
				userInput = input.nextInt();

				switch (userInput) {
				case 1:
					steeped = "Yes";
					valid = true;
					break;
				case 2:
					steeped = "No";
					valid = true;
					break;
				}
			} 
			catch (Exception ex) {
				System.out.println("Invalid input, Please enter a valid number");
				input.next();
				System.out.println();
			}
		} // End of while loop
		GreenTea greentea = new GreenTea(product,size,sugar,steeped,cost,price);
		
		return greentea;
	}

	/** Returns the way the product is consumed **/
	public String getConsumptionMethod() {
		return "Drink it";
	}

	/** Returns calorie count **/
	@Override
	public int getCalorieCount() {
		int calorie = 5;
		return calorie;
	}
	
	@Override
	public String toString() {
		return size + " Green tea: " + sugar + " Sugar, Steeped: " + steeped + ", Calories: "
				+ getCalorieCount() + ". Be carful when you " + getConsumptionMethod();
	}
}
