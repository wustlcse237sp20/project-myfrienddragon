package game;

import animations.DragonAnimation;


public class Baby implements Dragon {

	public int foodLevel;
	public int loveLevel;
	public int age;
	public int fullFood;
	public int fullHealth;
	public FoodInventory foodInventory;

	public Baby(FoodInventory foodInventory) {
		this.foodLevel = 0;
		this.loveLevel = 0;
		this.age = 1;
		this.fullFood = 100;
		this.fullHealth= 100;
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
			this.foodInventory.removeFood();
			this.foodLevel += 20;
		}
		return this.foodLevel;
	}

	public Dragon ageUp() {
		Adult dragon = new Adult(this.foodInventory);
		return dragon;
	}
	
	@Override
	public boolean willAge() {
		if (this.foodLevel == fullFood && this.loveLevel == fullHealth) {
			return true;
		}
		return false;
	}

	public void animateFeed(int frame) {
		DragonAnimation.babyEat(frame);
	}

	public void animatePet(int frame) {
		DragonAnimation.babyPet(frame);
	}

	@Override
	public void animateIdle(int frame) {
		DragonAnimation.babyIdle(frame);
	}
	
	public void animateEvolve(int frame) {
		DragonAnimation.evolve(frame);
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
	@Override
	public void update(Interactions interactionValue, int frame) {
		if (interactionValue ==  Interactions.idle) {
			this.animateIdle(frame);
		}
		if (interactionValue == Interactions.feed && this.foodInventory.getFoodAmount()>0) {
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


