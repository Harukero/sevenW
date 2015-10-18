package sevenWonders.client.elements;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class HElement extends SimplePanel {
	public HElement(int num) {
		super((Element) Document.get().createHElement(num).cast());
	}

	public HElement(int num, String s) {
		this(num);
		getElement().setInnerText(s);
	}

	public HElement(int num, Widget w) {
		this(num);
		this.add(w);
	}

}
