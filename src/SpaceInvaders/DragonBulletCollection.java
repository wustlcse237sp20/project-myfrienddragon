package SpaceInvaders;
import java.util.ArrayList;
import java.util.Iterator;

//class to hold multiple on screen dragon bullets
public class DragonBulletCollection {

	ArrayList<DragonBullet> bullets;

	public DragonBulletCollection() {
		this.bullets = new ArrayList<DragonBullet>();
	}

	public ArrayList<DragonBullet> getBullets() {
		return bullets;
	}

	public void addBullet(DragonBullet dragonBullet) {
		this.bullets.add(dragonBullet);
	}
	public void removeBullet(DragonBullet dragonBullet) {
		this.bullets.remove(dragonBullet);
	}

	//removes dragon bullets from array based on whether or not they are on screen
	public void update() {
		Iterator<DragonBullet> it = this.getBullets().iterator(); 
		while (it.hasNext()) {
			DragonBullet element = it.next();
			element.update();
			if (!element.getOnScreen()) {
				it.remove();
			}
		}
	}

}

