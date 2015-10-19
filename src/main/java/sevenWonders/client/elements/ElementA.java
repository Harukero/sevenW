package sevenWonders.client.elements;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ElementA extends SimplePanel {

	public ElementA() {
		super((Element) Document.get().createAnchorElement().cast());
	}

	public ElementA(String s) {
		this();
		getElement().setInnerText(s);
	}

	public ElementA(Widget w) {
		this();
		this.add(w);
	}
}
