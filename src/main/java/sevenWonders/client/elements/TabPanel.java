package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class TabPanel extends Composite {
	
	private FlowPanel root;
	private SelectionPanel selectionPanel;
	private FlowPanel partsPanel;
	private boolean firstElement = true;

	public TabPanel() {
		root = new FlowPanel();
		
		selectionPanel = new SelectionPanel();
		selectionPanel.getElement().setAttribute("role", "tablist");
		partsPanel = new FlowPanel();
		partsPanel.getElement().setClassName("tab-content");
		root.add(selectionPanel);
		root.add(partsPanel);
		
		initWidget(root);
	}
	
	public FlowPanel addNewSelector(String title, String id) {
		selectionPanel.addListItem(title, id);
		FlowPanel elementToShow = new FlowPanel();
		elementToShow.getElement().setId(id);
		if (firstElement) {
			elementToShow.getElement().addClassName("tab-pane fade in");
			firstElement = false;
		} else {
			elementToShow.getElement().addClassName("tab-pane fade");
		}
		elementToShow.getElement().setAttribute("role", "tabpanel");
		partsPanel.add(elementToShow);
		return elementToShow;
	}
	
}
