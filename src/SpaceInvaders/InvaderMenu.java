package SpaceInvaders;

import java.awt.Color;
import java.awt.Font;

import edu.princeton.cs.introcs.StdDraw;

public class InvaderMenu {
	static boolean exit = false;
	
	public static void endGame() {
		displayButtons();
		displayCongratsMessage();
	}
	
	private static void displayButtons() {
		Color pinkColor = new Color(255, 204, 250);
		StdDraw.setPenColor(pinkColor);
		StdDraw.filledRectangle(200, 225, 200, 25);
		StdDraw.filledRectangle(200, 300, 200, 25);
		StdDraw.setPenColor(Color.black);
		StdDraw.setFont();
		StdDraw.text(200, 225, "Play again");
		StdDraw.text(200, 300, "Main game");
	}
	
	private static void displayCongratsMessage() {
		Font font = new Font("Arial", Font.BOLD, 24);
		StdDraw.setFont(font);
		StdDraw.text(200, 350, "Congrats you won!");
	}
	
	public static void checkInteraction() {
		if (StdDraw.isMousePressed()) {
			double mouseY = StdDraw.mouseY();
			if (mouseY > 200 && mouseY < 250) {
				GameBoard game = new GameBoard();
				game.setUpGame();
				game.playGame();
			}
			if (mouseY > 275 && mouseY< 325) {
			
			}
		}
	}
}
