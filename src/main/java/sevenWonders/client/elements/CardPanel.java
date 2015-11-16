package sevenWonders.client.elements;

import java.util.Map.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.services.GameService;
import sevenWonders.client.utils.GameElementsToViewUtils;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.Resource;

public class CardPanel extends Composite {

	private FlowPanel root;
	private HandlerRegistration addDomHandler;
	private FlowPanel resourcesPanel;
	private Card card;

	public CardPanel(Card card) {
		this.card = card;
		root = new FlowPanel();
		root.add(new Label(card.getName(GameService.INSTANCE.getUiLanguage())));
		
		resourcesPanel = new FlowPanel();
		for (Entry<Resource, Integer> resourceCost : card.getCost().entrySet()) {
			Badge resourceBadge = new Badge(Integer.toString(resourceCost.getValue()));
			resourceBadge.addStyleName(GameElementsToViewUtils.resourceTypeToStyle(resourceCost.getKey()));
			resourcesPanel.add(resourceBadge);
			if (resourceCost.getValue() == 0) {
				resourceBadge.setVisible(false);
			}
		}
		
		root.add(resourcesPanel);
		initWidget(root);
	}

	public void addClickHandler(ClickHandler clickHandler) {
		if (addDomHandler != null) {
			addDomHandler.removeHandler();
		}
		addDomHandler = root.addDomHandler(clickHandler, ClickEvent.getType());
	}

	public Card getContainedCard() {
		return card;
	}
}
