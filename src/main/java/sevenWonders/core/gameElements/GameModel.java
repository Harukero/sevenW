package sevenWonders.core.gameElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.user.client.rpc.IsSerializable;

import sevenWonders.client.services.GameService;

public class GameModel implements IsSerializable {

	private Map<Integer, Board> playersBoards;
	private int nbPlayer;
	private Age currentAge;
	protected static Logger logger = Logger.getLogger(GameModel.class.getName());

	@SuppressWarnings("unused")
	private GameModel() {
	}
	
	public GameModel(int nbPlayer) {
		this.nbPlayer = nbPlayer;
		playersBoards = new HashMap<Integer, Board>();
		currentAge = Age.FIRST;
		prepareModel();
	}

	private Age getCurrentAge() {
		return currentAge;
	}

	private void setCurrentAge(Age currentAge) {
		this.currentAge = currentAge;
	}
	
	public void prepareModel() {
		List<Card> cardsForSpecificNbOfPlayersAndAge = GameService.INSTANCE
				.getCardsForSpecificNbOfPlayersAndAge(nbPlayer, currentAge);
		for (int i = 1; i <= nbPlayer; i++) {
			Board board = new Board(Wonder.GIZAH);
			playersBoards.put(new Integer(i), board);
			List<Card> hand = new ArrayList<Card>();
			for (int j = 0; j < 7; j++) {
				hand.add(cardsForSpecificNbOfPlayersAndAge.remove(0));
			}
			board.setHand(hand);
		}
	}

	public Age switchHandsOrAge() {
		if (getPlayerBoard().getHand().size() == 1) {
			changeAgeOrEndGame();
		} else {
			switchHands();
		}
		return currentAge;
	}
	
	
	private void changeAgeOrEndGame() {
		if (currentAge == Age.FIRST) {
			currentAge = Age.SECOND;
		} else if (currentAge == Age.SECOND) {
			currentAge = Age.THIRD;
		} else {
			currentAge = Age.END_GAME;
			return;
		}
		List<Card> cardsForSpecificNbOfPlayersAndAge = GameService.INSTANCE
				.getCardsForSpecificNbOfPlayersAndAge(nbPlayer, currentAge);
		for (int i = 1; i <= nbPlayer; i++) {
	
			List<Card> hand = new ArrayList<Card>();
			for (int j=0;j<7;j++) {
				Card card = cardsForSpecificNbOfPlayersAndAge.remove(0);
				hand.add(card);
			}
			playersBoards.get(i).setHand(hand);
		}
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

	
	private Board getPlayersBoard(Integer playerId) {
		return playersBoards.get(playerId);
	}

	public Board getPlayerBoard() {
		return getPlayersBoard(1);
	}

	public List<Board> getAIBoards() {
		List<Board> aiBoards = new ArrayList<>();
		for (int playerId = 2; playerId<=nbPlayer;playerId++) {
			aiBoards.add(getPlayersBoard(playerId));
		}
		return aiBoards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentAge == null) ? 0 : currentAge.hashCode());
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
		if (currentAge != other.currentAge)
			return false;
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
		return "GameModel [playersBoards=" + playersBoards + ", nbPlayer=" + nbPlayer + ", currentAge=" + currentAge
				+ "]";
	}

}


