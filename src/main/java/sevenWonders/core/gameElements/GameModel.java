package sevenWonders.core.gameElements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sevenWonders.client.services.GameService;

public class GameModel {

	private Map<Integer, Board> playersBoards;

	public GameModel(int nbPlayer) {
		playersBoards = new HashMap<>();
		List<Card> cardsForSpecificNbOfPlayersAndAge = GameService.INSTANCE
				.getCardsForSpecificNbOfPlayersAndAge(nbPlayer, Age.FIRST);
		for (int i = 1; i <= nbPlayer; i++) {
			Board board = new Board(Wonder.GIZAH);
			playersBoards.put(new Integer(i), board);
			board.setHand(cardsForSpecificNbOfPlayersAndAge.subList((i - 1) * 7, i * 7));
		}
	}

	public Board getPlayersBoard(Integer playerId) {
		return playersBoards.get(playerId);
	}
}
