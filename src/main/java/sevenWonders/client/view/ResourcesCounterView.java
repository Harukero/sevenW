package sevenWonders.client.view;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.elements.ModalOpenerButton;
import sevenWonders.client.elements.ModalPopup;
import sevenWonders.core.gameElements.Resource;

public class ResourcesCounterView extends Composite {

	public enum ResourceCounterType {
		MAIN_PLAYER, OPPONENT
	}

	private FlowPanel root;
	private Grid resourcesToCounts;
	private Map<Resource, Integer> resources = new HashMap<>();

	public ResourcesCounterView(ResourceCounterType type) {
		root = new FlowPanel();

		if (type == ResourceCounterType.MAIN_PLAYER) {
			buildPlayerResourceGrid();
		} else {
			buildOpponentResourceGrid();
		}

		root.add(resourcesToCounts);

		initWidget(root);
	}

	private void buildPlayerResourceGrid() {
		resourcesToCounts = new Grid(2, 10);
		ModalPopup popupLeftPlayer = ModalPopup.openModalPopup("Left Player Board", "ID_MODAL_LEFT",
				new Label("Board pour le joueur de gauche"));
		root.add(popupLeftPlayer);
		ModalPopup popupRightPlayer = ModalPopup.openModalPopup("Right Player Board", "ID_MODAL_RIGHT",
				new Label("Board pour le joueur de droite"));
		root.add(popupRightPlayer);

		ModalOpenerButton leftPlayerBoardButton = new ModalOpenerButton("", "ID_MODAL_LEFT");
		leftPlayerBoardButton.setText("Left Player Board");
		resourcesToCounts.setWidget(0, 0, leftPlayerBoardButton);

		ModalOpenerButton rightPlayerBoardButton = new ModalOpenerButton("", "ID_MODAL_RIGHT");
		rightPlayerBoardButton.setText("Right Player Board");
		resourcesToCounts.setWidget(0, 9, rightPlayerBoardButton);

		Resource[] values = Resource.values();
		for (int i = 0; i < values.length; i++) {
			Resource r = values[i];
			resourcesToCounts.setWidget(0, i + 1, new Image(r.getImagePath()));
			resources.put(r, 0);
			resourcesToCounts.setWidget(1, i + 1, new Label(String.valueOf(resources.get(r))));
		}
		resourcesToCounts.getElement().setClassName("table table-bordered");
	}

	private void buildOpponentResourceGrid() {
		resourcesToCounts = new Grid(2, 8);
		Resource[] values = Resource.values();
		for (int i = 0; i < values.length; i++) {
			Resource r = values[i];
			resourcesToCounts.setWidget(0, i, new Image(r.getImagePath()));
			resources.put(r, 0);
			resourcesToCounts.setWidget(1, i, new Label(String.valueOf(resources.get(r))));
		}
		resourcesToCounts.getElement().setClassName("table table-bordered");

	}

}
