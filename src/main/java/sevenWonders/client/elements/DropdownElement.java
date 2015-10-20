package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Composite;

public class DropdownElement extends Composite {

	private ElementLitem root;
	private ElementUl unorderedList;
	private String id;

	public DropdownElement(String id, String label) {
		this.id = id;
		root = new ElementLitem();
		root.getElement().setClassName("dropdown");

		ElementA a = new ElementA(label);
		a.getElement().setId(id);
		a.getElement().setAttribute("data-toggle", "dropdown");
		a.getElement().setAttribute("role", "button");
		a.getElement().setAttribute("aria-haspopup", "true");
		a.getElement().setAttribute("aria-expanded", "false");

		ElementSpan span = new ElementSpan();
		span.getElement().setClassName("caret");
		a.add(span);
		root.add(a);

		initWidget(root);
	}

	public void addDropdownElement(ElementLitem element) {
		if (unorderedList == null) {
			unorderedList = new ElementUl();
			unorderedList.getElement().setClassName("dropdown-menu");
			unorderedList.getElement().setAttribute("aria-labelledby", id);
			root.add(unorderedList);
		}
		unorderedList.add(element);
	}

}
