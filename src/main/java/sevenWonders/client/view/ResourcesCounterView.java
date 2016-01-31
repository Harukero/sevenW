package sevenWonders.client.view;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.bootstrap.Badge;
import sevenWonders.client.elements.html.ElementA;
import sevenWonders.client.elements.html.ElementLitem;
import sevenWonders.client.elements.html.ElementUl;
import sevenWonders.client.utils.GameElementsToViewUtils;
import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Resource;

public class ResourcesCounterView extends Composite {

	private ElementUl root;
	private Map<Resource, Integer> resources = new HashMap<>();
	private Map<Resource, Label> resourceToLabel = new HashMap<Resource, Label>();
	private Map<Resource, ElementLitem> resourceToListItem = new HashMap<Resource, ElementLitem>();

	private ElementA wonderName;

	public ResourcesCounterView() {
		root = new ElementUl();
		root.setStyleName(IStyleNames.NAV);
		root.addStyleName(IStyleNames.NAV_PILLS);
		root.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_TABLIST);
		root.addStyleName(IStyleNames.FLEX_CONTAINER_CENTER);

		buildPlayerResourceGrid();

		initWidget(root);
	}

	private void buildPlayerResourceGrid() {
		root.add(initName());
		initResources();
	}

	private ElementLitem initName() {
		wonderName = new ElementA();
		ElementLitem li = new ElementLitem(wonderName);
		li.setStyleName(IStyleNames.PRESENTATION);
		return li;

	}

	private void initResources() {
		Resource[] values = Resource.values();
		for (Resource r : values) {
			resources.put(r, 1);
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
		resourceToListItem.put(r, li);
		return li;
	}
	
	public void updateView(Board board) {
		wonderName.getElement().setInnerText(board.getWonder().getName());
		Map<Resource, Integer> firstResourceMap = board.getResources().get(0);
		Resource wonderResource = board.getWonder().getStartResource();
		Resource[] values = Resource.values();
		for (Resource r : values) {
			if (r != Resource.MONEY && r != wonderResource) {
				ElementLitem elementLitem = resourceToListItem.get(r);
				elementLitem.setVisible(false);
			} else if (r == Resource.MONEY) {
				resourceToLabel.get(r).setText(Integer.toString(firstResourceMap.get(r)));
			} else {
				ElementLitem elementLitem = resourceToListItem.get(r);
				elementLitem.setVisible(true);
			}
		}
	}

}
