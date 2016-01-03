package sevenWonders.core.gameElements.effects;

public enum GivePoints implements IsAnEffect {
	ONE_POINT(1),
	TWO_POINTS(2),
	THREE_POINTS(3),
	FOUR_POINTS(4),
	FIVE_POINTS(5),
	SIX_POINTS(6),
	SEVEN_POINTS(7),
	EIGHT_POINTS(8);
	
	private int givenPoints;

	private GivePoints(int givenPoints) {
		this.givenPoints = givenPoints;
	}
	
	public int getGivenPoints() {
		return givenPoints;
	}

}
