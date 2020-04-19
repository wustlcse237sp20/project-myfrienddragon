package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SpaceInvaders.Fleet;
import SpaceInvaders.Invader;

class DestroyInvaderTests {
	private Fleet fleet;
	private ArrayList<Invader> invaders;
	
	@BeforeEach
	void setUpTestingObjects() {
		fleet = new Fleet();
		invaders = fleet.getInvaders();
	}
	
	@Test
	void testFirstInvaderDestroyed() {
		Invader invader = invaders.get(0);
		hurtInvaderTwice(invader);
		
		fleet.removeDeadInvaders();
		
		assertFalse(invaders.contains(invader));
	}	
	
	private void hurtInvaderTwice(Invader invader) {
		invader.hurt();
		invader.hurt();
	}
	
	@Test
	void testLastInvaderDestroyed() {
		Invader invader = invaders.get(7);
		hurtInvaderTwice(invader);
		
		fleet.removeDeadInvaders();
		
		assertFalse(invaders.contains(invader));
	}	
	
	@Test
	void testMiddleInvaderDestroyed() {
		Invader invader = invaders.get(4);
		hurtInvaderTwice(invader);
		
		fleet.removeDeadInvaders();
		
		assertFalse(invaders.contains(invader));
	}	
	
	@Test
	void testSucessiveInvadersDestroyed() {
		Invader invader = invaders.get(4);
		Invader invader2 = invaders.get(5);
		hurtInvaderTwice(invader);
		hurtInvaderTwice(invader2);
		
		fleet.removeDeadInvaders();
		
		assertFalse(invaders.contains(invader));
	}	
	
	@Test
	void testFirstAndLastInvaderDestroyed() {
		Invader invader = invaders.get(0);
		Invader invader2 = invaders.get(7);
		hurtInvaderTwice(invader);
		hurtInvaderTwice(invader2);
		
		fleet.removeDeadInvaders();
		
		assertFalse(invaders.contains(invader));
	}	
	
	@Test
	void testInvaderNotDestroyed() {
		Invader invader = invaders.get(0);
		invader.hurt();
		
		fleet.removeDeadInvaders();
		
		assertTrue(invaders.contains(invader));
	}

	
}
