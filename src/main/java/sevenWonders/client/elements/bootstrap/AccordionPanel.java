package sevenWonders.client.elements.bootstrap;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.html.ElementA;
import sevenWonders.client.elements.html.ElementH;

public class AccordionPanel extends Composite {
	
	public AccordionPanel(String headingId, String title, FlowPanel body, boolean isFirst, String bodyId) {
		this(null, headingId, title, body, bodyId);
	}
	
	public AccordionPanel(String parentId, String headingId, String title, FlowPanel body, String bodyId) {
		FlowPanel panel = new FlowPanel(); // <div class="panel panel-default">
		panel.setStyleName(IStyleNames.PANEL);
		panel.setStyleName(IStyleNames.PANEL_DEFAULT);
		
		FlowPanel panelHeading = new FlowPanel(); // <div class="panel-heading" role="tab" id=bodyId>
		panelHeading.setStyleName(IStyleNames.PANEL_HEADING);
		panelHeading.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_TAB);
		panelHeading.getElement().setId(headingId);
		
		ElementA button = new ElementA(title); // <a role="button" data-toggle="collapse" data-parent=parentId href=#bodyid aria-expanded="true" aria-controls=bodyId>
		button.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_BUTTON);
		button.getElement().setAttribute(IAttributeNames.ATT_DATA_TOGGLE, IAttributeNames.VAL_COLLAPSE);
		if (parentId != null) {
			button.getElement().setAttribute(IAttributeNames.ATT_DATA_PARENT, "#"+parentId);
		}
		button.getElement().setAttribute(IAttributeNames.ATT_HREF, "#"+bodyId);
		button.getElement().setAttribute(IAttributeNames.ATT_ARIA_EXPANDED, IAttributeNames.VAL_FALSE);
		button.getElement().setAttribute(IAttributeNames.ATT_ARIA_CONTROLS, bodyId);
		ElementH panelTitle = new ElementH(4, button);
		panelTitle.setStyleName(IStyleNames.PANEL_TITLE);
		
		
		FlowPanel panelCollapse = new FlowPanel(); // <div id=bodyId class="panel-collapse collapse in" role="tabpanel" aria-labelledby=headingId>
		panelCollapse.getElement().setId(bodyId);
		panelCollapse.setStyleName(IStyleNames.PANEL_COLLAPSE);
		panelCollapse.setStyleName(IStyleNames.COLLAPSE);
		panelCollapse.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_TABPANEL);
		panelCollapse.getElement().setAttribute(IAttributeNames.ATT_ARIA_LABELLEDBY, headingId);
		
		if (!body.getElement().hasClassName(IStyleNames.PANEL_BODY)) {
			body.addStyleName(IStyleNames.PANEL_BODY);
		}

		panelHeading.add(panelTitle);
		panel.add(panelHeading);
		panelCollapse.add(body);
		panel.add(panelCollapse);
		initWidget(panel);

		
	}
}