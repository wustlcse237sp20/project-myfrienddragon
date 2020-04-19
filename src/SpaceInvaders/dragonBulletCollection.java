package SpaceInvaders;
import java.util.ArrayList;
import java.util.Iterator;


public class dragonBulletCollection {
	
		ArrayList<DragonBullet> bullets;
		
		
		public dragonBulletCollection() {
			this.bullets = new ArrayList<DragonBullet>();
		}
		
		public ArrayList<DragonBullet> getBullets() {
			return bullets;
		}
		public void setBullets(ArrayList<DragonBullet> bullets) {
			this.bullets = bullets;
		}
		
		public void addBullet(DragonBullet dragonBullet) {
			this.bullets.add(dragonBullet);
		}
		public void removeBullet(DragonBullet dragonBullet) {
			this.bullets.remove(dragonBullet);
		}
		
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

