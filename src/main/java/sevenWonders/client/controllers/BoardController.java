package sevenWonders.client.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.view.BoardView;
import sevenWonders.core.gameElements.Board;

public class BoardController {

	private final BoardView view;
	private final Map<Widget, HandlerRegistration> widgetToHandler = new HashMap<>();
	private Board board;

	public BoardController(BoardView view) {
		this.view = view;
	}

	public void prepareView(Board board) {
		this.board = board;
		view.initHand(board.getHand());
		bindView();
	}

	private void bindView() {
		List<Widget> handsCards = view.getHand().getElements();
		for (final Widget widget : handsCards) {
			addClickHandlerOnHandsCards(widget);
		}
		view.getResourcesCounterView().updateView(board.getResources());
	}

	private void addClickHandlerOnHandsCards(final Widget widget) {
		HandlerRegistration domHandler = widget.addDomHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				view.getGameZone().addElement(widget);
				view.getHand().removeElement(widget);
				HandlerRegistration handlerRegistration = widgetToHandler.get(widget);
				handlerRegistration.removeHandler();
				widgetToHandler.remove(widget);

			}
		}, ClickEvent.getType());
		widgetToHandler.put(widget, domHandler);
	}

}
