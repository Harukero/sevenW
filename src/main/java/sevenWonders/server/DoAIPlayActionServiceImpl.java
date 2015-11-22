package sevenWonders.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import sevenWonders.client.rpc.DoAIPlayActionService;
import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.GameModel;
import sevenWonders.core.gameElements.Resource;
import sevenWonders.shared.RulesChecker;

@SuppressWarnings("serial")
public class DoAIPlayActionServiceImpl extends RemoteServiceServlet implements DoAIPlayActionService {

	private static final Logger logger = Logger.getLogger(DoAIPlayActionServiceImpl.class.getName());
	private String uiLanguage;
	
	
	@Override
	public GameModel aiTurn(GameModel model, String uiLanguage, int turnNumber) {
		this.uiLanguage = uiLanguage;
		for (Board board : model.getAIBoards()) {
			chooseAndPlayCard(board, uiLanguage);
		}
		return model;
	}


	private void chooseAndPlayCard(Board board, String uiLanguage) {
		List<Card> playableCards = new ArrayList<>();
		for (Card card : board.getHand()) {
			if (RulesChecker.isPlayable(card, board, uiLanguage)) {
				playableCards.add(card);
			}
		}
		Collections.shuffle(playableCards);
		if (playableCards.isEmpty()) {
			throwCard(board.getHand().get(0), board);
		} else {
			playCard(playableCards.get(0), board);
		}
	}


	private void playCard(Card card, Board board) {
		board.getHand().remove(card);
		board.getPlayedCards().add(card);
	}


	private void throwCard(Card card, Board board) {
		board.getHand().remove(card);
		Integer integer = board.getResources().get(Resource.MONEY);
		board.getResources().put(Resource.MONEY, integer + 3);
	}
}
