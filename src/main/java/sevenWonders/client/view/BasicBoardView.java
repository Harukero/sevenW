package sevenWonders.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.elements.gameSpecific.CardPanel;
import sevenWonders.client.elements.gameSpecific.GameZone;
import sevenWonders.client.internationalization.ViewConstants;
import sevenWonders.client.view.ResourcesCounterView.ResourceCounterType;
import sevenWonders.core.gameElements.Card;

public class BasicBoardView extends Composite {
	
	protected static final ViewConstants constants = GWT.create(ViewConstants.class);
	private ResourcesCounterView resourcesCounterView;

	protected FlowPanel root;
	protected GameZone<CardPanel> gameZone;
	
	public BasicBoardView() {
		root = new FlowPanel();
		resourcesCounterView = getAccurateResourceCounter();
		root.add(resourcesCounterView);
		initRoot();
		initWidget(root);	
	}
	
	protected void initRoot() {
		gameZone = new GameZone<CardPanel>(constants.PLAYED_CARDS());
		root.add(gameZone);		
	}

	protected ResourcesCounterView getAccurateResourceCounter() {
		return new ResourcesCounterView(ResourceCounterType.OPPONENT);
	}
	
	public ResourcesCounterView getResourcesCounterView() {
		return resourcesCounterView;
	}

	public GameZone<CardPanel> getGameZone() {
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
