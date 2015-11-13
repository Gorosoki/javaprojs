/**
 * class assists with getting values
 * 
 * @author Gavin Goroski & Aaron Mead
 */

public class Order {
	String name, appetizers, drinks, entrees, desserts;

	public Order(String name, String appetizers, String drinks, String entrees,
			String desserts) {
		this.name = name;
		this.appetizers = appetizers;
		this.drinks = drinks;
		this.entrees = entrees;
		this.desserts = desserts;
				
	}

	public String getDrinks() {
		return drinks;

	}

	public String getAppetizers() {
		return appetizers;

	}

	public String getEntrees() {
		return entrees;

	}

	public String getName() {
		return name;

	}

	public String getDesserts() {
		return desserts;

	}
}
