package sevenWonders.client.elements.bootstrap;

import com.google.gwt.user.client.ui.Button;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;

public class ModalOpenerButton extends Button {

	public ModalOpenerButton(String modalId) {
		super();
		getElement().setClassName(IStyleNames.BTN);
		getElement().addClassName(IStyleNames.BTN_PRIMARY);
		getElement().addClassName(IStyleNames.BTN_LG);
		getElement().setAttribute(IAttributeNames.ATT_TYPE, IAttributeNames.VAL_BUTTON);
		getElement().setAttribute(IAttributeNames.ATT_DATA_TOGGLE, IAttributeNames.VAL_MODAL);
		getElement().setAttribute(IAttributeNames.ATT_DATA_TARGET, "#"+modalId);
	}
	
	public ModalOpenerButton(String title, String modalId) {
		this(modalId);
		setText(title);
	}
	
}
