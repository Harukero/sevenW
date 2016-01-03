package sevenWonders.core.gameElements.effects;

public enum GiveScientificElement implements IsAnEffect {
	COMPAS,
	COG,
	TABLET;
	
	@Override
	public String asString() {
		return this.name();
	}
}
