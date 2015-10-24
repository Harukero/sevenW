package sevenWonders.client.elements;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.constants.IStyleNames;

public class ListGroup extends Composite {

	private FlowPanel root = new FlowPanel();
	List<Widget> elements = new ArrayList<>();
	private Label label;

	public ListGroup() {
		root.getElement().setClassName("list-group");
		root.addStyleName(IStyleNames.DISPLAY_INLINE_TABLE);
		initWidget(root);
	}

	public ListGroup(String title) {
		this();
		label = new Label(title);
		label.getElement().setClassName("list-group-item");
		label.getElement().addClassName("list-group-item-success");
		root.add(label);

	}

	public void addElement(Widget item) {
		item.getElement().addClassName("list-group-item");
		root.add(item);
		elements.add(item);
	}

	public void removeElement(Widget item) {
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

	public List<Widget> getElements() {
		return elements;
	}
}
