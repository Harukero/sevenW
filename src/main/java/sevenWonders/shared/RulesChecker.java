package sevenWonders.shared;

import java.util.Map;
import java.util.Map.Entry;

import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.Resource;

public class RulesChecker {
	
	public static boolean isPlayable(Card playerCard, Board board, String language) {
		return checkName(playerCard, board, language) && checkCost(playerCard, board);
	}

	private static boolean checkName(Card playerCard, Board board, String language) {
		String cardName = playerCard.getName(language);
		for (Card card : board.getPlayedCards()) {
			if (cardName.equals(card.getName(language))) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkCost(Card playerCard, Board board) {
		for (Map<Resource, Integer> currentChoice : board.getResources()) {
			boolean choiceIsOk = true;
			for (Entry<Resource, Integer> costPerResource: playerCard.getCost().entrySet()) {
				Resource costResource = costPerResource.getKey();
				Integer costForResource = costPerResource.getValue();
				
				Integer playersAmountForResource = currentChoice.get(costResource);
				if (costForResource > playersAmountForResource) {
					choiceIsOk = false;
					break;
				}
			}
			if (choiceIsOk) {
				return true;
			}
		}
		return false;
	}

}
