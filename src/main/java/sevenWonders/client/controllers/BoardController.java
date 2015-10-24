package sevenWonders.client.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.view.BoardView;

public class BoardController {

	private final BoardView view;
	private final Map<Widget, HandlerRegistration> widgetToHandler = new HashMap<>();

	public BoardController(BoardView view) {
		this.view = view;
		bindView();
	}

	private void bindView() {
		view.initHand();
		List<Widget> handsCards = view.getHand().getElements();
		for (final Widget widget : handsCards) {
			addClickHandlerOnHandsCards(widget);
		}
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
