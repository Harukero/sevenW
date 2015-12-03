package sevenWonders.client.elements.gameSpecific;

import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.services.GameService;
import sevenWonders.core.gameElements.Card;

public class CardExplanationPanel extends Composite {

	private FlowPanel root;
	private String category;

	public CardExplanationPanel(String category) {
		this.category = category;
		root = new FlowPanel();
		initWidget(root);
	}

	public void addCards() {
		List<Card> cardsCategory = GameService.INSTANCE.getCardsForCategory(category);
		for (Card card : cardsCategory) {
			CardPanel cardPanel = new CardPanel(card);
			root.add(cardPanel);
		}
	}
}
