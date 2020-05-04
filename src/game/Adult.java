package game;

import animations.DragonAnimation;
import edu.princeton.cs.introcs.StdDraw;


public class Adult implements Dragon {

	public int foodLevel;
	public int loveLevel;
	public int age;
	public FoodInventory foodInventory;

	public Adult(FoodInventory foodInventory) {
		this.foodLevel = 0;
		this.loveLevel = 0;
		this.age = 2;
		this.foodInventory=foodInventory;
	}

	public int getAge() {
		return this.age;
	}

	public int getFoodLevel() {
		return this.foodLevel;
	}

	public int getLoveLevel() {
		return this.loveLevel;
	}

	public int pet() {
		if (this.loveLevel < 100) {
			this.loveLevel += 20;
		}
		return this.loveLevel;
	}

	public int feed() {
		if (this.foodLevel < 100 && this.foodInventory.getFoodAmount() > 0) {
			this.foodLevel += 20;
			this.foodInventory.removeFood();
		}
		return this.foodLevel;
	}

	@Override
	public void animateFeed(int frame) {
		DragonAnimation.adultEat(frame);
	}

	@Override
	public void animatePet(int frame) {
		DragonAnimation.adultPet(frame);
	}

	@Override
	public void animateIdle(int frame) {
		DragonAnimation.adultIdle(frame);
	}

	public void animateEvolve(int frame) {
		DragonAnimation.evolve(frame);
	}

	public boolean willAge() {
		if (this.foodLevel == 100 && this.loveLevel == 100) {
			return true;
		}
		return false;
	}

	@Override
	public Dragon ageUp() {
		return null;
	}
	
	public void updateFoodStore(int foodToAdd) {
		this.foodInventory.addFood(foodToAdd);
	}

		

	/**
	 * returns an interaction based on where the user clicked
	 */
	/**
	 * displays the proper animation updates the dragon based on user interaction
	 */
	public void update(Interactions interactionValue, int frame) {
		if (interactionValue ==  Interactions.idle) {
			this.animateIdle(frame);
		}
		if (interactionValue == Interactions.feed && this.foodInventory.getFoodAmount() > 0) {
			this.animateFeed(frame);
			if (frame == 0) {
				this.feed();
			}
		}
		if (interactionValue == Interactions.pet) {
			this.animatePet(frame);
			if (frame == 0) {
				this.pet();
			}
		}
	}

	@Override
	public FoodInventory getFoodStore() {
		return this.foodInventory;
	}

}
