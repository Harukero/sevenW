package sevenWonders.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.CardPanel;
import sevenWonders.client.elements.ListGroup;
import sevenWonders.client.internationalization.ViewConstants;
import sevenWonders.client.view.ResourcesCounterView.ResourceCounterType;
import sevenWonders.core.gameElements.Card;

public class BoardView extends Composite {

	private FlowPanel root;
	private ResourcesCounterView resourcesCounterView;
	private ListGroup<CardPanel> hand;
	private ListGroup<CardPanel> gameZone;
	private static final ViewConstants constants = GWT.create(ViewConstants.class);


	public BoardView() {
		root = new FlowPanel();
		resourcesCounterView = new ResourcesCounterView(ResourceCounterType.MAIN_PLAYER);
		root.add(resourcesCounterView);
		hand = new ListGroup<CardPanel>(constants.PLAYERS_HAND());
		gameZone = new ListGroup<CardPanel>(constants.PLAYED_CARDS());
		gameZone.addStyleName(IStyleNames.FLOAT_RIGHT);
		root.add(hand);
		root.add(gameZone);
		initWidget(root);
	}

	public void initHand(List<Card> cards) {
		hand.clear();
		gameZone.clear();
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			hand.addElement(new CardPanel(card));
			if (i >= 7) {
				break;
			}
		}
	}

	public ListGroup<CardPanel> getHand() {
		return hand;
	}

	public ListGroup<CardPanel> getGameZone() {
		return gameZone;
	}
	
	public ResourcesCounterView getResourcesCounterView() {
		return resourcesCounterView;
	}

}
