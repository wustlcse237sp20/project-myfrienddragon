package SpaceInvaders;

<<<<<<< Updated upstream
public class Fleet {
	private Invader[] invaders;
	private final static int startingSize = 8; 
	
=======
import java.util.ArrayList;
import java.util.Iterator;

//class to hold space invaders and their bullets
public class Fleet {
	public ArrayList<Invader> invaders;
	public ArrayList<SpaceInvaderBullet> bullets;
	private final static int startingSize = 9; 

>>>>>>> Stashed changes
	public Fleet() {
		invaders = new Invader[startingSize];
		positionInvaders();
	}
	
<<<<<<< Updated upstream
	private void positionInvaders() {
		for(int i = 0; i < startingSize; i++) {
			invaders[i] = new Invader(25 + (i * 40), 0);
		}
	}
	
	public void removeDeadInvaders() {
		for(int i = 0; i < startingSize; i++) {
			Invader invader = getInvader(i);
			if(invader.isDead()) {
				invaders[i] = null;
			}
=======
	//spawns a new row of 9 invaders
	public void spawnInvaders() {
		for (int i = 0; i < startingSize; ++i) {
			Invader toAdd = new Invader(20 + (i * 50), 350);
			this.invaders.add(toAdd);
		}
	}
	
	//randomly selects a space invader to shoot a bullet, and then shoots bullet
	public void shootBullets() {
		int chosenShooterIndex = (int)(Math.random()*this.invaders.size());
		Invader chosenShooter = this.invaders.get(chosenShooterIndex);
		SpaceInvaderBullet bullet = new SpaceInvaderBullet(chosenShooter.getX(), chosenShooter.getY());
		bullets.add(bullet);
	}

	//moves invaders to make room for back row of invaders, then adds a new row of invaders
	public void addRowOfInvaders() {
		Iterator<Invader> it = this.invaders.iterator();
		while (it.hasNext()) {
			Invader element = it.next();
			element.move();
>>>>>>> Stashed changes
		}
	}
	
	public Invader getInvader(int index) {
		return invaders[index];
	}
<<<<<<< Updated upstream
}
=======

	
	//updates fleet of invaders by checking for collision. if invaders have been destroyed, remove them from array,
	//preventing them from rendering or further updates
	public void updateInvaders(DragonBulletCollection dragonBullets) {
		Iterator<Invader> it = invaders.iterator(); 
		while (it.hasNext()) {
			Invader element = it.next();
			element.checkCollision(dragonBullets);
			if(!element.getOnScreen()) {
				it.remove();
			}
		}
	}
	
	//updates invader bullets. if they are off screen, removes them from array, preventing them from 
	//rendering or further updates
	public void updateInvaderBullets() {
		Iterator<SpaceInvaderBullet> it2 = bullets.iterator();
		while (it2.hasNext()) {
			SpaceInvaderBullet bullet = it2.next();
				bullet.update();
				if (!bullet.getOnScreen()) {
					it2.remove();
				}
			}
		}
	
	//aggregate update function
	public void update(DragonBulletCollection dragonBullets) {
	this.updateInvaders(dragonBullets);
	this.updateInvaderBullets();
	}
}

>>>>>>> Stashed changes
