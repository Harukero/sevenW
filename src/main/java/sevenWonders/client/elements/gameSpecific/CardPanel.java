package sevenWonders.client.elements.gameSpecific;

import java.util.Map.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.bootstrap.Badge;
import sevenWonders.client.services.GameService;
import sevenWonders.client.utils.GameElementsToViewUtils;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.Resource;
import sevenWonders.core.gameElements.effects.IsAnEffect;

public class CardPanel extends Composite {

	private FlowPanel root;
	private HandlerRegistration addDomHandler;
	private FlowPanel resourcesPanel;
	private FlowPanel capacitiesPanel;
	private Card card;

	public CardPanel(Card card) {
		this.card = card;
		root = new FlowPanel();
		Label cardTitle = new Label(card.getName(GameService.INSTANCE.getUiLanguage()));
		cardTitle.setStyleName(IStyleNames.CARD_TITLE);
		root.add(cardTitle);
		root.addStyleName(IStyleNames.CARD_PANEL);
		root.addStyleName(GameElementsToViewUtils.cardTypeToStyleName(card.getType()));
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
		
		capacitiesPanel = new FlowPanel();
		for (IsAnEffect effect : card.getEffects()) {
			capacitiesPanel.add(new Label(effect.asString()));
		}
		
		root.add(capacitiesPanel);
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
