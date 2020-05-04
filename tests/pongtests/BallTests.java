package pongtests;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ponggame.Ball;
import ponggame.Collisions;

public class BallTests {
	private Ball ball;

	@BeforeEach
	void setUpTestingObjects() {
		ball = new Ball();
	}
	@Test
	void testMovement() {
		double initX = ball.getxPos();
		double initY = ball.getyPos();
		
		ball.move();
		double currentX = ball.getxPos();
		double currentY = ball.getyPos();
		
		assertEquals(currentX, initX + ball.getSpeed() * ball.getxDir());
		assertEquals(currentY, initY + ball.getSpeed() * ball.getyDir());
	}

	@Test
	void testReboundBallOfMinY() {
		ball.setyPos(ball.getMinYLimit());
		assertEquals(ball.checkWallCollison(), Collisions.BOTTOM_WALL);
	}
	
	@Test
	void testReboundBallOfMaxY() {
		ball.setyPos(ball.getMaxYLimit());
		assertEquals(ball.checkWallCollison(), Collisions.TOP_WALL);
	}
	
	@Test
	void testReboundBallOfMinX() {
		ball.setxPos(ball.getMinXLimit());
		assertEquals(ball.checkWallCollison(), Collisions.LEFT_WALL);
	}
	
	@Test
	void testReboundBallOfMaxX() {
		ball.setxPos(ball.getMaxXLimit());
		assertEquals(ball.checkWallCollison(), Collisions.RIGHT_WALL);
	}
}
