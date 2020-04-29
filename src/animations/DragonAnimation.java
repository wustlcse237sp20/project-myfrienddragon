package animations;
import java.awt.Color;
import java.awt.Font;

import edu.princeton.cs.introcs.StdDraw;

//class puts resources into animation functions for the dragon


public class DragonAnimation {


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
	public static void evolve(int frameCounter) {
		StdDraw.clear();
		StdDraw.setPenColor();
		Font font = new Font("Arial", Font.BOLD, 12);
		StdDraw.setFont(font);
		StdDraw.text(200, 350, "Your dragon is evolving into a new form!");
		if (frameCounter > 0 && frameCounter < 6) {
			StdDraw.picture(200,200, "dragon_resources/sparkle-frame-1.png");
		}
		else if (frameCounter > 6 && frameCounter < 12) {
			StdDraw.picture(200,200, "dragon_resources/sparkle-frame-2.png");
		}
		else if (frameCounter > 12 && frameCounter < 18) {
			StdDraw.picture(200,200, "dragon_resources/sparkle-frame-3.png");
		}
		else if (frameCounter > 18 && frameCounter < 24) {
			StdDraw.picture(200,200, "dragon_resources/sparkle-frame-4.png");
		}
		else if (frameCounter > 24 && frameCounter < 30) {
			StdDraw.picture(200,200, "dragon_resources/sparkle-frame-5.png");
		}
	}
}

