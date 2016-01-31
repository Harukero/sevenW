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
import sevenWonders.core.gameElements.CardType;
import sevenWonders.core.gameElements.GameModel;
import sevenWonders.core.gameElements.Resource;
import sevenWonders.core.gameElements.actions.DiscardAction;
import sevenWonders.core.gameElements.actions.GameActionType;
import sevenWonders.core.gameElements.actions.IsAnAction;
import sevenWonders.core.gameElements.actions.PlayCardAction;
import sevenWonders.core.gameElements.effects.GiveResources;
import sevenWonders.core.gameElements.effects.IsAnEffect;
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
		for (IsAnAction action : actions) {
			applyEffects(action);
		}
	}


	private void applyEffects(IsAnAction action) {
		GameActionType actionType = action.getActionType();
		switch (actionType) {
		case PLAY_CARD:
			playCard(action.getPlayerBoard(), action.getCard());
			break;
		case WONDER_LEVEL:
			// TODO: implements levels effects
			break;
		case BUY_RESOURCE:
			break;
		case CHOOSE_SCIENCE_SYMBOL:
			break;
		case COPY_CARD_EFFECT:
			break;
		case DISCARD:
			// nothing to do
			break;
		default:
			break;
		}
	}


	private void playCard(Board player, Card card) {
		CardType cardType = card.getType();
		switch (cardType) {
		case CIVIC_STRUCTURE:
			break;
		case GUILD:
			break;
		case COMMERCIAL_STRUCTURE:
		case RAW_MATERIAL:
		case MANUFACTURED_GOOD:
			addResources(player, card);
			break;
		case MILITARY_STRUCTURE:
			break;
		case SCIENTIFIC_STRUCTURE:
			break;
		default:
			break;
		}
	}


	private void addResources(Board player, Card card) {
		for (IsAnEffect effect : card.getEffects()) {
			if (effect instanceof GiveResources){
				GiveResources giveResources = (GiveResources) effect;
				if (giveResources.isAllResourcesAvailable()) {
					for (Resource resource : giveResources.getGivenResources()) {
						player.increaseResource(resource, 1);
					}
				} else {
					player.addResourceChoice(giveResources.getGivenResources());
				}
			}
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
