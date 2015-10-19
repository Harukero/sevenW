package sevenWonders.client.elements;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class ElementNav extends ComplexPanel {

	@SuppressWarnings("deprecation")
	public ElementNav() {
		setElement(DOM.createElement("nav"));
	}

	@Override
	@SuppressWarnings("deprecation")
	public void add(Widget w) {
		// ComplexPanel requires the two-arg add() method
		super.add(w, getElement());
	}

}
