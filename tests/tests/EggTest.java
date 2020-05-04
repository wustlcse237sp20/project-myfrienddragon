package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdDraw;
import game.Baby;
import game.Dragon;
import game.Egg;
import game.FoodInventory;

class EggTest {

	@Test
	void creationTest() {
		FoodInventory foodInventory = new FoodInventory();
		Egg egg = new Egg(foodInventory);
		if (egg != null) {
			assertTrue(true,"Egg created");
		}
	}
	@Test
	void creationVariablesTest() {
		FoodInventory foodInventory = new FoodInventory();
		Egg egg = new Egg(foodInventory);
		assertEquals(egg.foodLevel, 0);
		assertEquals(egg.loveLevel, 0);
	}
	
	@Test
	void addOneFoodTest() {
		FoodInventory foodInventory = new FoodInventory();
		Egg egg = new Egg(foodInventory);
		egg.feed();
		assertEquals(egg.foodLevel, 20);
	}
	
	@Test
	void addFiveFoodTest() {
		FoodInventory foodInventory = new FoodInventory();
		Egg egg = new Egg(foodInventory);
		for (int i = 0; i < 5; ++i) {
		egg.feed();
		}
		assertEquals(egg.foodLevel, 100);
	}
	
	@Test
	void addSixFoodTest() {
		FoodInventory foodInventory = new FoodInventory();
		Egg egg = new Egg(foodInventory);
		for (int i = 0; i < 6; ++i) {
		egg.feed();
		}
		assertEquals(egg.foodLevel, 100);
	}
	
	@Test
	void addOneLoveTest() {
		FoodInventory foodInventory = new FoodInventory();
		Egg egg = new Egg(foodInventory);
		egg.pet();
		assertEquals(egg.loveLevel, 20);
	}
	
	@Test
	void addFiveLoveTest() {
		FoodInventory foodInventory = new FoodInventory();
		Egg egg = new Egg(foodInventory);
		for (int i = 0; i < 5; ++i) {
		egg.pet();
		}
		assertEquals(egg.loveLevel, 100);
	}
	@Test
	void addSixLoveTest() {
		FoodInventory foodInventory = new FoodInventory();
		Egg egg = new Egg(foodInventory);
		for (int i = 0; i < 6; ++i) {
		egg.pet();
		}
		assertEquals(egg.loveLevel, 100);
	}
	
	@Test
	void ageUpTest() {
		FoodInventory foodInventory = new FoodInventory();
		Egg egg = new Egg(foodInventory);
		for (int i = 0; i < 6; ++i) {
			egg.pet();
			egg.feed();
		}
		Dragon output = egg.ageUp();
		Dragon tester = new Baby(foodInventory);
		assertTrue(output.equals(tester));
		
	}
	

	

}
