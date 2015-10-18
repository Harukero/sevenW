package sevenWonders.core.gameElements;

import java.util.Map;

public class WonderStage {
	private final Map<Resource, Integer> cost;
	private final Effect[] effects;

	public WonderStage(Map<Resource, Integer> cost, Effect... effects) {
		this.cost = cost;
		this.effects = effects;

	}

	public Map<Resource, Integer> getCost() {
		return cost;
	}

	public Effect[] getEffects() {
		return effects;
	}
}
