package sevenWonders.client.elements.bootstrap;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.constants.IStyleNames;

public class ListGroup<X extends Widget> extends Composite {

	private FlowPanel root = new FlowPanel();
	List<X> elements = new ArrayList<>();
	private Label label;

	public ListGroup() {
		root.getElement().setClassName(IStyleNames.LIST_GROUP);
		root.addStyleName(IStyleNames.DISPLAY_INLINE_TABLE);
		initWidget(root);
	}

	public ListGroup(String title) {
		this();
		label = new Label(title);
		label.getElement().setClassName(IStyleNames.LIST_GROUP_ITEM);
		label.getElement().addClassName(IStyleNames.LIST_GROUP_ITEM_SUCCESS);
		root.add(label);

	}

	public void addElement(X item) {
		item.getElement().addClassName(IStyleNames.LIST_GROUP_ITEM);
		root.add(item);
		elements.add(item);
	}

	public void removeElement(X item) {
		root.remove(item);
		elements.remove(item);
	}

	public void clear() {
		root.clear();
		elements.clear();
		if (label != null) {
			root.add(label);
		}
	}

	public List<X> getElements() {
		return elements;
	}
}
