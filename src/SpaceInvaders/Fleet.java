package SpaceInvaders;

import java.util.ArrayList;
import java.util.Iterator;

public class Fleet {
	public ArrayList<Invader> invaders;
	public ArrayList<SpaceInvaderBullet> bullets;
	private final static int startingSize = 8; 

	public Fleet() {
		invaders = new ArrayList<Invader>();
		bullets = new ArrayList<SpaceInvaderBullet>();
	}

	public ArrayList<Invader> getInvaders() {
		return invaders;
	}
	public ArrayList<SpaceInvaderBullet> getBullets() {
		return bullets;
	}

	public void setInvaders(ArrayList<Invader> invaders) {
		this.invaders = invaders;
	}
	
	public void spawnInvaders() {
		for (int i = 0; i < startingSize; ++i) {
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
		Iterator<Invader> it = invaders.iterator(); 
		while (it.hasNext()) {
			Invader element = it.next();
			element.checkCollision(dragonBullets);
			if(!element.getOnScreen()) {
				it.remove();
			}
		}
		Iterator<SpaceInvaderBullet> it2 = bullets.iterator();
		while (it2.hasNext()) {
			SpaceInvaderBullet bullet = it2.next();
				bullet.update();
				if (bullet.getOnScreen()==false) {
					it2.remove();
				}
			}
		}
	


	public Invader getInvader(int i) {
		return this.invaders.get(i);
	}
}


