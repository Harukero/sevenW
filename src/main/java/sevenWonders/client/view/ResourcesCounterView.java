package sevenWonders.client.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.bootstrap.Badge;
import sevenWonders.client.elements.html.ElementA;
import sevenWonders.client.elements.html.ElementLitem;
import sevenWonders.client.elements.html.ElementUl;
import sevenWonders.client.utils.GameElementsToViewUtils;
import sevenWonders.core.gameElements.Resource;

public class ResourcesCounterView extends Composite {

	public enum ResourceCounterType {
		MAIN_PLAYER, OPPONENT
	}

	private ElementUl root;
	private Map<Resource, Integer> resources = new HashMap<>();
	private Map<Resource, Label> resourceToLabel = new HashMap<Resource, Label>();

	public ResourcesCounterView(ResourceCounterType type) {
		root = new ElementUl();
		root.setStyleName(IStyleNames.NAV);
		root.addStyleName(IStyleNames.NAV_PILLS);
		root.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_TABLIST);

		if (type == ResourceCounterType.MAIN_PLAYER) {
			buildPlayerResourceGrid();
		} else {
			buildOpponentResourceGrid();
		}

		initWidget(root);
	}

	private void buildPlayerResourceGrid() {
		initResources();
	}

	private void initResources() {
		Resource[] values = Resource.values();
		for (Resource r : values) {
			resources.put(r, 0);
			ElementLitem li = createResourceCounterFor(r);
			root.add(li);
		}
	}

	private ElementLitem createResourceCounterFor(Resource r) {
		Badge label = new Badge(String.valueOf(resources.get(r)));
		label.addStyleName(GameElementsToViewUtils.resourceTypeToStyle(r));
		resourceToLabel.put(r, label);
		ElementA anchor = new ElementA(GameElementsToViewUtils.resourceI18nName(r));
		anchor.add(label);
		ElementLitem li = new ElementLitem(anchor);
		li.setStyleName(IStyleNames.PRESENTATION);
		return li;
	}

	private void buildOpponentResourceGrid() {
		initResources();
	}
	
	public void updateView(Map<Resource, Integer> newValues) {
		for (Entry<Resource, Integer> newResources : newValues.entrySet()) {
			resources.put(newResources.getKey(), newResources.getValue());
			resourceToLabel.get(newResources.getKey()).setText(String.valueOf(newResources.getValue()));
		}
	}

}
