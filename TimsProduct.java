/**
 * 
 * @author Justin Baja - 000356032
 * This class creates a Tims product
 *
 */
public abstract class TimsProduct implements Commodity {
	
	/**Name of the product**/
	private String name;
	/**Cost it takes to make the product**/
	private double cost;
	/**Price of the item**/
	private double price;
	
	public TimsProduct() {
		name = null;
		cost = 0;
		price = 0;
	}
	
	public TimsProduct(String name, double cost, double price) {
		this.name = name;
		this.cost = cost;
		this.price = price;
	}
	/**Returns name of customer**/
	public String getName() {
		return name;
	}
	/**Returns cost of product**/
	public double getProductionCost() {
		return cost;
	}
	/**Returns the retail price of the product**/
	public double getRetailPrice() {
		return price;
	}
		
	@Override
	public String toString() {
		return "Name: " + name + ", cost of item: " + cost + ", price in retail: " + price;
	}
}
