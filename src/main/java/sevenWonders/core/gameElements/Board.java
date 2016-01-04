package sevenWonders.core.gameElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

import sevenWonders.core.gameElements.effects.GivePoints;
import sevenWonders.core.gameElements.effects.GiveScientificElement;
import sevenWonders.core.gameElements.effects.IsAnEffect;

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
	private static final Comparator<Card> cardCategoryComparator = new Comparator<Card>() {

		@Override
		public int compare(Card o1, Card o2) {
			return o1.getType().getRank() - o2.getType().getRank();
		}
	};
	
	private Wonder wonder;
	private List<Card> playedCards;
	private List<Card> hand;
	private List<Map<Resource, Integer>> resources;

	@SuppressWarnings("unused")
	private Board() {
	}
	
	public Board(Wonder wonder) {
		this.wonder = wonder;
		this.playedCards = new ArrayList<>();
		resources = new ArrayList<>();
		resources.add(new HashMap<>(BASE_RESOURCES));
		increaseResource(wonder.getResource(), 1);
	}

	public List<Map<Resource, Integer>> getResources() {
		return resources;
	}

	public void increaseResource(Resource resource, Integer amount) {
		for (Map<Resource, Integer> possibleResourcesPath : resources) {
			Integer currentAmount = possibleResourcesPath.get(resource);
			possibleResourcesPath.put(resource, currentAmount + amount);
		}
	}
	
	public void decreaseResource(Resource resource, Integer amount) {
		for (Map<Resource, Integer> possibleResourcesPath : resources) {
			Integer currentAmount = possibleResourcesPath.get(resource);
			possibleResourcesPath.put(resource, currentAmount - amount);
		}
	}
	

	public void addResourceChoice(Resource[] givenResources) {
		List<Map<Resource, Integer>> futureResourcesChoices = new ArrayList<>();
		for (Resource resource : givenResources) {
			for (Map<Resource,Integer> map : resources) {
				Map<Resource, Integer> currentChoice = new HashMap<>(map);
				Integer currentAmount = currentChoice.get(resource);
				currentChoice.put(resource, currentAmount + 1);
				futureResourcesChoices.add(currentChoice);
			}
		}
		resources = futureResourcesChoices;
	}
	
	public List<Card> getHand() {
		Collections.sort(hand, cardCategoryComparator);
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public Wonder getWonder() {
		return wonder;
	}

	public List<Card> getPlayedCards() {
		Collections.sort(playedCards, cardCategoryComparator);
		return playedCards;
	}

	public Integer getMoneyAmount() {
		return resources.get(0).get(Resource.MONEY);
	}
	
	public int computeScore() {
		int score = resources.get(0).get(Resource.MONEY) / 3;
		int cogNumber = 0;
		int tabletNumber = 0;
		int compasNumber = 0;
		for (Card card : playedCards) {
			for (IsAnEffect effect : card.getEffects()) {
				if (effect instanceof GivePoints) {
					GivePoints givePoints = (GivePoints) effect;
					score += givePoints.getGivenPoints();
				} else if (effect instanceof GiveScientificElement) {
					GiveScientificElement scientificElement = (GiveScientificElement) effect;
					switch (scientificElement) {
					case COG:
						cogNumber ++;
						break;
					case COMPAS:
						compasNumber++;
						break;
					case TABLET:
						tabletNumber ++;
						break;
					}
					
				}
			}
		}
		score += cogNumber * cogNumber;
		score += tabletNumber * tabletNumber;
		score += compasNumber * compasNumber;
		while (cogNumber > 0 && tabletNumber > 0 && compasNumber > 0) {
			score += 7;
			cogNumber--;
			tabletNumber--;
			compasNumber--;
		}
		return score;
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
