package bowling.day2;

public class Game {

	private int currentRoll = 0;

	private int[] rolls = new int[21];

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		int frameIndex = 0;
		for(int frame = 0; frame < 10; frame++) {
			if(rolls[frameIndex] == 10) {
				score += 10 + strikeBonus(frameIndex) ;
				frameIndex += 1;
			} else if(isSpare(frameIndex)) {
				score += 10 + spareBonus(frameIndex);
				frameIndex += 2;
			} else  {
				score += sumOfBallInFrame(frameIndex);
				frameIndex += 2;
			}
		}
		return score ;
	}


	private int strikeBonus(int frameIndex) {
		return rolls[frameIndex+1]+ rolls[frameIndex+2];
	}

	private int spareBonus(int frameIndex) {
		return rolls[frameIndex+2];
	}

	private boolean isSpare(int frameIndex) {
		return sumOfBallInFrame(frameIndex) == 10;
	}

	private int sumOfBallInFrame(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex+1];
	}

}
