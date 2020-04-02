package game;

import animations.DragonAnimation;

public class Egg implements Dragon {
	private int loveLevel;
	private int foodLevel;

	public Egg() {
		loveLevel = 0;
		foodLevel = 0;
	}
	
	public void pet() {
		if (this.wantsToBePet()) {
			this.loveLevel++;
			this.animatePet();
		}
	}
	
	private boolean wantsToBePet() {
		if(loveLevel < 5) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void animatePet() {
		DragonAnimation.eggPet();
	}
	
	
	
	public void feed() {
		if (this.isHungry()) {
			this.foodLevel++;
			this.animateFeed();
		}
	}
	
	private boolean isHungry() {
		if(foodLevel < 5) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void animateFeed() {		
		DragonAnimation.eggEat();
	}
	
	
	public void show() {
		DragonAnimation.eggIdle();
	}
	
}
