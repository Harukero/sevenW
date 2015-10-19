package sevenWonders.client.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;

import sevenWonders.client.constants.IConstants;
import sevenWonders.client.rpc.CardGetterService;
import sevenWonders.client.rpc.CardGetterServiceAsync;
import sevenWonders.core.gameElements.Age;
import sevenWonders.core.gameElements.Card;

public class GameService {

	public static final GameService INSTANCE = new GameService();
	private static Logger logger = Logger.getLogger(GameService.class.getName());
	private Map<String, List<Card>> cards;
	private final CardGetterServiceAsync getCardsService = GWT.create(CardGetterService.class);

	private GameService() {
		cards = new HashMap<>();
	}

	public void initCardsList() {
		getCardsService.getCards(new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				logger.log(Level.SEVERE, caught.getMessage());
			}

			@Override
			public void onSuccess(String result) {
				JSONObject a = (JSONObject) JSONParser.parseStrict(result);
				Set<String> entries = a.keySet();
				for (String key : entries) {
					cards.put(key, getCards(key, a));
				}
			}

			private List<Card> getCards(String key, JSONObject a) {
				List<Card> cardsList = new ArrayList<>();
				JSONArray cardsListJson = (JSONArray) a.get(key);
				int size = cardsListJson.size();
				for (int position = 0; position < size; position++) {
					JSONObject cardJson = (JSONObject) cardsListJson.get(position);
					cardsList.addAll(fromJSON(cardJson));
				}
				logger.fine("Added " + cardsList.size() + " cards from key " + key);
				return cardsList;
			}

		});
	}

	public Map<String, List<Card>> getCards() {
		return cards;
	}

	public List<Card> getCardsCategory(String category) {
		return cards.get(category);
	}

	public List<Card> getCardsFromAge(Age age) {
		logger.log(Level.INFO, "trying to getCards of " + age);
		List<Card> ageCards = new ArrayList<>();
		for (List<Card> cardList : cards.values()) {
			for (Card card : cardList) {
				if (card.getAge() == age) {
					ageCards.add(card);
				}
			}
		}
		return ageCards;
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
}
