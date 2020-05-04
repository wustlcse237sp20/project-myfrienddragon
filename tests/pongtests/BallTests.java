package pongtests;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ponggame.Ball;
import ponggame.Collisions;
import ponggame.RealPlayer;

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
		RealPlayer player1 = new RealPlayer(200,200,1);
		RealPlayer player2 = new RealPlayer(200,200,1);
		ball.setyPos(ball.getMinYLimit());
		assertEquals(ball.checkCollisions(player1, player2), Collisions.BOTTOM_WALL);
	}
	
	@Test
	void testReboundBallOfMaxY() {
		RealPlayer player1 = new RealPlayer(200,200,1);
		RealPlayer player2 = new RealPlayer(200,200,1);
		ball.setyPos(ball.getMaxYLimit());
		assertEquals(ball.checkCollisions(player1, player2), Collisions.TOP_WALL);
	}
	
	@Test
	void testReboundBallOfMinX() {
		RealPlayer player1 = new RealPlayer(200,200,1);
		RealPlayer player2 = new RealPlayer(200,200,1);
		ball.setxPos(ball.getMinXLimit());
		assertEquals(ball.checkCollisions(player1, player2), Collisions.LEFT_WALL);
	}
	
	@Test
	void testReboundBallOfMaxX() {
		RealPlayer player1 = new RealPlayer(200,200,1);
		RealPlayer player2 = new RealPlayer(200,200,1);
		ball.setxPos(ball.getMaxXLimit());
		assertEquals(ball.checkCollisions(player1, player2), Collisions.RIGHT_WALL);
	}
}
