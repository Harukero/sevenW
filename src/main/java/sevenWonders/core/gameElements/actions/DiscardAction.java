package sevenWonders.core.gameElements.actions;

import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.Resource;

public class DiscardAction implements IsAnAction {

	private GameActionType actionType = GameActionType.DISCARD;
	private Board player;
	private Card discardedCard;
	
	
	@SuppressWarnings("unused")
	private DiscardAction() {
		
	}
	
	public DiscardAction(Board player, Card discardedCard) {
		this.player = player;
		this.discardedCard = discardedCard;
	}
	
	@Override
	public GameActionType getActionType() {
		return actionType;
	}

	@Override
	public Board getPlayerBoard() {
		return player;
	}

	@Override
	public Card getCard() {
		return discardedCard;
	}

	@Override
	public void doAction() {
		player.getHand().remove(discardedCard);
		player.increaseResource(Resource.MONEY, 3);
	}

	@Override
	public void undoAction() {
		player.decreaseResource(Resource.MONEY, 3);
		player.getHand().add(discardedCard);
	}
	
	@Override
	public String logAction(String language) {
		return player.getWonder().getName() + " discarded Card:"+discardedCard.getName(language);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionType == null) ? 0 : actionType.hashCode());
		result = prime * result + ((discardedCard == null) ? 0 : discardedCard.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
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
		DiscardAction other = (DiscardAction) obj;
		if (actionType != other.actionType)
			return false;
		if (discardedCard == null) {
			if (other.discardedCard != null)
				return false;
		} else if (!discardedCard.equals(other.discardedCard))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DiscardAction [actionType=" + actionType + ", player=" + player + ", discardedCard=" + discardedCard
				+ "]";
	}
	
}
