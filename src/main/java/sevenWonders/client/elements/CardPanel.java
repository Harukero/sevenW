package sevenWonders.client.elements;

import java.util.Map.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.services.GameService;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.Resource;

public class CardPanel extends Composite {

	private FlowPanel root;
	private HandlerRegistration addDomHandler;
	private FlowPanel resourcesPanel;

	public CardPanel(Card card) {
		root = new FlowPanel();
		root.add(new Label(card.getName(GameService.INSTANCE.getUiLanguage())));
		
		resourcesPanel = new FlowPanel();
		for (Entry<Resource, Integer> resourceCost : card.getCost().entrySet()) {
			Badge resourceBadge = new Badge(Integer.toString(resourceCost.getValue()));
			resourceBadge.addStyleName(resourceCost.getKey().getResourceStyle());
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

}
