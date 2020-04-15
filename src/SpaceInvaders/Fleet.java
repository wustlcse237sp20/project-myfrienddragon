package SpaceInvaders;

public class Fleet {
	private Invader[] invaders;
	private final static int startingSize = 8; 
	
	public Fleet() {
		invaders = new Invader[startingSize];
		positionInvaders();
	}
	
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
		}
	}
	
	public Invader getInvader(int index) {
		return invaders[index];
	}
}
