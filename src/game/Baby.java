package game;

import animations.DragonAnimation;

public class Baby implements Dragon {
	private int loveLevel;
	private int foodLevel;

	public Baby() {
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
		DragonAnimation.babyPet();
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
		DragonAnimation.babyEat();
	}
	
	
	public void show() {
		DragonAnimation.babyIdle();
	}
	
}
