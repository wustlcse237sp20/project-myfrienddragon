package SpaceInvaders;

import java.awt.Color;
import java.awt.Font;

import java.util.Iterator;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import edu.princeton.cs.introcs.StdDraw;

//main game class. aggregates functions from other classes to create game
public class GameBoard {
	int score;
	int frameCounter;
	int spawnCounter;
	Player player;
	Fleet fleet;
	DragonBulletCollection dragonBullets;
	
	public void setUpGame() {
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		score = 0;
		frameCounter = 0;
		spawnCounter = 0;
		this.initPlayer();
		this.initFleet();
	}


	public void playGame() {
		while (true){
			//randomly shoot bullets every couple seconds
			if (frameCounter % 20 == 0) {
				fleet.shootBullets();	
			}
			//spawn new row of invaders every 10 seconds
			if (frameCounter == 300) {
				fleet.addRowOfInvaders();
				frameCounter = 0;
			}
			//spawn new row of invaders every 10 seconds
			frameCounter++;
			this.fieldUpdates();
			StdDraw.clear();
			this.drawSprites();
			StdDraw.show();
			StdDraw.pause(66);
	}
			
}
	private void fieldUpdates() {
		player.updatePlayer(dragonBullets, fleet);
		dragonBullets.update();
		updateScore();
		fleet.update(dragonBullets, frameCounter);
	}
	
	private void updateScore() {
		int invadersDestroyed = fleet.getNumDestroyed();
		score = invadersDestroyed * 20;
	}
	
	private void drawScoreBoard() {
		StdDraw.setPenColor(Color.black);
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
	       	StdDraw.picture(element.getX(), element.getY(), element.getImage());
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
	
	public void initPlayer() {
		player = new Player();
		dragonBullets = new DragonBulletCollection();
	}
	
	public void initFleet() {
		fleet = new Fleet();
		fleet.spawnInvaders();
	}
	
	public void drawSprites() {
		this.drawScoreBoard();
		this.drawPlayer();
		this.drawFleet();
		this.drawDragonBullets();
		this.drawSpaceInvaderBullets();
	}
	
	public static void main (String[] args) {
		GameBoard game = new GameBoard();
		game.setUpGame();
		game.playGame();
	}
	


}