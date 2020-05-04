package pongtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ponggame.Ball;
import ponggame.Collisions;
import ponggame.ProjectPlayer;
import ponggame.RealPlayer;

public class ProjectPlayerTests {
	private Ball ball;
	private ProjectPlayer player;
	
	@BeforeEach
	void setUpTestingObjects() {
		ball = new Ball();
		player = new ProjectPlayer();
	}
	
	@Test
	void testMiddleCollisionFromUpwardDirection() {
		ball.setxPos(350);
		ball.setyPos(80);
		ball.setxDir(1);
		
		player.setyPos(80);
		assertEquals(ball.PlayerTwoPaddleCollision(player), Collisions.PLAYER_TWO_PADDLE);
	}
	
	@Test
	void testMiddleCollisionFromDownwardDirection() {
		ball.setxPos(350);
		ball.setyPos(80);
		ball.setxDir(1);
		ball.setyDir(-1);
		player.setyPos(80);
		assertEquals(ball.PlayerTwoPaddleCollision(player), Collisions.PLAYER_TWO_PADDLE);
	}
	
	@Test
	void testTopCollision() {
		ball.setxPos(350);
		ball.setyPos(105);
		ball.setxDir(1);
		ball.setyDir(-1);
		player.setyPos(80);
		assertEquals(ball.PlayerTwoPaddleCollision(player), Collisions.PLAYER_TWO_PADDLE);
	}
	
	@Test
	void testBottom() {
		ball.setxPos(350);
		ball.setyPos(55);
		ball.setxDir(1);
		
		player.setyPos(80);
		assertEquals(ball.PlayerTwoPaddleCollision(player), Collisions.PLAYER_TWO_PADDLE);
	}
}
