package sevenWonders.client.elements.html;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class ElementLitem extends ComplexPanel {
	public ElementLitem() {
		setElement((Element) Document.get().createLIElement().cast());
	}

	public ElementLitem(String s) {
		this();
		getElement().setInnerText(s);
	}

	public ElementLitem(Widget w) {
		this();
		this.add(w);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void add(Widget w) {
		// ComplexPanel requires the two-arg add() method
		super.add(w, getElement());
	}
}