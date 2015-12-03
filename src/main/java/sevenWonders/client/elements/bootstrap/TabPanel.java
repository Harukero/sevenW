package sevenWonders.client.elements.bootstrap;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;

public class TabPanel extends Composite {
	
	private FlowPanel root;
	private SelectionPanel selectionPanel;
	private FlowPanel partsPanel;
	private boolean firstElement = true;

	public TabPanel() {
		root = new FlowPanel();
		
		selectionPanel = new SelectionPanel();
		selectionPanel.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_TABLIST);
		partsPanel = new FlowPanel();
		partsPanel.getElement().setClassName(IStyleNames.TAB_CONTENT);
		root.add(selectionPanel);
		root.add(partsPanel);
		
		initWidget(root);
	}
	
	public FlowPanel addNewSelector(String title, String id) {
		selectionPanel.addListItem(title, id);
		FlowPanel elementToShow = new FlowPanel();
		elementToShow.getElement().setId(id);
		if (firstElement) {
			elementToShow.getElement().addClassName(IStyleNames.IN);
			firstElement = false;
		}
		elementToShow.getElement().addClassName(IStyleNames.TAB_PANE);
		elementToShow.getElement().addClassName(IStyleNames.FADE);
		elementToShow.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_TABPANEL);
		partsPanel.add(elementToShow);
		return elementToShow;
	}
	
}
