package game;

import animations.DragonAnimation;

/**
 * @author juliasmith
 *
 */
/**
 * @author juliasmith
 *
 */
public class Egg implements Dragon {

	public int foodLevel;
	public int loveLevel;
	public int age;
	
	public Egg() {
		this.foodLevel = 0;
		this.loveLevel = 0;
	}
	
	// increments the love level of the dragon if it is not already maxed out and returns the current love level
	public int pet() {
		if (this.loveLevel < 5) {
			this.loveLevel++;
		}
		return this.loveLevel;
	}
	
	// increments the food level of the dragon if it is not already maxed out and returns the current food level
	public int feed() {
		System.out.println("Current food level: " + this.foodLevel);
		if (this.foodLevel < 5) {
			this.foodLevel++;
<<<<<<< Updated upstream
			System.out.println(this.foodLevel);
=======
<<<<<<< Updated upstream
		System.out.println("Current food level: " + this.foodLevel);
=======
>>>>>>> Stashed changes
>>>>>>> Stashed changes
		}
		return this.foodLevel;
	}
	
	// increases the age of the dragon by 1 and animates the dragon at its new age
	public Dragon ageUp() {
		if (this.foodLevel == 5) {
			Baby dragon = new Baby();
			return dragon;
			
		}
		return this;
	}
	

	//plays dragon-age-appropriate animation for being pet based on the frame count
	@Override
	public void animatePet(int frame) {
		// TODO Auto-generated method stub
		DragonAnimation.eggPet(frame);
	}

	//plays dragon-age-appropriate animation for eating based on the frame count
	@Override
	public void animateFeed(int frame) {
		DragonAnimation.eggEat(frame);
	}

	//plays dragon-age-appropriate animation for idling based on the frame count
	@Override
	public void animateIdle(int frame) {
		DragonAnimation.eggIdle(frame);
		
	}

	
	//returns an interaction enum value of the dragon based on where the user clicked
	@Override
	public Interactions checkInteraction(double mouseX, double mouseY) {
			if ((mouseX > 25 && mouseX < 85) && (mouseY > 20 && mouseY < 100)) {
				return Interactions.game;
				
			}
			if ((mouseX > 175 && mouseX< 250) && (mouseY > 20 && mouseY<100)) {
				 return Interactions.feed;
			}
			if ((mouseX >350 && mouseX < 410 ) && (mouseY > 20 && mouseY < 100)) {
				return Interactions.pet;
			}
			else {
				return Interactions.idle;
			}
		
		}

	//updates game by telling int what animation to play and what to update in dragon class
	@Override
	public void update(Interactions interactionValue, int frame) {
		if (interactionValue ==  Interactions.idle) {
			this.animateIdle(frame);
		}
		if (interactionValue == Interactions.feed) {
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


	
}
