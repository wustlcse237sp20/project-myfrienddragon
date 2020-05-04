package SpaceInvaders;

import java.awt.Font;

import edu.princeton.cs.introcs.StdDraw;
import game.GameMenuInteractions;
import game.Interactions;
import game_abstractions.GameManager;
import game_abstractions.GameScene;

public class GameOverScreen extends GameScene {
	int frame;
	GameMenuInteractions interactionLevel;
	double mouseX;
	double mouseY;
	boolean clicked;
	
	public GameOverScreen(GameManager manager, GameScene parent) {
		super(manager, parent);
		this.frame = 0;
		this.mouseX = 0;
		this.mouseY = 0;
		this.clicked = false;
		
		
	}
	
	
	private void displayButtons() {
		Font font = new Font("Courier", Font.PLAIN, 14);
		StdDraw.setFont(font);
		StdDraw.rectangle(120, 190, 45, 25);
		StdDraw.text(120, 190, "Play again");
		StdDraw.rectangle(280, 190, 45, 25);
		StdDraw.text(280, 190, "Main game");
	}
	
	private void displayCongratsMessage() {
		Font font = new Font("Courier", Font.BOLD, 24);
		StdDraw.setFont(font);
		StdDraw.text(200, 275, "Game Over");
	}
	
	private void drawScreen() {
		this.displayButtons();
		this.displayCongratsMessage();
		
	}
	
	
		
	public GameMenuInteractions checkSceneInteraction(double mouseX, double mouseY) {
		if ((mouseX > 235 && mouseX < 325) && (mouseY > 175   && mouseY < 215 )) {
			return GameMenuInteractions.back;
		}
		if ((mouseX > 75  && mouseX < 165 ) && (mouseY > 175 && mouseY < 215)) {
			return GameMenuInteractions.invaders;
			
		}
		return GameMenuInteractions.wait;
		
	}

	
	public void respondToInteraction(GameMenuInteractions interactionLevel, int frame) {
		if (interactionLevel == GameMenuInteractions.back) {
			System.out.println(this.parent.getParent().toString());
			this.getGameManager().setScene(this.parent.getParent());
		}
		if (interactionLevel == GameMenuInteractions.invaders) {
			GameScene newInvaders = new GameBoard(this.getGameManager(), this.parent.getParent());
			this.getGameManager().setScene(newInvaders);
			
		}
		if (interactionLevel == GameMenuInteractions.wait) {
			this.drawScreen();
		}
		
		
	}
	
	public GameMenuInteractions renewInteraction() {
		if (StdDraw.isMousePressed()) {
			 clicked = true;
			 mouseX = StdDraw.mouseX();
			 mouseY = StdDraw.mouseY();
		}
		if (clicked == true && !StdDraw.isMousePressed()) {
				clicked = false;
				 interactionLevel = this.checkSceneInteraction(mouseX, mouseY);
				if (interactionLevel != GameMenuInteractions.wait) {
					frame = 0;
				}
				
		}
		return interactionLevel;
	}
	
	public void update() {
		if (frame == 30) {
			interactionLevel = GameMenuInteractions.wait;
			frame = 0;
		}
		frame++;
		System.out.println(frame);
		interactionLevel = this.renewInteraction();
		this.respondToInteraction(interactionLevel, frame);
		}

	}

