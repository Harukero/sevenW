package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Button;

public class ModalOpenerButton extends Button {

	public ModalOpenerButton(String title, String modalId) {
		super(title);
		getElement().setClassName("btn btn-primary btn-lg");
		getElement().setAttribute("type", "button");
		getElement().setAttribute("data-toggle", "modal");
		getElement().setAttribute("data-target", "#"+modalId);
	}
	
}
