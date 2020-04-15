package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import SpaceInvaders.Invader;

class InvaderTests {
	private Invader invader; 
	
	@BeforeEach 
	void setUpTestingObjects() {
		invader = new Invader(200, 200);
	}
	
	@Test
	void testInitialization() {
		assertEquals(invader.getX(), 200);
		assertEquals(invader.getY(), 200);
	}

	@Test
	void testDamage() {
		int initHealth = invader.getHealth();
		invader.hurt();
		
		assertEquals(invader.getHealth(), initHealth - 1);
	}
	
	
	
	@Test
	void testDamageEqualToHealth() {
		invader.hurt();
		invader.hurt();
		
		assertEquals(invader.getHealth(), 0);
	}
	
	@Test 
	void testDamageGreaterThanHealth() {
		invader.hurt();
		invader.hurt();
		invader.hurt();
		
		assertEquals(invader.getHealth(), 0);
	}
}
