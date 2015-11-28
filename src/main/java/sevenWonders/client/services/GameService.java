package sevenWonders.client.services;

import java.util.ArrayList;
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
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;

import sevenWonders.client.constants.IConstants;
import sevenWonders.client.rpc.CardGetterService;
import sevenWonders.client.rpc.CardGetterServiceAsync;
import sevenWonders.core.gameElements.Age;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.CardType;
import sevenWonders.core.gameElements.IGameConstants;
import sevenWonders.core.gameElements.Resource;
import sevenWonders.core.utils.GameUtils;

public class GameService {

	public static final GameService INSTANCE = new GameService();
	private static Logger logger = Logger.getLogger(GameService.class.getName());
	private Map<String, List<Card>> cards;
	private final CardGetterServiceAsync getCardsService = GWT.create(CardGetterService.class);
	private final String uiLanguage;

	private final Map<Integer, Map<Age, List<Card>>> cardsByAgeForNumberOfPlayers;

	private GameService() {
		cards = new HashMap<>();
		cardsByAgeForNumberOfPlayers = new HashMap<>();
		for (int i = 3; i <= 7; i++) {
			cardsByAgeForNumberOfPlayers.put(Integer.valueOf(i), new HashMap<Age, List<Card>>());
		}
		if (Location.getParameterMap().isEmpty() || !Location.getParameterMap().containsKey(IGameConstants.PARAM_LOCALE)) {
			uiLanguage = IGameConstants.LOCALE_EN;
		} else {
			uiLanguage = Location.getParameter(IGameConstants.PARAM_LOCALE);
		}
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

			private List<Card> getCards(String category, JSONObject jsonCards) {
				List<Card> cardsList = new ArrayList<>();
				JSONArray cardsListJson = (JSONArray) jsonCards.get(category);
				int size = cardsListJson.size();
				for (int position = 0; position < size; position++) {
					JSONObject cardJson = (JSONObject) cardsListJson.get(position);
					cardsList.addAll(fromJSON(cardJson, cardsByAgeForNumberOfPlayers, category));
				}
				return cardsList;
			}

		});
	}

	public Map<String, List<Card>> getCards() {
		return cards;
	}

	public List<Card> getCardsForCategory(String category) {
		return cards.get(category);
	}

	public List<Card> getCardsFromAge(Age age) {
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
	
	public List<Card> getCardsForSpecificNbOfPlayersAndAge(Integer nbPlayer, Age age) {
		List<Card> cardsNeeded = new ArrayList<>();
		for (Integer possiblePlayers : cardsByAgeForNumberOfPlayers.keySet()) {
			if (possiblePlayers <= nbPlayer) {
				cardsNeeded.addAll(cardsByAgeForNumberOfPlayers.get(possiblePlayers).get(age));
			}
		}
		if (age == Age.THIRD) {
			cardsNeeded.addAll(getGuildCardsFor(nbPlayer));
		}
		GameUtils.shuffle(cardsNeeded);
		return cardsNeeded;
	}

	private List<Card> getGuildCardsFor(Integer nbPlayer) {
		List<Card> guildCards = cards.get(IConstants.JSON_CATEGORY_GUILDS);
		GameUtils.shuffle(guildCards);
		return guildCards.subList(0, nbPlayer+2);
	}

	public String getUiLanguage() {
		return uiLanguage;
	}

	private static List<Card> fromJSON(JSONObject cardJson,
			Map<Integer, Map<Age, List<Card>>> cardsByAgeForNumberOfPlayers, String category) {
		List<Card> cards = new ArrayList<>();
		Map<String, String> names = getCardNames(cardJson);

		JSONNumber ageJson = cardJson.get(IConstants.JSON_ENTRY_AGE).isNumber();
		
		Age age = Age.getAgeFromNumber(ageJson.doubleValue());
		JSONObject resourcesObject = cardJson.get(IConstants.JSON_ENTRY_COST).isObject();
		Map<Resource, Integer> cardCost = getCost(resourcesObject);
		Card card = new Card(names, age, cardCost, CardType.fromCategory(category));
		cards.add(card);
		JSONArray byPlayers = cardJson.get(IConstants.JSON_ENTRY_FOR_PLAYERS).isArray();
		int nbCards = byPlayers.size();
		for (int i = 0; i < nbCards; i++) {
			Integer byPlayer = Double.valueOf(byPlayers.get(i).isNumber().doubleValue()).intValue();
			Map<Age, List<Card>> cardsByAge = cardsByAgeForNumberOfPlayers.get(byPlayer);
			if (!cardsByAge.containsKey(age)) {
				cardsByAge.put(age, new ArrayList<Card>());
			}
			cardsByAge.get(age).add(card);
		}

		return cards;
	}

	private static Map<String, String> getCardNames(JSONObject cardJson) {
		JSONObject jsonNames = cardJson.get(IConstants.JSON_ENTRY_CARD_NAME).isObject();
		Map<String, String> localeToName = new HashMap<>();
		putNameForLocale(jsonNames, localeToName, IGameConstants.LOCALE_EN);
		putNameForLocale(jsonNames, localeToName, IGameConstants.LOCALE_FR);
		return localeToName;
	}

	private static void putNameForLocale(JSONObject jsonNames, Map<String, String> localeToName, String locale) {
		if (jsonNames.containsKey(locale)) {
			localeToName.put(locale, jsonNames.get(locale).isString().stringValue());
		}
	}

	private static Map<Resource, Integer> getCost(JSONObject resourcesObject) {
		Map<Resource, Integer> cost = new HashMap<>();
		addCostForOrZero(IConstants.JSON_RESOURCE_CLAY_BRICK, Resource.CLAY_BRICK, resourcesObject, cost);
		addCostForOrZero(IConstants.JSON_RESOURCE_GLASS, Resource.GLASS, resourcesObject, cost);
		addCostForOrZero(IConstants.JSON_RESOURCE_MONEY, Resource.MONEY, resourcesObject, cost);
		addCostForOrZero(IConstants.JSON_RESOURCE_ORE, Resource.ORE, resourcesObject, cost);
		addCostForOrZero(IConstants.JSON_RESOURCE_PAPYRUS, Resource.PAPYRUS, resourcesObject, cost);
		addCostForOrZero(IConstants.JSON_RESOURCE_STONE, Resource.STONE, resourcesObject, cost);
		addCostForOrZero(IConstants.JSON_RESOURCE_TEXTILES, Resource.TEXTILES, resourcesObject, cost);
		addCostForOrZero(IConstants.JSON_RESOURCE_WOOD, Resource.WOOD, resourcesObject, cost);
		return cost;
	}

	private static void addCostForOrZero(String jsonResourceEntry, Resource resource, JSONObject resourcesObject,
			Map<Resource, Integer> cost) {
		Integer value = 0;
		if (resourcesObject.containsKey(jsonResourceEntry)) {
			value = Double.valueOf(resourcesObject.get(jsonResourceEntry).isNumber().doubleValue()).intValue();
		}
		cost.put(resource, value);
	}

}
