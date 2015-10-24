package sevenWonders.client.elements;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.core.gameElements.Card;

public class CardPanel extends Composite {

	private FlowPanel root;
	private HandlerRegistration addDomHandler;

	public CardPanel(Card card) {
		root = new FlowPanel();
		root.add(new Label(card.getName()));
		String imageUrl = card.getImageURL();
		root.add(new Image(imageUrl));
		initWidget(root);
	}

	public void addClickHandler(ClickHandler clickHandler) {
		if (addDomHandler != null) {
			addDomHandler.removeHandler();
		}
		addDomHandler = root.addDomHandler(clickHandler, ClickEvent.getType());
	}

}
