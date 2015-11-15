package sevenWonders.core.gameElements;

import java.util.Map;

import sevenWonders.core.gameElements.effects.IsAnEffect;

public class WonderStage {
	private final Map<Resource, Integer> cost;
	private final IsAnEffect[] effects;

	public WonderStage(Map<Resource, Integer> cost, IsAnEffect... effects) {
		this.cost = cost;
		this.effects = effects;

	}

	public Map<Resource, Integer> getCost() {
		return cost;
	}

	public IsAnEffect[] getEffects() {
		return effects;
	}
}
