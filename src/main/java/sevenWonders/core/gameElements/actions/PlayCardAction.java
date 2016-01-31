package sevenWonders.core.gameElements.actions;

import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.Resource;

public class PlayCardAction implements IsAnAction {
	private GameActionType actionType = GameActionType.PLAY_CARD;
	private Board playerBoard;
	private Card card;
	
	
	@SuppressWarnings("unused")
	private PlayCardAction() {}
	
	public PlayCardAction(Board playerBoard, Card card) {
		this.playerBoard = playerBoard;
		this.card = card;
	}
	
	@Override
	public GameActionType getActionType() {
		return actionType;
	}

	@Override
	public Board getPlayerBoard() {
		return playerBoard;
	}

	@Override
	public Card getCard() {
		return card;
	}

	@Override
	public void doAction() {
		playerBoard.getPlayedCards().add(card);
		playerBoard.increaseResource(Resource.MONEY, -card.getMoneyCost());
		playerBoard.getHand().remove(card);
	}
	
	@Override
	public void undoAction() {
		playerBoard.getHand().add(card);
		playerBoard.increaseResource(Resource.MONEY, card.getMoneyCost());
		playerBoard.getPlayedCards().remove(card);
	}
	
	@Override
	public String logAction(String language) {
		return playerBoard.getWonder().getName() + " played Card:"+card.getName(language);
	}

	@Override
	public String toString() {
		return "PlayCardAction [actionType=" + actionType + ", player=" + playerBoard + ", card=" + card + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionType == null) ? 0 : actionType.hashCode());
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + ((playerBoard == null) ? 0 : playerBoard.hashCode());
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
		PlayCardAction other = (PlayCardAction) obj;
		if (actionType != other.actionType)
			return false;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (playerBoard == null) {
			if (other.playerBoard != null)
				return false;
		} else if (!playerBoard.equals(other.playerBoard))
			return false;
		return true;
	}
	
}
