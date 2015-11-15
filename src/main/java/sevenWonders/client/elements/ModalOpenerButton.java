package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Button;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;

public class ModalOpenerButton extends Button {

	public ModalOpenerButton(String title, String modalId) {
		super(title);
		getElement().setClassName(IStyleNames.BTN);
		getElement().addClassName(IStyleNames.BTN_PRIMARY);
		getElement().addClassName(IStyleNames.BTN_LG);
		getElement().setAttribute(IAttributeNames.ATT_TYPE, IAttributeNames.VAL_BUTTON);
		getElement().setAttribute(IAttributeNames.ATT_DATA_TOGGLE, IAttributeNames.VAL_MODAL);
		getElement().setAttribute(IAttributeNames.ATT_DATA_TARGET, "#"+modalId);
	}
	
}
