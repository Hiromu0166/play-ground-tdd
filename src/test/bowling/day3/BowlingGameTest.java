package bowling.day3;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

	private Game g;

	@BeforeEach
	private void setUp() {
		g = new Game();
	}
	private void rollMany(int n, int pins) {
		for(int i = 0; i < n; i++) {
			g.roll(pins);
		}
	}

	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}

	private void rollStrike() {
		g.roll(10);
	}

	@Test
	public void gutterGame() {
		rollMany(20, 0);
		assertEquals(0, g.score());
	}

	@Test
	public void allOneGame() {
		int n = 20;
		int pins = 1;
		rollMany(n, pins);
		assertEquals(n, g.score());
	}

	@Test
	public void oneSpareGame() {
		rollSpare();
		g.roll(3);
		rollMany(16, 0);
		assertEquals(16, g.score());
	}

	@Test
	public void oneStrikeGame() {
		rollStrike();
		g.roll(4);
		g.roll(3);
		rollMany(16, 0);
		assertEquals(24, g.score());
	}

	@Test
	public void perfectGame() {
		rollMany(12, 10);
		assertEquals(300, g.score());
	}

}
