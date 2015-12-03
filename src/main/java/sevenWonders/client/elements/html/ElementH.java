package sevenWonders.client.elements.html;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ElementH extends SimplePanel {
	public ElementH(int num) {
		super((Element) Document.get().createHElement(num).cast());
	}

	public ElementH(int num, String s) {
		this(num);
		getElement().setInnerText(s);
	}

	public ElementH(int num, Widget w) {
		this(num);
		this.add(w);
	}

}
