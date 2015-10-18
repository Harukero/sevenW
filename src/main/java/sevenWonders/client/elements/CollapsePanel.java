package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class CollapsePanel extends Composite{

	
	
	private FlowPanel root = new FlowPanel();
	private FlowPanel header;
	private FlowPanel body;
	
	public CollapsePanel(String headerLabel, String bodyId) {
		header = buildHeader(headerLabel, bodyId);
		body = prepareBody(bodyId);
		
		root.add(header);

		root.add(body);
		
		initWidget(root);
	}

	public void setBody(Widget body) {
		this.body.clear();
		this.body.add(body);
	}
	
	private static FlowPanel prepareBody(String bodyId) {
		FlowPanel body = new FlowPanel();
		body.getElement().setClassName("collapse");
		body.getElement().setId(bodyId);
		return body;
	}

	private static FlowPanel buildHeader(String headerLabel, String bodyId) {
		FlowPanel header = new FlowPanel();
		Button button = new Button();
		button.setText(headerLabel);
		button.getElement().setClassName("btn btn-primary");
		button.getElement().setAttribute("data-toggle", "collapse");
		button.getElement().setAttribute("data-target", "#"+bodyId);
		button.getElement().setAttribute("aria-expanded", "false");
		button.getElement().setAttribute("aria-controls", bodyId);
		header.add(button);
		return header;
	}
	
}
