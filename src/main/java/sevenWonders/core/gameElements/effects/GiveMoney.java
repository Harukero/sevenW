package sevenWonders.core.gameElements.effects;

public enum GiveMoney implements IsAnEffect {
	THREE_COINS(3),
	FOUR_COINS(4),
	NINE_COINS(9), FIVE_COINS(5);
	
	private int givenCoins;

	private GiveMoney(int givenCoins) {
		this.givenCoins = givenCoins;
	}
	
	public int getGivenCoins() {
		return givenCoins;
	}
	
	@Override
	public String asString() {
		return "+" + givenCoins + " coins";
	}
}
