package sevenWonders.core.gameElements;

import java.util.Arrays;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

import sevenWonders.core.gameElements.effects.IsAnEffect;

public class WonderStage implements IsSerializable {
	private Map<Resource, Integer> cost;
	private IsAnEffect[] effects;

	@SuppressWarnings("unused")
	private WonderStage() {
	}
	
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

	public void setCost(Map<Resource, Integer> cost) {
		this.cost = cost;
	}

	public void setEffects(IsAnEffect[] effects) {
		this.effects = effects;
	}

	@Override
	public String toString() {
		return "WonderStage [cost=" + cost + ", effects=" + Arrays.toString(effects) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + Arrays.hashCode(effects);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WonderStage other = (WonderStage) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (!Arrays.equals(effects, other.effects))
			return false;
		return true;
	}
	
}
