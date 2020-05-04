package game;

public class FoodInventory {
	
	int amountOfFood;

	public FoodInventory() {
		this.amountOfFood=0;
	}
	
	public int getFoodAmount() {
		return this.amountOfFood;
	}
	
	public void addFood(int amount) {
		this.amountOfFood+=amount;
	}
	
	public void removeFood() {
		this.amountOfFood=this.amountOfFood-1;
	}
	
}
