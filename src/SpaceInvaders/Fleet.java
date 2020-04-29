package SpaceInvaders;

import java.util.ArrayList;
import java.util.Iterator;

public class Fleet {
	private ArrayList<Invader> invaders;
	private ArrayList<SpaceInvaderBullet> bullets;
	private int numInvadersDestroyed;
	private final static int numInvadersPerRow = 8; 

	public Fleet() {
		invaders = new ArrayList<Invader>();
		bullets = new ArrayList<SpaceInvaderBullet>();
		numInvadersDestroyed = 0;
	}

	public void setInvaders(ArrayList<Invader> invaders) {
		this.invaders = invaders;
	}
	
	public void spawnInvaders() {
		for (int i = 0; i < numInvadersPerRow; ++i) {
			Invader toAdd = new Invader(25 + (i * 50), 350);
			this.invaders.add(toAdd);
		}
	}
	
	public void shootBullets() {
		int chosenShooterIndex = (int)(Math.random()*this.invaders.size());
		Invader chosenShooter = this.invaders.get(chosenShooterIndex);
		SpaceInvaderBullet bullet = new SpaceInvaderBullet(chosenShooter.getX(), chosenShooter.getY());
		bullets.add(bullet);
	}

	public void addRowOfInvaders() {
		Iterator<Invader> it = this.invaders.iterator();
		while (it.hasNext()) {
			Invader element = it.next();
			element.move();
		}
		spawnInvaders();
	}
	
	public void update(DragonBulletCollection dragonBullets) {
		Iterator<Invader> invaderIterator = invaders.iterator(); 
		while (invaderIterator.hasNext()) {
			Invader invader = invaderIterator.next();
			if(invader.isHit(dragonBullets)) {
				invaderIterator.remove();
				numInvadersDestroyed++;
			}
		}
		Iterator<SpaceInvaderBullet> bulletIterator = bullets.iterator();
		while (bulletIterator.hasNext()) {
			SpaceInvaderBullet bullet = bulletIterator.next();
				bullet.update();
				if (bullet.getOnScreen()==false) {
					bulletIterator.remove();
				}
		}
	}
	
	public ArrayList<Invader> getInvaders() {
		return invaders;
	}
	public ArrayList<SpaceInvaderBullet> getBullets() {
		return bullets;
	}
	
	public int getNumInvadersDestroyed() {
		return numInvadersDestroyed;
	}

	public Invader getInvader(int i) {
		return this.invaders.get(i);
	}
}


