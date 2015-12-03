package sevenWonders.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.elements.bootstrap.ListGroup;
import sevenWonders.client.elements.gameSpecific.CardPanel;
import sevenWonders.client.internationalization.ViewConstants;
import sevenWonders.client.view.ResourcesCounterView.ResourceCounterType;
import sevenWonders.core.gameElements.Card;

public class BasicBoardView extends Composite {
	
	protected static final ViewConstants constants = GWT.create(ViewConstants.class);
	private ResourcesCounterView resourcesCounterView;

	protected FlowPanel root;
	protected ListGroup<CardPanel> hand;
	protected ListGroup<CardPanel> gameZone;
	
	public BasicBoardView() {
		root = new FlowPanel();
		resourcesCounterView = getAccurateResourceCounter();
		root.add(resourcesCounterView);
		initRoot();
		initWidget(root);	
	}
	
	protected void initRoot() {

		hand = new ListGroup<CardPanel>(constants.PLAYERS_HAND());
		gameZone = new ListGroup<CardPanel>(constants.PLAYED_CARDS());
		root.add(hand);
		root.add(gameZone);		
	}

	protected ResourcesCounterView getAccurateResourceCounter() {
		return new ResourcesCounterView(ResourceCounterType.OPPONENT);
	}
	
	public ResourcesCounterView getResourcesCounterView() {
		return resourcesCounterView;
	}
	
	public void updateHand(List<Card> cards) {
		hand.clear();
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			hand.addElement(new CardPanel(card));
			if (i >= 7) {
				throw new IllegalStateException("Error, there should not be more than 7 cards in one player's hand.");
			}
		}
	}

	public ListGroup<CardPanel> getHand() {
		return hand;
	}

	public ListGroup<CardPanel> getGameZone() {
		return gameZone;
	}
	
	public void initGameZone(List<Card> playedCards) {
		gameZone.clear();
		for (int i = 0; i < playedCards.size(); i++) {
			Card card = playedCards.get(i);
			gameZone.addElement(new CardPanel(card));
		}		
	}
	
}
