/**
 * 
 * @author Justin Baja - 000356032
 * 
 * This class creates a donut which is sold at Tims
 *
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Donut extends TimsProduct implements Consumable {
	
	/** Description of the product**/
	private String description;
	/** Calorie Count for the product**/ 
	private int calorieCount;
	
	private Donut(String name, String description, double cost, double price, int calories) {
		super(name,cost,price);
		this.description = description;
		calorieCount = calories;
	}
	
	/** Get users information about the donut they want **/
	public static Donut create() {
		/** Condition to run the loop while user enters a valid input **/
		boolean valid = false;
		/** Users donut choice **/
		String donutChoice = null;
		/** Description of the donut **/
		String description = null;
		/** Total calories for the donut **/
		int calorieCount = 0;
		/** Cost to produce the donut **/
		double cost = 0.10;
		/** Sale price of the donut **/
		double price = 0.99;
		
		Scanner input = new Scanner(System.in);
		
		/** Validates user input and checks which donut they wish to order **/
		while(!valid) {
			try {
				System.out.println("These are our freshly made donuts for today \n"
						+ "1.Chocolate Dip \n"
						+ "2.Sour Cream Glazed \n"
						+ "3.Old Fashion Plain \n"
						+ "4.Double Chocolate");
				int userInput = input.nextInt();
				
				switch(userInput) {
					case 1:
						donutChoice = "Chocolate Dip";
						description = "Tims classic Chocolate Dip donut";
						calorieCount = 210;
						valid = true;
						break;
					case 2:
						donutChoice = "Sour Cream Glazzed";
						description = "Mouth watering Sour Cream Glazed";
						calorieCount = 220;
						valid = true;
						break;
					case 3:
						donutChoice = "Old Fashion Plain";
						description = "A perfect complement with a coffee";
						calorieCount = 130;
						valid = true;
						break;
					case 4:
						donutChoice = "Double Chocolate";
						description = "For all those chocolate lovers";
						calorieCount = 230;
						valid = true;
						break;
				}
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid number, Please enter a number from the list above");
				input.next();
				System.out.println();
			}
		}
		Donut donut = new Donut(donutChoice,description,cost,price,calorieCount);
		
		return donut;
	}
	
	/** Returns the description of the product **/
	public String getDescription() {
		return description;
	}
	
	/** Returns the total calorie count **/
	public int getCalorieCount() {
		return calorieCount;
	}
	
	/** Returns the way the item is consumed **/
	public String getConsumptionMethod() {
		return "Eat it";
	}
	
	@Override
	public String toString() {
		return description + ", with a total calorie count of: " + calorieCount + ", in which you " +
					getConsumptionMethod();
	}
}
