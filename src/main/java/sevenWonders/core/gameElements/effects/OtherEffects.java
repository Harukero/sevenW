package sevenWonders.core.gameElements.effects;

public enum OtherEffects implements IsAnEffect {
	ONE_PER_WONDERS_LEVEL_FROM_CURRENT_PLAYER_AND_NEIGHBOR,
	ONE_PER_NEIGHBOR_DEFEAT;
	
	@Override
	public String asString() {
		return name();
	}
}
