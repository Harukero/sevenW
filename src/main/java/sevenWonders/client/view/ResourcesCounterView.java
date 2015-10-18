package sevenWonders.client.view;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.core.gameElements.Resource;

public class ResourcesCounterView extends Composite {

	private FlowPanel root;
	private Grid resourcesToCounts;
	private Map<Resource, Integer> resources = new HashMap<>();
	
	public ResourcesCounterView() {
		root = new FlowPanel();
		resourcesToCounts = new Grid(2, 8);
		
		root.add(resourcesToCounts);
		Resource[] values = Resource.values();
		for (int i = 0; i < values.length; i++) {
			Resource r = values[i];
			resourcesToCounts.setWidget(0, i, new Image(r.getImagePath()));
			resources.put(r, 0);
			resourcesToCounts.setWidget(1, i, new Label(String.valueOf(resources.get(r))));
		}
		resourcesToCounts.getElement().setClassName("table table-bordered");
		initWidget(root);
	}	
	
}
