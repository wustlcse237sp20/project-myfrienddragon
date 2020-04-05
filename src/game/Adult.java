package game;

import animations.DragonAnimation;
import edu.princeton.cs.introcs.StdDraw;

public class Adult implements Dragon {

	public int foodLevel;
	public int loveLevel;
	public int age;
	
	public Adult() {
		this.foodLevel = 0;
		this.loveLevel = 0;
		this.age = 2;
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
		if (this.foodLevel < 5) {
			this.foodLevel++;
		}
		return this.foodLevel;
	}
	

	@Override
	public void animateFeed(int frame) {
		DragonAnimation.adultEat(frame);
	}
	
	// displays the proper animation for petting the dragon

	@Override
	public void animatePet(int frame) {
		DragonAnimation.adultPet(frame);
		
	}

	@Override
	public void animateIdle(int frame) {
		DragonAnimation.adultIdle(frame);
		
	}

	@Override
	public Interactions checkInteraction(double mousex, double mousey) {
			if ((mousex > 25 && mousex < 85) && (mousey > 20 && mousey < 100)) {
				return Interactions.game;
				
			}
			if ((mousex > 175 && mousex< 250) && (mousey > 20 && mousey<100)) {
				 return Interactions.feed;
			}
			if ((mousex >350 && mousex < 410 ) && (mousey > 20 && mousey < 100)) {
				return Interactions.pet;
			}
			else {
				return Interactions.idle;
      }
		
}

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

	
	@Override
	public Dragon ageUp() {
		if (this.foodLevel == 5 && this.loveLevel == 5) {
		StdDraw.clear();
		StdDraw.text(200, 200, "Congratulations, you raised your dragon to an adult");
		}
		return this;
	}
}
