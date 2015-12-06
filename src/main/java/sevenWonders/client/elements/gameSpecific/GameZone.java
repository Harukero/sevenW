package sevenWonders.client.elements.gameSpecific;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class GameZone<X extends Widget> extends Composite{

	protected FlowPanel root = new FlowPanel();
	protected Label label;
	private List<X> elements = new ArrayList<>();

	public GameZone() {
		initWidget(root);
	}

	public GameZone(String title) {
		this();
		label = new Label(title);
		root.add(label);
	}

	public void addElement(X item) {
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
