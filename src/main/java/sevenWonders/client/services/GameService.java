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
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

import sevenWonders.client.rpc.CardGetterService;
import sevenWonders.client.rpc.CardGetterServiceAsync;
import sevenWonders.core.gameElements.Card;

public class GameService {
	
	public static final GameService INSTANCE = new GameService();
	private static Logger logger = Logger.getLogger(GameService.class.getName());
	private Map<String, List<Card>> cards;
	private final CardGetterServiceAsync getCardsService = GWT.create(CardGetterService.class);

	
	private GameService() {
	}

	public void initCardsList() {
		getCardsService.getCards(new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				logger.log(Level.SEVERE, caught.getMessage());
			}

			@Override
			public void onSuccess(String result) {
				cards = new HashMap<>();
				JSONObject a = (JSONObject) JSONParser.parseStrict(result);
				Set<String> entries = a.keySet();
				for (String key : entries) {
					cards.put(key, getCards(key, a));
				}
			}

			private List<Card> getCards(String key, JSONObject a) {
				List<Card> cards = new ArrayList<>();
				JSONArray cardsListJson = (JSONArray) a.get(key);
				int size = cardsListJson.size();
				for (int position = 0; position < size; position++) {
					JSONObject cardJson = (JSONObject) cardsListJson.get(position);
					cards.addAll(Card.fromJSON(cardJson));
				}
				logger.fine("Added "+cards.size()+ " cards from key "+ key);
				return cards;
			}

		});
	}

	public Map<String, List<Card>> getCards() {
		return cards;
	}
	
	public List<Card> getCardsCategory(String category) {
		return cards.get(category);
	}
}
