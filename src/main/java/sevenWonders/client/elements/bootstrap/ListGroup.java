package sevenWonders.client.elements.bootstrap;

import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.gameSpecific.GameZone;

public class ListGroup<X extends Widget> extends GameZone<X> {

	public ListGroup() {
		super();
		root.setStyleName(IStyleNames.LIST_GROUP);
		root.addStyleName(IStyleNames.DISPLAY_INLINE_TABLE);
	}

	public ListGroup(String title) {
		super(title);
		label.setStyleName(IStyleNames.LIST_GROUP_ITEM);
		label.addStyleName(IStyleNames.LIST_GROUP_ITEM_SUCCESS);
	}
	
	@Override
	public void addElement(X item) {
		super.addElement(item);
		item.addStyleName(IStyleNames.LIST_GROUP_ITEM);
	}
}
