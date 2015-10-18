package sevenWonders.client.elements;

import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

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
		List<Card> cardsCategory = GameService.INSTANCE.getCardsCategory(category);
		for (Card card : cardsCategory) {
			FlowPanel cardPanel = new FlowPanel();
			cardPanel.add(new Label(card.getName()));
			String imageUrl = card.getImageURL();
			cardPanel.add(new Image(imageUrl));
			root.add(cardPanel);
		}
	}
}
