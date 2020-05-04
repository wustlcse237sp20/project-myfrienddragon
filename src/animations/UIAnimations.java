package animations;

import java.awt.Color;
import java.awt.Font;

import edu.princeton.cs.introcs.StdDraw;
import game.Dragon;

public class UIAnimations {

	public static void redrawUI(int amountOfFood) {
		Color pinkColor = new Color(255, 204, 250);
		StdDraw.setPenColor(pinkColor);
		StdDraw.filledRectangle(0, 0, 400, 75);
		StdDraw.picture(25, 40, "interface_resources/game_boy.png", 60, 60);
		StdDraw.picture(200, 40, "interface_resources/179-1797376_pizza-kawaii-pixel-art-kawaii-food-pixel-art.png",50, 50);
		StdDraw.setPenColor();
		Font font = new Font("Sans Serif", Font.PLAIN, 10);
		StdDraw.setFont(font);
		StdDraw.text(200, 10, "Current food amount: " + amountOfFood);
		StdDraw.setFont();
		StdDraw.picture(370, 40, "interface_resources/cursor_hand.png",60, 60);
	}

	public static void drawGameMenu() {
		StdDraw.clear();
		Color pinkColor = new Color(255, 204, 250);
		StdDraw.setPenColor(pinkColor);
		StdDraw.filledRectangle(200,300, 200,25);
		StdDraw.filledRectangle(200,225, 200,25);
		StdDraw.filledRectangle(200, 50, 100, 25);
		StdDraw.setPenColor();
		Font font = new Font("Arial", Font.BOLD, 24);
		StdDraw.setFont(font);
		StdDraw.text(200,350, "Minigame Menu");
		StdDraw.setFont();
		StdDraw.text(200, 300, "Play Space Invaders");
		StdDraw.text(200, 225, "Play Pong");
		StdDraw.text(200, 50, "Back to game");
	}

	public static void drawGameOverScreen() {
		StdDraw.clear();
		StdDraw.text(200, 200, "Congratulations!");
		StdDraw.text(200, 180, "You raised your dragon to an adult!");
		Color pinkColor = new Color(255, 204, 250);
		StdDraw.setPenColor(pinkColor);
		StdDraw.filledRectangle(200,50,100,50);
		StdDraw.setPenColor();
		StdDraw.text(200, 50, "Play again");
	}

}
