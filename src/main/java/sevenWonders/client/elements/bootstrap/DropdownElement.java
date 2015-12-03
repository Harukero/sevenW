package sevenWonders.client.elements.bootstrap;

import com.google.gwt.user.client.ui.Composite;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.html.ElementA;
import sevenWonders.client.elements.html.ElementLitem;
import sevenWonders.client.elements.html.ElementSpan;
import sevenWonders.client.elements.html.ElementUl;

public class DropdownElement extends Composite {

	private ElementLitem root;
	private ElementUl unorderedList;
	private String id;

	public DropdownElement(String id, String label) {
		this.id = id;
		root = new ElementLitem();
		root.getElement().setClassName(IStyleNames.DROPDOWN);

		ElementA a = new ElementA(label);
		a.getElement().setId(id);
		a.getElement().setAttribute(IAttributeNames.ATT_DATA_TOGGLE, IAttributeNames.VAL_DROPDOWN);
		a.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_BUTTON);
		a.getElement().setAttribute(IAttributeNames.ATT_ARIA_HASPOPUP, IAttributeNames.VAL_TRUE);
		a.getElement().setAttribute(IAttributeNames.ATT_ARIA_EXPANDED, IAttributeNames.VAL_FALSE);

		ElementSpan span = new ElementSpan();
		span.getElement().setClassName(IStyleNames.CARET);
		a.add(span);
		root.add(a);

		initWidget(root);
	}

	public void addDropdownElement(ElementLitem element) {
		if (unorderedList == null) {
			unorderedList = new ElementUl();
			unorderedList.getElement().setClassName(IStyleNames.DROPDOWN_MENU);
			unorderedList.getElement().setAttribute(IAttributeNames.ATT_ARIA_LABELLEDBY, id);
			root.add(unorderedList);
		}
		unorderedList.add(element);
	}

}
