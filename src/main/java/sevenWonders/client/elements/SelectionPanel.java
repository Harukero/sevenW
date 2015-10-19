package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class SelectionPanel extends Composite {
	
	private FlowPanel root;
	private ElementUl ul;
	
	public SelectionPanel() {
		
		root = new FlowPanel();
		
		ul = new ElementUl();
		ul.getElement().setClassName("nav nav-pills");
		
		root.add(ul);
		initWidget(root);
	}
	
	public void addListItem(String title, String id) {
		ElementLi item = new ElementLi();
		Anchor anchor = new Anchor(title);
		anchor.setHref("#"+id);
		anchor.getElement().setAttribute("aria-controls", id);
		anchor.getElement().setAttribute("role", "tab");
		anchor.getElement().setAttribute("data-toggle", "tab");
		item.add(anchor);
		ul.add(item);
	}
	
}
