package SpaceInvaders;


import java.util.ArrayList;

public class Fleet {
	private ArrayList<Invader> invaders;
	private final static int startingSize = 8; 
	
	public Fleet() {
		invaders = new ArrayList<Invader>();
		positionInvaders();
	}
	
	private void positionInvaders() {
		for(int i = 0; i < startingSize; i++) {
			Invader invader = new Invader(25 + (i * 50), 20.5);
			invaders.add(invader);
		}
	}
	
	public void removeDeadInvaders() {
		for(int i = 0; i < invaders.size(); i++) {
			Invader invader = invaders.get(i);
			if(invader.isDead()) {
				invaders.remove(i);
				i--;
			}
		}
	}
	
	public void moveInvaders() {
		for(int i = 0; i < invaders.size(); i++) {
			Invader invader = invaders.get(i);
			invader.move();
		}
	}
	
	public ArrayList<Invader> getInvaders() {
		return invaders;
	}

}
