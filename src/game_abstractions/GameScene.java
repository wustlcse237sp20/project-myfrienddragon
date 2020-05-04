package game_abstractions;

public abstract class GameScene {
	GameManager manager;
	protected GameScene parent;
	public GameScene(GameManager manager, GameScene parent) {
		this.manager = manager;
		this.parent = parent;
	}
	public void update() {
	
		
	}
	public GameScene getParent() {
		return this.parent;
	}
	public GameManager getGameManager() {
		return manager;
		
	}
	

}
