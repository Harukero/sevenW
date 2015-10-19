package sevenWonders.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.elements.CardPanel;
import sevenWonders.client.elements.ListGroup;
import sevenWonders.client.services.GameService;
import sevenWonders.client.view.ResourcesCounterView.ResourceCounterType;
import sevenWonders.core.gameElements.Age;
import sevenWonders.core.gameElements.Card;

public class BoardView extends Composite {

	private FlowPanel root;
	private ResourcesCounterView resourcesCounterView;
	private ListGroup hand;

	public BoardView() {
		root = new FlowPanel();
		resourcesCounterView = new ResourcesCounterView(ResourceCounterType.MAIN_PLAYER);
		root.add(resourcesCounterView);
		hand = new ListGroup();
		root.add(hand);

		initWidget(root);
	}

	public void initHand() {
		hand.clear();
		List<Card> cardsFromAge = GameService.INSTANCE.getCardsFromAge(Age.FIRST);
		for (int i = 0; i < cardsFromAge.size(); i++) {
			Card card = cardsFromAge.get(i);
			hand.addElement(new CardPanel(card));
			if (i >= 7) {
				break;
			}
		}
	}

}
