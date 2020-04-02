package game;

import animations.DragonAnimation;

public class Adult implements Dragon {
	private int loveLevel;
	private int foodLevel;
	
	public Adult() {
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
		DragonAnimation.adultPet();
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
		DragonAnimation.adultEat();
	}
	
	
	public void show() {
		DragonAnimation.adultIdle();
	}

}
