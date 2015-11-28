package sevenWonders.core.gameElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * A {@link Board} is the main part of the game. There is one board per player
 * Each {@link Board} is constituted with : - a {@link Wonder} - played
 * {@link Card}s - un-played {@link Card}s - other markers
 * 
 * @author Harukero
 *
 */
public class Board implements IsSerializable {

	private static final Map<Resource, Integer> BASE_RESOURCES = new HashMap<>();

	static {
		for (Resource r : Resource.values()) {
			if (r == Resource.MONEY) {
				BASE_RESOURCES.put(r, 3);
			} else {
				BASE_RESOURCES.put(r, 0);
			}
		}
	}

	private Wonder wonder;
	private List<Card> playedCards;
	private List<Card> hand;
	private Map<Resource, Integer> resources;

	@SuppressWarnings("unused")
	private Board() {
	}
	
	public Board(Wonder wonder) {
		this.wonder = wonder;
		this.playedCards = new ArrayList<>();
		resources = new HashMap<>(BASE_RESOURCES);
		resources.put(wonder.getResource(), 1);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		result = prime * result + ((playedCards == null) ? 0 : playedCards.hashCode());
		result = prime * result + ((resources == null) ? 0 : resources.hashCode());
		result = prime * result + ((wonder == null) ? 0 : wonder.hashCode());
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
		Board other = (Board) obj;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		if (playedCards == null) {
			if (other.playedCards != null)
				return false;
		} else if (!playedCards.equals(other.playedCards))
			return false;
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
			return false;
		if (wonder != other.wonder)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Board [wonder=" + wonder + ", playedCards=" + playedCards + ", hand=" + hand + ", resources="
				+ resources + "]";
	}

}
