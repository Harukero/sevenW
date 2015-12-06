package sevenWonders.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import sevenWonders.client.rpc.DoAIPlayActionService;
import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.GameModel;
import sevenWonders.core.gameElements.actions.DiscardAction;
import sevenWonders.core.gameElements.actions.IsAnAction;
import sevenWonders.core.gameElements.actions.PlayCardAction;
import sevenWonders.shared.RulesChecker;

@SuppressWarnings("serial")
public class DoAIPlayActionServiceImpl extends RemoteServiceServlet implements DoAIPlayActionService {

	private static final Logger logger = Logger.getLogger(DoAIPlayActionServiceImpl.class.getName());
	
	
	@Override
	public GameModel aiTurn(GameModel model, String uiLanguage, IsAnAction playerAction, int turnNumber) {
		List<IsAnAction> actions = new ArrayList<>();
		actions.add(playerAction);
		for (Board board : model.getAIBoards()) {
			actions.add(chooseAndPlayCard(board, uiLanguage));
		}
		applyActions(actions, uiLanguage);
		return model;
	}


	private void applyActions(List<IsAnAction> actions, String uiLanguage) {
		for (IsAnAction action : actions) {
			action.doAction();
			logger.log(Level.WARNING, action.logAction(uiLanguage));
		}
	}


	private IsAnAction chooseAndPlayCard(Board board, String uiLanguage) {
		List<Card> playableCards = new ArrayList<>();
		for (Card card : board.getHand()) {
			if (RulesChecker.isPlayable(card, board, uiLanguage)) {
				playableCards.add(card);
			}
		}
		Collections.shuffle(playableCards);
		if (playableCards.isEmpty()) {
			return new DiscardAction(board, board.getHand().get(0));
		} else {
			return new PlayCardAction(board, playableCards.get(0));
		}
	}
}
