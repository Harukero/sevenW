package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.constants.IStyleNames;

public class Badge extends Label {

	public Badge() {
		super();
		setStyleName(IStyleNames.BADGE);
	}
	
	public Badge(String text) {
		this();
		super.setText(text);
	}
}
