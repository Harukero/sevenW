package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ListGroup extends Composite {

	private FlowPanel root = new FlowPanel();

	public ListGroup() {
		root.getElement().setClassName("list-group");
		initWidget(root);
	}

	public void addElement(Widget item) {
		item.getElement().addClassName("list-group-item");
		root.add(item);
	}

	public void removeElement(Widget item) {
		root.remove(item);
	}

	public void clear() {
		root.clear();
	}
}
