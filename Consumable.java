/**
 * 
 * @author Justin Baja - 000356032
 * 
 * This interface creates two methods that define consumption
 *
 */
public interface Consumable {
	
	/** A contract for calorie count **/
	public abstract int getCalorieCount();
	
	/** A contract for the way the product is consumed **/
	public abstract String getConsumptionMethod();
	
}
