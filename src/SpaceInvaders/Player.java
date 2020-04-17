package SpaceInvaders;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Player {

	// move with W, A, S, D
	
	// when implementing the player, we must continuously check
	// if StdDraw.hasNextKeyTyped() {
	// 		player.interpretKeyPressed(StdDraw.nextKeyTyped());
	// }
	// in the while(true) loop
	
	private int x;
	private int y;
	private int score;
	private int health;

	public Player() {
		this.x = 200;
		this.y = 50;
		this.score = 0;
		this.health = 100;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getScore() {
		return this.score;
	}
	
	public int getHealth() {
		return this.health;
	}

	public void isHit() {
		this.health -= 10;
	}

	public void didHitInvader() {
		this.score += 20;
	}

	public void interpretKeyPressed(char keyPressed) {
		if (keyPressed == 'w' || keyPressed == 's') {
			if (keyPressed == 'w') {
				this.movePlayer('y', 5);
			}
			else {
				this.movePlayer('y', -5);
			}
		}
		if (keyPressed == 'a' || keyPressed == 'd') {
			if (keyPressed == 'a') {
				this.movePlayer('x', -5);
			}
			else {
				this.movePlayer('x', 5);
			}
		}
	}

	private void movePlayer(char axis, int dist) {
		if (checkInBounds(axis, dist)) {
			if (axis == 'y') {
				this.y += dist;
			}
			else {
				this.x += dist;
			}
		}
		// redraw UI
	}
	
	private boolean checkInBounds(char axis, int difference) {
		if (axis == 'y') {
			return (this.y + difference) <= 400 && (this.y + difference) >= 0;
		}
		if (axis == 'x') {
			return (this.x + difference) <= 400 && (this.x + difference) >= 0;
		}
		return false;
	}

}
