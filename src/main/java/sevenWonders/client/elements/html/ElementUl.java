package sevenWonders.client.elements.html;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class ElementUl extends ComplexPanel {
	public ElementUl() {
		setElement(Document.get().createULElement());
	}

	public void setId(String id) {
		// Set an attribute common to all tags
		getElement().setId(id);
	}

	public void setDir(String dir) {
		// Set an attribute specific to this tag
		((UListElement) getElement().cast()).setDir(dir);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void add(Widget w) {
		// ComplexPanel requires the two-arg add() method
		super.add(w, getElement());
	}
}
