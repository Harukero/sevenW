package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;

public class SelectionPanel extends Composite {
	
	private FlowPanel root;
	private ElementUl ul;
	
	public SelectionPanel() {
		
		root = new FlowPanel();
		
		ul = new ElementUl();
		ul.getElement().setClassName(IStyleNames.NAV);
		ul.getElement().addClassName(IStyleNames.NAV_PILLS);
		
		root.add(ul);
		initWidget(root);
	}
	
	public void addListItem(String title, String id) {
		ElementLitem item = new ElementLitem();
		Anchor anchor = new Anchor(title);
		anchor.setHref("#"+id);
		anchor.getElement().setAttribute(IAttributeNames.ATT_ARIA_CONTROLS, id);
		anchor.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_TAB);
		anchor.getElement().setAttribute(IAttributeNames.ATT_DATA_TOGGLE, IAttributeNames.VAL_TAB);
		item.add(anchor);
		ul.add(item);
	}
	
}
