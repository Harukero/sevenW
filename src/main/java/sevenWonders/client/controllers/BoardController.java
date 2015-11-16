package sevenWonders.client.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.elements.CardPanel;
import sevenWonders.client.view.BoardView;
import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.Resource;

public class BoardController {

	private final BoardView view;
	private final Map<Widget, HandlerRegistration> widgetToHandler = new HashMap<>();
	private Board board;
	private static Logger logger = Logger.getLogger(BoardController.class.getName());

	public BoardController(BoardView view) {
		this.view = view;
	}

	public void prepareView(Board board) {
		this.board = board;
		view.initHand(board.getHand());
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
				playCardIfPossible(cardPanel);

			}

		}, ClickEvent.getType());
		widgetToHandler.put(cardPanel, domHandler);
	}

	private void playCardIfPossible(final CardPanel cardPanel) {
		Card containedCard = cardPanel.getContainedCard();
		if (isPlayable(containedCard.getCost(), board.getResources())) {
			view.getGameZone().addElement(cardPanel);
			view.getHand().removeElement(cardPanel);
			HandlerRegistration handlerRegistration = widgetToHandler.get(cardPanel);
			handlerRegistration.removeHandler();
			widgetToHandler.remove(cardPanel);
		} 
	}

	private boolean isPlayable(Map<Resource, Integer> cardCost, Map<Resource, Integer> playersResources) {
		for (Entry<Resource, Integer> costPerResource: cardCost.entrySet()) {
			Resource costResource = costPerResource.getKey();
			Integer costForResource = costPerResource.getValue();
			
			Integer playersAmountForResource = playersResources.get(costResource);
			if (costForResource > playersAmountForResource) {
				logger.warning("Unable to play this card: "+ costResource +"-->" +costForResource +" superior to possessed amount: "+playersAmountForResource);
				return false;
			}
		}
		return true;
	}

}
