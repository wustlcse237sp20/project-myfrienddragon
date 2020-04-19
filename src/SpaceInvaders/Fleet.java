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
			Invader invader = new Invader(42.5 + (i * 44.5), 0);
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
	
	public ArrayList<Invader> getInvaders() {
		return invaders;
	}
	

}
