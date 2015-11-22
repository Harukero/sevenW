package sevenWonders.client.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.CardPanel;
import sevenWonders.client.elements.ModalPopup;
import sevenWonders.client.elements.ModalPopup.IDialogCustomizer;
import sevenWonders.client.internationalization.ViewConstants;
import sevenWonders.client.rpc.DoAIPlayActionService;
import sevenWonders.client.rpc.DoAIPlayActionServiceAsync;
import sevenWonders.client.services.GameService;
import sevenWonders.client.view.BoardView;
import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.GameModel;
import sevenWonders.core.gameElements.Resource;
import sevenWonders.shared.RulesChecker;

public class BoardController {

	private static final String PLAY_CARD_ID = "choose-action";
	private final BoardView view;
	private final Map<Widget, HandlerRegistration> widgetToHandler = new HashMap<>();
	private Board board;
	private static final ViewConstants constants = GWT.create(ViewConstants.class);
	private GameModel model;
	private final DoAIPlayActionServiceAsync aiActionService = GWT.create(DoAIPlayActionService.class);
	private static Logger logger = Logger.getLogger(BoardController.class.getName());

	
	public BoardController(BoardView view) {
		this.view = view;
	}

	public void prepareView(Board board) {
		this.board = board;
		view.initHand(board.getHand());
		view.initGameZone(board.getPlayedCards());
		bindView();
	}

	private void bindView() {
		List<CardPanel> handsCards = view.getHand().getElements();
		for (final CardPanel widget : handsCards) {
			addClickHandlerOnHandsCards(widget);
		}
		view.getResourcesCounterView().updateView(board.getResources());
	}

	private void addClickHandlerOnHandsCards(final CardPanel cardPanel) {
		HandlerRegistration domHandler = cardPanel.addDomHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				showPlayCardPopup(cardPanel);
			}

		}, ClickEvent.getType());
		widgetToHandler.put(cardPanel, domHandler);
	}

	private void removeCardFromHand(final CardPanel cardPanel) {
		view.getHand().removeElement(cardPanel);
		HandlerRegistration handlerRegistration = widgetToHandler.get(cardPanel);
		handlerRegistration.removeHandler();
		widgetToHandler.remove(cardPanel);
	}

	
	public void showPlayCardPopup(final CardPanel cardPanel) {
		final Button playCardBtn = createPlayCardButton(cardPanel);
		final Button throwCard = createThrowCardButton(cardPanel);
		final Card playerCard = cardPanel.getContainedCard();
		ModalPopup.openModalPopup(constants.chooseAnAction(), PLAY_CARD_ID, new IDialogCustomizer() {
			
			@Override
			public void setBody(FlowPanel body) {
				CardPanel newCardPanel = new CardPanel(cardPanel.getContainedCard());
				body.add(new Label(constants.chooseAnActionForCard()));
				body.add(newCardPanel);
			}
			
			@Override
			public void addElementsToFooter(FlowPanel footer) {
				footer.add(throwCard);
				if (RulesChecker.isPlayable(playerCard, board, GameService.INSTANCE.getUiLanguage())) {
					footer.add(playCardBtn);
				}
			}
		});
	}

	private Button createThrowCardButton(final CardPanel cardPanel) {
		final Button throwCard = new Button(constants.throwCard());
		throwCard.getElement().setClassName(IStyleNames.BTN);
		throwCard.getElement().addClassName(IStyleNames.BTN_WARNING);
		throwCard.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onThrowCard(cardPanel);
				endTurn();
			}

		});
		return throwCard;
	}

	/*
	 * Throwing a card :
	 * remove from the hand view and hand model
	 * add 3 money
	 */
	private void onThrowCard(final CardPanel cardPanel) {
		removeCardFromHand(cardPanel);
		board.getHand().remove(cardPanel.getContainedCard());
		addResourcesToBoard(Resource.MONEY, 3);
		ModalPopup.close(PLAY_CARD_ID);
	}

	private Button createPlayCardButton(final CardPanel cardPanel) {
		final Button playCardBtn = new Button(constants.playCard());
		playCardBtn.getElement().setClassName(IStyleNames.BTN);
		playCardBtn.getElement().addClassName(IStyleNames.BTN_SUCCESS);
		playCardBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onPlayCard(cardPanel);
				endTurn();
			}


		});
		return playCardBtn;
	}

	private void endTurn() {
		// TODO end turn
		/*
		 * End turn : AI plays server-side then users switch hand or get new hand
		 * depending on age advancement  
		 */
		aiActionService.aiTurn(model, new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				logger.severe("Error, please check this:\n"+caught.getMessage());
			}

			@Override
			public void onSuccess(Void result) {
				logger.warning("AI has played !!");				
			}

		});
	}

	/*
	 * Play a card is : removing from the hand,
	 * both view and model
	 * updating the resources if needed
	 * Putting it on the board
	 * both view and model
	 * apply card's effect(s)
	 */
	private void onPlayCard(final CardPanel cardPanel) {
		view.getGameZone().addElement(cardPanel);
		board.getPlayedCards().add(cardPanel.getContainedCard());
		payCard(cardPanel.getContainedCard().getCost());
		removeCardFromHand(cardPanel);
		board.getHand().remove(cardPanel.getContainedCard());
		ModalPopup.close(PLAY_CARD_ID);
	}

	private void payCard(Map<Resource, Integer> cost) {
		if (cost.containsKey(Resource.MONEY)) {
			addResourcesToBoard(Resource.MONEY, -cost.get(Resource.MONEY));
		}
	}

	protected void addResourcesToBoard(Resource money, int i) {
		Integer integer = board.getResources().get(money);
		integer = integer + i;
		board.getResources().put(money, integer);
		view.getResourcesCounterView().updateView(board.getResources());
	}

	public void setModel(GameModel model) {
		this.model = model;
	}

}
