package sevenWonders.core.gameElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

import sevenWonders.client.services.GameService;

public class GameModel implements IsSerializable {

	private Map<Integer, Board> playersBoards;
	private int nbPlayer;

	@SuppressWarnings("unused")
	private GameModel() {
		this.nbPlayer = 3;
		playersBoards = new HashMap<Integer, Board>();
	}
	
	public GameModel(int nbPlayer) {
		this.nbPlayer = nbPlayer;
		playersBoards = new HashMap<Integer, Board>();
		prepareModel();
	}

	public void prepareModel() {
		List<Card> cardsForSpecificNbOfPlayersAndAge = GameService.INSTANCE
				.getCardsForSpecificNbOfPlayersAndAge(nbPlayer, Age.FIRST);
		for (int i = 1; i <= nbPlayer; i++) {
			Board board = new Board(Wonder.GIZAH);
			playersBoards.put(new Integer(i), board);
			List<Card> hand = new ArrayList<Card>();
			for (int j=0;j<7;j++) {
				hand.add(cardsForSpecificNbOfPlayersAndAge.get(i * j));
			}
			board.setHand(hand);
		}
	}

	public Board getPlayersBoard(Integer playerId) {
		return playersBoards.get(playerId);
	}

	public void switchHands() {
		List<Card> other = playersBoards.get(1).getHand();
		for (int i=2; i<=nbPlayer;i++) {
			Board replaced = playersBoards.get(i);
			other = replaceplayersHandByOtherHand(other, replaced);
		}
		replaceplayersHandByOtherHand(other, playersBoards.get(1));
	}

	private List<Card> replaceplayersHandByOtherHand(List<Card> other, Board replaced) {
		List<Card> replacedHand = replaced.getHand();
		replaced.setHand(other);
		return replacedHand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nbPlayer;
		result = prime * result + ((playersBoards == null) ? 0 : playersBoards.hashCode());
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
		GameModel other = (GameModel) obj;
		if (nbPlayer != other.nbPlayer)
			return false;
		if (playersBoards == null) {
			if (other.playersBoards != null)
				return false;
		} else if (!playersBoards.equals(other.playersBoards))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GameModel [playersBoards=" + playersBoards + ", nbPlayer=" + nbPlayer + "]";
	}
	
}


