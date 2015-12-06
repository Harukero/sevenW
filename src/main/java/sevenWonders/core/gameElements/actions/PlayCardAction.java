package sevenWonders.core.gameElements.actions;

import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.Resource;

public class PlayCardAction implements IsAnAction {
	private GameActionType actionType = GameActionType.PLAY_CARD;
	private Board player;
	private Card card;
	
	
	@SuppressWarnings("unused")
	private PlayCardAction() {}
	
	public PlayCardAction(Board player, Card card) {
		this.player = player;
		this.card = card;
	}
	
	@Override
	public GameActionType getActionType() {
		return actionType;
	}

	@Override
	public Board getPlayer() {
		return player;
	}

	@Override
	public Card getCard() {
		return card;
	}

	@Override
	public void doAction() {
		player.getPlayedCards().add(card);
		player.addResource(Resource.MONEY, -card.getMoneyCost());
		player.getHand().remove(card);
	}
	
	@Override
	public void undoAction() {
		player.getHand().add(card);
		player.addResource(Resource.MONEY, card.getMoneyCost());
		player.getPlayedCards().remove(card);
	}
	
	@Override
	public String logAction(String language) {
		return player.getWonder().getName() + " played Card:"+card.getName(language);
	}

	@Override
	public String toString() {
		return "PlayCardAction [actionType=" + actionType + ", player=" + player + ", card=" + card + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionType == null) ? 0 : actionType.hashCode());
		result = prime * result + ((card == null) ? 0 : card.hashCode());
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
		PlayCardAction other = (PlayCardAction) obj;
		if (actionType != other.actionType)
			return false;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		return true;
	}
	
}
