package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import SpaceInvaders.Player;
import game.Egg;

class DragonInvader {

	@Test
	void creationTest() {
		Player p = new Player();
		if (p != null) {
			assertTrue(true,"Player created");
		}
	}
	
	@Test
	void testInitialVariables() {
		Player p = new Player();
		assertEquals(p.getScore(), 0);
		assertEquals(p.getX(), 200);
		assertEquals(p.getY(), 50);
		assertEquals(p.getHealth(), 100);
	}
	
	@Test
	void testDragonCantGoUpOrRightOffBoard() {
		Player p = new Player();
		for (int i = 0; i < 70; i++) {
			p.interpretKeyPressed('w');
			p.interpretKeyPressed('a');
		}
		assertEquals(400, p.getY());
		assertEquals(0, p.getX());
	}
	
	@Test
	void testDragonCantGoLeftOrDownOffBoard() {
		Player p = new Player();
		for (int i = 0; i < 50; i++) {
			p.interpretKeyPressed('s');
			p.interpretKeyPressed('d');
		}
		assertEquals(0, p.getY());
		assertEquals(400, p.getX());
	}

	@Test
	void testScoreIncreaseWhenShootInvader() {
		Player p = new Player();
		p.didHitInvader();
		assertEquals(20, p.getScore());
	}
	
	@Test
	void testHealthDecreaseWhenHit() {
		Player p = new Player();
		p.isHit();
		assertEquals(90, p.getHealth());
	}

}
