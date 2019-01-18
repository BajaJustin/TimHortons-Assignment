/**
 * 
 * @author Justin Baja - 000356032
 * This interface is like a contract for two methods, product cost and retail price
 *
 */
public interface Commodity {
	
	/**A contract for the cost of the product**/
	public abstract double getProductionCost();
	
	/**A contract for the price of the product**/
	public abstract double getRetailPrice();
}
