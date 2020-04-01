package animations;
import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

//class puts resources into animation functions for the dragon


public class DragonAnimation {

	//	public static void main(String[] args) {
	//	eggIdle();
	//	}
	public static void redrawUI() {
		Color pinkColor = new Color(255, 204, 250);
		StdDraw.setPenColor(pinkColor);
		StdDraw.filledRectangle(0, 0, 1.2, 0.2);
		StdDraw.picture(0.05, 0.1, "interface_resources/game_boy.png", 0.2, 0.2);
		StdDraw.picture(0.5, 0.1, "interface_resources/179-1797376_pizza-kawaii-pixel-art-kawaii-food-pixel-art.png",0.2, 0.2 );
		StdDraw.picture(0.95, 0.1, "interface_resources/cursor_hand.png",0.2, 0.2 );
	}
	//Animation for egg idling (default egg animation)
	public static void eggIdle() {
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0.5,  0.5, "dragon_resources/egg/egg_idle_1.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
		StdDraw.picture(0.5, 0.5 , "dragon_resources/egg/egg_idle_2.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();

	}
	//Animation for egg eating
	public static void eggEat() {
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0.5,  0.5, "dragon_resources/egg/egg_eat_1.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
		StdDraw.picture(0.5, 0.5 , "dragon_resources/egg/egg_eat_2.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
	}
	//Animation for egg being pet
	public static void eggPet() {
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0.5,  0.5, "dragon_resources/egg/egg_pet_1.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
		StdDraw.picture(0.5, 0.5 , "dragon_resources/egg/egg_pet_2.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
	}
	//Animation for baby idling (default baby animation)
	public static void babyIdle() {
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0.5,  0.5, "dragon_resources/infant/baby_idle_1.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
		StdDraw.picture(0.5, 0.5 , "dragon_resources/infant/baby_idle_2.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
	}
	//Animation for baby eating
	public static void babyEat() {
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0.5,  0.5, "dragon_resources/infant/baby_eating_1.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
		StdDraw.picture(0.5, 0.5 , "dragon_resources/infant/baby_eating_2.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
	}
	//Animation for baby being pet
	public static void babyPet() {
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0.5,  0.5, "dragon_resources/infant/baby_pet_1.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
		StdDraw.picture(0.5, 0.5 , "dragon_resources/infant/baby_pet_2.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
	}
	//Animation for adult idling (default adult animation)
	public static void adultIdle() {
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0.5,  0.5, "dragon_resources/adult/adult_idle_1.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
		StdDraw.picture(0.5, 0.5 , "dragon_resources/adult/adult_idle_2.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
	}
	//Animation for adult eating
	public static void adultEat() {
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0.5,  0.5, "dragon_resources/adult/adult_eating_1.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
		StdDraw.picture(0.5, 0.5 , "dragon_resources/adult/adult_eating_2.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
	}

	//Animation for adult being pet
	public static void adultPet() {
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0.5,  0.5, "dragon_resources/adult/adult_pet_1.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
		StdDraw.picture(0.5, 0.5 , "dragon_resources/adult/adult_pet_2.png");
		redrawUI();
		StdDraw.show();
		StdDraw.pause(500);
		StdDraw.clear();
	}



}

