package sevenWonders.core.gameElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

import sevenWonders.client.constants.IConstants;

/**
 * @author Harukero
 *
 */
public class Card {

	private final String name;
	private final Map<Resource, Integer> cost;
	private final Age age;
	private final Effect[] effects;
	private final String imageURL;

	public Card(String name, Age age, Map<Resource, Integer> cost, String imageURL, Effect... effects) {
		this.name = name;
		this.age = age;
		this.cost = cost;
		this.imageURL = imageURL;
		this.effects = effects;
	}

	/*
	 * "cardName": "Stone Pit", "cost": {}, "image": "images/age1-stonePit.png",
	 * "age": [ 1 ]
	 */
	public static List<Card> fromJSON(JSONObject cardJson) {
		List<Card> cards = new ArrayList<>();
		JSONString nameValue = cardJson.get(IConstants.JSON_CARD_NAME_ENTRY).isString();
		String name = nameValue.stringValue();

		JSONString imageUrlValue = cardJson.get(IConstants.JSON_IMAGE_URL_ENTRY).isString();
		String imageUrl = imageUrlValue.stringValue();

		JSONArray ageArray = cardJson.get(IConstants.JSON_AGE_ENTRY).isArray();
		int size = ageArray.size();
		for (int position = 0; position < size; position++) {
			JSONNumber age = ageArray.get(position).isNumber();
			cards.add(new Card(name, Age.getAgeFromNumber(age.doubleValue()), null, imageUrl));
		}
		return cards;
	}

	public String getName() {
		return name;
	}

	public Age getAge() {
		return age;
	}

	public Map<Resource, Integer> getCost() {
		return cost;
	}

	public Effect[] getEffects() {
		return effects;
	}

	public String getImageURL() {
		return imageURL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + Arrays.hashCode(effects);
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + ", cost=" + cost + ", age=" + age + ", effects=" + Arrays.toString(effects)
				+ ", imageURL=" + imageURL + "]";
	}

	
	
}
