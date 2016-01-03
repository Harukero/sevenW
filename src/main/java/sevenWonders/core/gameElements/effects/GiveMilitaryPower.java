package sevenWonders.core.gameElements.effects;

public enum GiveMilitaryPower implements IsAnEffect {
	PLUS_ONE_MILITARY_POWER(1),
	PLUS_TWO_MILITARY_POWER(2),
	PLUS_THREE_MILITARY_POWER(3);
	
	private int militaryPowerGiven;

	private GiveMilitaryPower(int militaryPowerGiven) {
		this.militaryPowerGiven = militaryPowerGiven;
	}
	
	public int getMilitaryPowerGiven() {
		return militaryPowerGiven;
	}

}
