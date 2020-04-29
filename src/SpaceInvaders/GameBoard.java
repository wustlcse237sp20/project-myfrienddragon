package SpaceInvaders;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import edu.princeton.cs.introcs.StdDraw;

//main game class. aggregates functions from other classes to create game
public class GameBoard {
	int score;
	int frameCounter;
	Player player;
	Fleet fleet;
	DragonBulletCollection dragonBullets;
	
	public void setUpGame() {
		setUpBoard();
		setUpSprites();
	}
	
	
	private void setUpBoard() {
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		score = 0;
		frameCounter = 0;
	}
	
	private void setUpSprites() {
		initPlayer();
		initFleet();
	}

	public void initPlayer() {
		player = new Player();
		dragonBullets = new DragonBulletCollection();
	}
	
	public void initFleet() {
		fleet = new Fleet();
		fleet.addRowOfInvaders();
	}

	public void playGame() {
		while (gameOver() == false){
			//randomly shoot bullets every couple seconds
			if (frameCounter % 20 == 0) {
				fleet.shootBullets();	
			}
			//spawn new row of invaders every 10 seconds
			if (frameCounter == 300) {
				fleet.addRowOfInvaders();
				frameCounter = 0;
			}
			frameCounter++;
			this.fieldUpdates();
			StdDraw.clear();
			this.drawSprites();
			StdDraw.show();
			StdDraw.pause(66);
		}
		endGame();
		StdDraw.show();
	}
	
	private boolean gameOver() {
		if(fleet.getInvaders().size() == 0) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private void endGame() {
		displayCongratsMessage();
		displayButtons();
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
		StdDraw.text(200, 275, "Congrats you won!");
	}
	
	private void fieldUpdates() {
		player.updatePlayer(dragonBullets, fleet);
		dragonBullets.update();
		fleet.update(dragonBullets);
		updateScore();
	}
	
	private void updateScore() {
		int invadersDestroyed = fleet.getNumInvadersDestroyed();
		score = invadersDestroyed * 20;
	}
	
	public void drawSprites() {
		this.drawScoreBoard();
		this.drawPlayer();
		this.drawFleet();
		this.drawDragonBullets();
		this.drawSpaceInvaderBullets();
	}
	
	private void drawScoreBoard() {
		StdDraw.rectangle(60, 80, 55, 15);
		
		Font font = new Font("Courier", Font.BOLD, 16);
		StdDraw.setFont(font);
		StdDraw.text(60.0, 80.0, "Score: " + score);
	}
	
	private void drawPlayer() {
		StdDraw.picture(player.getX(), player.getY(), "space_invaders_resources/flying_dragon-red-RGB.png");
	}
	  
	private void drawFleet() {
		Iterator<Invader> it = fleet.getInvaders().iterator(); 
	    while (it.hasNext()) {
	    	Invader element = it.next();
	       	StdDraw.picture(element.getX(), element.getY(), "space_invaders_resources/space_invader_ship.png");
	    }
	}  
	  
	private void drawDragonBullets() {
	    Iterator<DragonBullet> it = dragonBullets.getBullets().iterator(); 
        while (it.hasNext()) {
       		DragonBullet element = it.next();
            StdDraw.picture(element.getX(), element.getY(), "space_invaders_resources/dragon_shot.png");         
		}
	}
	
	private void drawSpaceInvaderBullets() {
		Iterator<SpaceInvaderBullet> it = fleet.getBullets().iterator();
		while(it.hasNext()) {
			SpaceInvaderBullet element = it.next();
			StdDraw.picture(element.getX(), element.getY(), "space_invaders_resources/invader_shot.png");
		}
	}
}