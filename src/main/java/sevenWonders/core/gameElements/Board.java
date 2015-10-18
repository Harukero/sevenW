package sevenWonders.core.gameElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A {@link Board} is the main part of the game. There is one board per player
 * Each {@link Board} is constituted with :
 * 	- a {@link Wonder}
 *  - played {@link Card}s
 *  - un-played {@link Card}s
 *  - other markers
 *  
 * @author Harukero
 *
 */
public class Board {
	private final Wonder wonder;
	private final List<Card> playedCards;
	private List<Card> hand;
	private final Map<Resource, Integer> resources;
	
	public Board(Wonder wonder) {
		this.wonder = wonder;
		this.playedCards = new ArrayList<>();
		resources = new HashMap<>();
	}
	
	public Map<Resource, Integer> getResources() {
		return resources;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public Wonder getWonder() {
		return wonder;
	}

	public List<Card> getPlayedCards() {
		return playedCards;
	}
	
}
