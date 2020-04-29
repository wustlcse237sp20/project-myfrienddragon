package animations;
import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import game.Dragon;

//class puts resources into animation functions for the dragon


public class DragonAnimation {

	public static void redrawUI() {
		Color pinkColor = new Color(255, 204, 250);
		StdDraw.setPenColor(pinkColor);
		StdDraw.filledRectangle(0, 0, 400, 75);
		StdDraw.picture(25, 40, "interface_resources/game_boy.png", 60, 60);
		StdDraw.picture(200, 40, "interface_resources/179-1797376_pizza-kawaii-pixel-art-kawaii-food-pixel-art.png",60, 60 );
		StdDraw.picture(370, 40, "interface_resources/cursor_hand.png",60, 60);
	}

	public static void drawLifeBars(Dragon d) {
		drawFoodBar(d);
		drawLoveBar(d);
	}

	private static void drawFoodBar(Dragon d) {
		if (d.getFoodLevel() < 20) {
			StdDraw.picture(130, 350, "interface_resources/foodbar/foodbar0%.png", 90, 50);
		}
		else if (d.getFoodLevel() < 40) {
			StdDraw.picture(130, 350, "interface_resources/foodbar/foodbar20%.png", 90, 50);
		}
		else if (d.getFoodLevel() < 60) {
			StdDraw.picture(130, 350, "interface_resources/foodbar/foodbar40%.png", 90, 50);
		}
		else if (d.getFoodLevel() < 80) {
			StdDraw.picture(130, 350, "interface_resources/foodbar/foodbar60%.png", 90, 50);
		}
		else if (d.getFoodLevel() < 100){
			StdDraw.picture(130, 350, "interface_resources/foodbar/foodbar80%.png", 90, 50);
		}
		else {
			StdDraw.picture(130, 350, "interface_resources/foodbar/foodbar100%.png", 90, 50);
		}
	}

	private static void drawLoveBar(Dragon d) {
		if (d.getLoveLevel() < 20) {
			StdDraw.picture(50, 355, "interface_resources/lovebar/healthbar0%.png", 80, 60);
		}
		else if (d.getLoveLevel() < 40) {
			StdDraw.picture(50, 355, "interface_resources/lovebar/healthbar20%.png", 80, 60);
		}
		else if (d.getLoveLevel() < 60) {
			StdDraw.picture(50, 355, "interface_resources/lovebar/healthbar40%.png", 80, 60);
		}
		else if (d.getLoveLevel() < 80) {
			StdDraw.picture(50, 355, "interface_resources/lovebar/healthbar60%.png", 80, 60);
		}
		else if (d.getLoveLevel() < 100){
			StdDraw.picture(50, 355, "interface_resources/lovebar/healthbar80%.png", 80, 60);
		}
		else {
			StdDraw.picture(50, 355, "interface_resources/lovebar/healthbarfull.png", 80, 60);
		}
	}

	//Animation for egg idling (default egg animation)
	public static void eggIdle(int frameCounter) {
		if (frameCounter > 0 && frameCounter < 14 ) {
			StdDraw.picture(200,  200, "dragon_resources/egg/egg_idle_1.png");
		}
		else if (frameCounter > 13 && frameCounter < 30 ) {
			StdDraw.picture(200, 200 , "dragon_resources/egg/egg_idle_2.png");
		}

	}
	
	//Animation for egg eating
	public static void eggEat(int frameCounter) {
		if (frameCounter > 0 && frameCounter < 14) {
			StdDraw.picture(200,  200, "dragon_resources/egg/egg_eat_1.png");
		}
		else if (frameCounter > 13 && frameCounter < 30) {
			StdDraw.picture(200, 200, "dragon_resources/egg/egg_eat_2.png");
		}
	}
	
	//Animation for egg being pet
	public static void eggPet(int frameCounter) {
		if (frameCounter > 0 && frameCounter < 14) {
			StdDraw.picture(200,  200, "dragon_resources/egg/egg_pet_1.png");
		}
		else if (frameCounter > 13 && frameCounter < 30) {
			StdDraw.picture(200, 200 , "dragon_resources/egg/egg_pet_2.png");
		}
	}

	//Animation for baby idling (default baby animation)
	public static void babyIdle(int frameCounter) {
		if (frameCounter > 0 && frameCounter < 14) {
			StdDraw.picture(200,  200, "dragon_resources/infant/baby_idle_1.png");
		}
		else if (frameCounter > 13 && frameCounter < 30) {
			StdDraw.picture(200, 200 , "dragon_resources/infant/baby_idle_2.png");
		}
	}
	
	//Animation for baby eating
	public static void babyEat(int frameCounter) {
		if (frameCounter > 0 && frameCounter < 14) {
			StdDraw.picture(200,  200, "dragon_resources/infant/baby_eating_1.png");
		}
		else if (frameCounter > 13 && frameCounter < 30) {
			StdDraw.picture(200, 200 , "dragon_resources/infant/baby_eating_2.png");
		}
	}

	public static void babyPet(int frameCounter) {
		if (frameCounter > 0 && frameCounter < 14) {
			StdDraw.picture(200,  200, "dragon_resources/infant/baby_pet_1.png");
		}
		else if (frameCounter > 13 && frameCounter < 30) {
			StdDraw.picture(200, 200 , "dragon_resources/infant/baby_pet_2.png");
		}
	}

	//Animation for adult idling (default adult animation)
	public static void adultIdle(int frameCounter) {
		if (frameCounter > 0 && frameCounter < 14) {
			StdDraw.picture(200,  200, "dragon_resources/adult/adult_idle_1.png");
		}
		else if (frameCounter > 13 && frameCounter < 30 ) {
			StdDraw.picture(200, 200 , "dragon_resources/adult/adult_idle_2.png");
		}
	}
	
	//Animation for adult eating
	public static void adultEat(int frameCounter) {
		if (frameCounter > 0 && frameCounter < 14) {
			StdDraw.picture(200,  200, "dragon_resources/adult/adult_eating_1.png");
		}
		else if (frameCounter > 13 && frameCounter < 30 ) {
			StdDraw.picture(200, 200 , "dragon_resources/adult/adult_eating_2.png");
		}
	}

	//Animation for adult being pet
	public static void adultPet(int frameCounter) {
		if (frameCounter > 0 && frameCounter < 14) {
			StdDraw.picture(200,  200, "dragon_resources/adult/adult_pet_1.png");
		}
		else if (frameCounter > 13 && frameCounter < 30 ) {
			StdDraw.picture(200, 200 , "dragon_resources/adult/adult_pet_2.png");
		}
	}
	
}

