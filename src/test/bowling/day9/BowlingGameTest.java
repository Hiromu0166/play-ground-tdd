package bowling.day9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BowlingGameTest {

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
	void testGutterGame() {
		rollMany(20, 0);
		assertEquals(0, g.score());
	}

	@Test
	void testAllOneGame() {
		rollMany(20, 1);
		assertEquals(20, g.score());
	}

	@Test
	void testOneSpare() {
		rollSpare();
		g.roll(3);
		rollMany(17, 0);
		assertEquals(16, g.score());
	}

	@Test
	void testOneStrike() {
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		assertEquals(24, g.score());
	}

	@Test
	void testPerfectGame() {
		rollMany(12, 10);
		assertEquals(300, g.score());
	}

}
