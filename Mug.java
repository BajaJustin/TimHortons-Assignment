import javafx.scene.paint.Color;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author Justin Baja - 000356032
 * 
 *This class creates a mug sold at Tims which can be four different colors
 *
 */
public class Mug extends TimsProduct {
	
	/** Color of the mug **/
	private Color color;

	private Mug(String name, Color color, double cost, double price) {
		super(name, cost, price);
		this.color = color;
	}

	/** Get users information about the Mug they want **/
	public static Mug create() {
		Scanner input = new Scanner(System.in);
		/** Validation for user input **/
		boolean valid = false;
		/** Name of product **/
		String product = "Mug";
		/** Default mug color **/
		Color mugColor = Color.WHITE;
		/** Cost to make **/
		double cost = 0.10;
		/** Retail price **/
		double price = 4.99;
		
		/** Runs until user enters a valid number **/
		while (!valid) {
			System.out.println("Which color of Mug would you like? \n" 
					+ "1. Black \n" 
					+ "2. Tims Brown \n"
					+ "3. Snow White \n" 
					+ "4. Dark Brown");
			try {
				int userInput = input.nextInt();
				switch (userInput) {
				case 1:
					mugColor = Color.BLACK;
					valid = true;
					break;
				case 2:
					mugColor = Color.ROSYBROWN;
					valid = true;
					break;
				case 3:
					mugColor = Color.SNOW;
					valid = true;
					break;
				case 4:
					mugColor = Color.SADDLEBROWN;
					valid = true;
					break;
				default:
					System.out.println("I'm sorry, that's a invalid product.");
					System.out.println();
				}
			} catch (InputMismatchException ex) {
				System.out.println("Invalid product, please enter a valid product number.");
				input.next();
				System.out.println();
			}
		}
		Mug mug = new Mug(product,mugColor, cost, price);

		return mug;
	}

	/** Returns the color of the mug **/
	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		/** String value of color **/
		String mugColor;
		if(color.equals(Color.BLACK)) {
			mugColor = "Black";
		} else if(color.equals(Color.ROSYBROWN)) {
			mugColor = "Tims Brown";
		} else if(color.equals(Color.SNOW) ) {
			mugColor = "Snow White";
		} else {
			mugColor = "Dark Brown";
		}
		return "We have added Tims coffee mug, color: " + mugColor + " to your order" 
				+ " Price: " + super.getRetailPrice() ;
	}

}
