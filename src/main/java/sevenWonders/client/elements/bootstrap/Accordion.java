package sevenWonders.client.elements.bootstrap;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;

public class Accordion extends Composite {
	
	private FlowPanel panelGroup;
	private String id;
	
	public Accordion(String id) {
		this.id = id;
		panelGroup = new FlowPanel();
		panelGroup.getElement().setId(id);
		panelGroup.setStyleName(IStyleNames.PANEL_GROUP);
		panelGroup.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_TABLIST);
		panelGroup.getElement().setAttribute(IAttributeNames.ATT_ARIA_MULTISELECTABLE, IAttributeNames.VAL_TRUE);
		initWidget(panelGroup);
	}
	
	public void addPanel(FlowPanel panel,String titleId, String title, String panelId) {
		AccordionPanel accordionPanel = new AccordionPanel(id, titleId, title, panel, panelId);
		panelGroup.add(accordionPanel);
	}
	
}
