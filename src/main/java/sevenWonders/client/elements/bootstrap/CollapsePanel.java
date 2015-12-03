package sevenWonders.client.elements.bootstrap;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;

public class CollapsePanel extends Composite{
	
	private FlowPanel root = new FlowPanel();
	private FlowPanel header;
	private FlowPanel body;
	
	public CollapsePanel(String headerLabel, String bodyId) {
		header = buildHeader(headerLabel, bodyId);
		body = createEmptyBody(bodyId);
		
		root.add(header);
		root.add(body);
		
		initWidget(root);
	}

	public void setBody(Widget body) {
		this.body.clear();
		this.body.add(body);
	}
	
	private static FlowPanel createEmptyBody(String bodyId) {
		FlowPanel body = new FlowPanel();
		body.getElement().setClassName(IStyleNames.COLLAPSE);
		body.getElement().setId(bodyId);
		return body;
	}

	private static FlowPanel buildHeader(String headerLabel, String bodyId) {
		FlowPanel header = new FlowPanel();
		Button button = new Button();
		button.setText(headerLabel);
		button.getElement().setClassName(IStyleNames.BTN);
		button.getElement().addClassName(IStyleNames.BTN_PRIMARY);
		button.getElement().setAttribute(IAttributeNames.ATT_DATA_TOGGLE, IAttributeNames.VAL_COLLAPSE);
		button.getElement().setAttribute(IAttributeNames.ATT_DATA_TARGET, "#"+bodyId);
		button.getElement().setAttribute(IAttributeNames.ATT_ARIA_EXPANDED, IAttributeNames.VAL_FALSE);
		button.getElement().setAttribute(IAttributeNames.ATT_ARIA_CONTROLS, bodyId);
		header.add(button);
		return header;
	}
	
}
