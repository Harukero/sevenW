package sevenWonders.client.elements;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;

public class ElementSpan extends SimplePanel {

	public ElementSpan(String s) {
		super((Element) Document.get().createSpanElement().cast());
		getElement().setInnerText(s);
	}

	public ElementSpan() {
		this("");
	}
}
