package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.core.gameElements.Card;

public class CardPanel extends Composite {

	private FlowPanel root;

	public CardPanel(Card card) {
		root = new FlowPanel();
		root.add(new Label(card.getName()));
//		String imageUrl = card.getImageURL();
//		root.add(new Image(imageUrl));
		initWidget(root);
	}
	
}
