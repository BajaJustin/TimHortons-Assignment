import java.util.Scanner;
import javafx.scene.paint.Color;
/**
 * 
 * @author Justin Baja - 000356032
 * 
 * This class creates a Hat product sold at Tims
 *
 */
public class Hat extends TimsProduct {
	/** Size of the hat **/
	private String size;
	/** Color of the hat **/
	private Color color;
	/** String value of color **/
	private String hatColor;
	
	private Hat(String name, String size, double cost, double price, Color color) {
		super(name,cost,price);
		this.size = size;
		this.color = color;
	}
	
	/** Get users information about the Hat they want **/
	public static Hat create() {
		Scanner input = new Scanner(System.in);
		/** Changes to True if user enters valid input, false otherwise **/
		boolean valid = false;
		/** Size of the hat **/
		String hatSize = null;
		/** Color of the hat **/
		Color color = Color.WHITE;
		String hatColor = null;
		/** Name of the product **/
		String product = "Hat";
		/** Cost to produce Tims Hat **/
		double cost = 0.05;
		/** Retail price for Tims Hat **/
		double price = 2.99;
		
		/** Runs and validates until user enter valid data **/
		while(!valid) {
			try {
				System.out.println("What hat size would you like? \n"
						+ "1. Small \n"
						+ "2. Medium \n"
						+ "3. Large");
				int userInput = input.nextInt();
				
				switch(userInput) {
					case 1:
						hatSize = "Small";
						valid = true;
						break;
					case 2:
						hatSize = "Medium";
						valid = true;
						break;
					case 3:
						hatSize = "Large";
						valid = true;
						break;
				}
				/** Resets valid back to false **/
				valid = false;
				System.out.println("Which color would you like? \n"
						+ "1. Black \n"
						+ "2. White");
				userInput = input.nextInt();
				
				switch(userInput) {
					case 1:
						color = Color.BLACK;
						hatColor = "Black";
						valid = true;
						break;
					case 2:
						color = Color.WHITE;
						hatColor = "White";
						valid = true;
						break;
				}
				
			}
			catch(Exception ex) {
				System.out.println("Invalid number, please enter a valid number");
				input.next();
				System.out.println();
			}
		}// End of while loop
		
		Hat hat = new Hat(product,hatSize,cost,price,color);
		
		return hat;
	}
	
	/** Returns the color of the hat **/
	public Color getColor() {
		return color;
	}
	
	@Override
	public String toString() {
		if(color.equals(Color.WHITE)) {
			hatColor = "White";
		}else {
			hatColor = "Black";
		}
		return "The following item has been added to your order: " + size + " Hat, Color: " 
			+ hatColor + ", Price: " + super.getRetailPrice();
	}
	
}
