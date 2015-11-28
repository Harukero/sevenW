package sevenWonders.core.gameElements;

import java.util.Arrays;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

import sevenWonders.core.gameElements.effects.IsAnEffect;

/**
 * @author Harukero
 *
 */
public class Card implements IsSerializable {

	
	private Map<Resource, Integer> cost;
	private Age age;
	private IsAnEffect[] effects;
	private CardType type;
	private Map<String, String> nameByLanguage;

	@SuppressWarnings("unused")
	private Card() {
	}
	
	public Card(Map<String, String> nameByLanguage, 
			Age age, 
			Map<Resource, Integer> cost, 
			CardType type, 
			IsAnEffect... effects) {
		this.nameByLanguage = nameByLanguage;
		this.age = age;
		this.cost = cost;
		this.effects = effects;
		this.type = type;
	}

	public String getName(String locale) {
		if (nameByLanguage.containsKey(locale)){
			return nameByLanguage.get(locale);
		}
		return nameByLanguage.get(IGameConstants.LOCALE_EN);
	}

	public Age getAge() {
		return age;
	}

	public Map<Resource, Integer> getCost() {
		return cost;
	}

	public IsAnEffect[] getEffects() {
		return effects;
	}

	public CardType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "Card [cost=" + cost + ", age=" + age + ", effects=" + Arrays.toString(effects) + ", type=" + type
				+ ", nameByLanguage=" + nameByLanguage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + Arrays.hashCode(effects);
		result = prime * result + ((nameByLanguage == null) ? 0 : nameByLanguage.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Card other = (Card) obj;
		if (age != other.age)
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (!Arrays.equals(effects, other.effects))
			return false;
		if (nameByLanguage == null) {
			if (other.nameByLanguage != null)
				return false;
		} else if (!nameByLanguage.equals(other.nameByLanguage))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}
