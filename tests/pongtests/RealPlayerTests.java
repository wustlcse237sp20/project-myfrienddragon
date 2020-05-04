package pongtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ponggame.Ball;
import ponggame.Collisions;
import ponggame.RealPlayer;

public class RealPlayerTests {
	private Ball ball;
	private RealPlayer player;
	
	@BeforeEach
	void setUpTestingObjects() {
		ball = new Ball();
		player = new RealPlayer(50, 200, 1);
	}
	
	@Test
	void testMiddleCollisionFromUpwardDirection() {
		ball.setxPos(50);
		ball.setyPos(80);
		ball.setxDir(-1);
		
		player.setyPos(80);
		assertEquals(ball.PlayerOnePaddleCollision(player), Collisions.PLAYER_ONE_PADDLE);
	}
	
	@Test
	void testMiddleCollisionFromDownwardDirection() {
		ball.setxPos(50);
		ball.setyPos(80);
		ball.setxDir(-1);
		ball.setyDir(-1);
		player.setyPos(80);
		assertEquals(ball.PlayerOnePaddleCollision(player), Collisions.PLAYER_ONE_PADDLE);
	}
	
	@Test
	void testTopCollision() {
		ball.setxPos(50);
		ball.setyPos(105);
		ball.setxDir(-1);
		ball.setyDir(-1);
		player.setyPos(80);
		assertEquals(ball.PlayerOnePaddleCollision(player), Collisions.PLAYER_ONE_PADDLE);
	}
	
	@Test
	void testBottom() {
		ball.setxPos(50);
		ball.setyPos(55);
		ball.setxDir(-1);
		
		player.setyPos(80);
		assertEquals(ball.PlayerOnePaddleCollision(player), Collisions.PLAYER_ONE_PADDLE);
	}
	
}
