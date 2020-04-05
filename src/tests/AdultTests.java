package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Adult;
import game.Baby;
import game.Dragon;

class AdultTests {

	@Test
	void creationTest() {
		Adult adult = new Adult();
		if (adult != null) {
			assertTrue(true,"Baby created");
		}
	}
	@Test
	void creationVariablesTest() {
		Adult adult = new Adult();
		assertEquals(adult.foodLevel, 0);
		assertEquals(adult.loveLevel, 0);
	}
	
	@Test
	void addOneFoodTest() {
		Adult adult = new Adult();
		adult.feed();
		assertEquals(adult.foodLevel, 1);
	}
	
	@Test
	void addFiveFoodTest() {
		Adult adult = new Adult();
		for (int i = 0; i < 5; ++i) {
		adult.feed();
		}
		assertEquals(adult.foodLevel, 5);
	}
	
	@Test
	void addSixFoodTest() {
		Adult adult = new Adult();
		for (int i = 0; i < 6; ++i) {
		adult.feed();
		}
		assertEquals(adult.foodLevel, 5);
	}
	
	@Test
	void addOneLoveTest() {
		Adult adult = new Adult();
		adult.pet();
		assertEquals(adult.loveLevel, 1);
	}
	
	@Test
	void addFiveLoveTest() {
		Adult adult = new Adult();
		for (int i = 0; i < 5; ++i) {
		adult.pet();
		}
		assertEquals(adult.loveLevel, 5);
	}
	@Test
	void addSixLoveTest() {
		Adult adult = new Adult();
		for (int i = 0; i < 6; ++i) {
		adult.pet();
		}
		assertEquals(adult.loveLevel, 5);
	}
	
	@Test
	void ageUpTest() {
		Adult adult = new Adult();
		for (int i = 0; i < 6; ++i) {
			adult.pet();
			adult.feed();
		}
		Dragon output = adult.ageUp();
		Dragon tester = new Adult();
		assertEquals(output, tester);
		
	}

}
