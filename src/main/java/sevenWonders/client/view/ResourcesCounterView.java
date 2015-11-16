package sevenWonders.client.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.constants.Iid;
import sevenWonders.client.elements.Badge;
import sevenWonders.client.elements.ElementA;
import sevenWonders.client.elements.ElementLitem;
import sevenWonders.client.elements.ElementUl;
import sevenWonders.client.elements.ModalOpenerButton;
import sevenWonders.client.elements.ModalPopup;
import sevenWonders.client.internationalization.ViewConstants;
import sevenWonders.client.utils.GameElementsToViewUtils;
import sevenWonders.core.gameElements.Resource;

public class ResourcesCounterView extends Composite {

	public enum ResourceCounterType {
		MAIN_PLAYER, OPPONENT
	}

	private ElementUl root;
	private Map<Resource, Integer> resources = new HashMap<>();
	private Map<Resource, Label> resourceToLabel = new HashMap<Resource, Label>();

	private static final ViewConstants constants = GWT.create(ViewConstants.class);
	
	public ResourcesCounterView(ResourceCounterType type) {
		root = new ElementUl();
		root.setStyleName("nav");
		root.addStyleName("nav-pills");
		root.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_TABLIST);

		if (type == ResourceCounterType.MAIN_PLAYER) {
			buildPlayerResourceGrid();
		} else {
			buildOpponentResourceGrid();
		}

		initWidget(root);
	}

	private void buildPlayerResourceGrid() {
		ModalPopup popupLeftPlayer = ModalPopup.openModalPopup(constants.LEFT_PLAYER_BOARD(), Iid.ResourcesCounterView_ModalLeft,
				new Label(constants.LEFT_PLAYER_BOARD()));
		root.add(popupLeftPlayer);
		ModalPopup popupRightPlayer = ModalPopup.openModalPopup(constants.RIGHT_PLAYER_BOARD(), Iid.ResourcesCounterView_ModalRight,
				new Label(constants.RIGHT_PLAYER_BOARD()));
		root.add(popupRightPlayer);

		ModalOpenerButton leftPlayerBoardButton = new ModalOpenerButton("", Iid.ResourcesCounterView_ModalLeft);
		leftPlayerBoardButton.setText(constants.LEFT_PLAYER_BOARD());
		
		ElementLitem leftItem = new ElementLitem(leftPlayerBoardButton);
		leftItem.setStyleName(IStyleNames.PRESENTATION);
		
		root.add(leftItem);
		

		initResources();
		ModalOpenerButton rightPlayerBoardButton = new ModalOpenerButton("", Iid.ResourcesCounterView_ModalRight);
		rightPlayerBoardButton.setText(constants.RIGHT_PLAYER_BOARD());
		
		ElementLitem rightItem = new ElementLitem(rightPlayerBoardButton);
		rightItem.setStyleName(IStyleNames.PRESENTATION);
		
		root.add(rightItem);
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
