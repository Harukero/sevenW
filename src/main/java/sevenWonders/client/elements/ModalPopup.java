package sevenWonders.client.elements;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ModalPopup extends Composite {

	private FlowPanel root;
	private FlowPanel document;
	private FlowPanel content;
	private FlowPanel header;
	private FlowPanel body;
	private FlowPanel footer;
	
	private ModalPopup(String title, String modalId) {
		root = prepareRoot(modalId);
		
		document = new FlowPanel();
		document.getElement().setClassName("modal-dialog");
		document.getElement().setAttribute("role", "document");
		
		content = new FlowPanel();
		content.getElement().setClassName("modal-content");
		
		header = prepareHeader(title);
		
		body = new FlowPanel();
		body.getElement().setClassName("modal-body");
		
		footer = prepareFooter();
		
		content.add(header);
		content.add(body);
		content.add(footer);
		document.add(content);
		root.add(document);
		initWidget(root);
	}

	private void setBody(Widget widget) {
		body.clear();
		body.add(widget);
	}
	
	public static ModalPopup openModalPopup(String title, String modalId, Widget widget) {
		ModalPopup popup = new ModalPopup(title, modalId);
		popup.setBody(widget);
		return popup;
	}

	private static FlowPanel prepareFooter() {
		FlowPanel footer = new FlowPanel();
		footer.getElement().setClassName("modal-footer");
		
		Button closeButton = new Button("Close");
		closeButton.getElement().setAttribute("type", "button");
		closeButton.getElement().setClassName("btn btn-default");
		closeButton.getElement().setAttribute("data-dismiss", "modal");

		footer.add(closeButton);
		
		return footer;
	}


	private static FlowPanel prepareHeader(String title) {
		FlowPanel header = new FlowPanel();
		header.getElement().setClassName("modal-header");

		Button closeButton = new Button("<span aria-hidden=\"true\">&times;</span>");
		closeButton.getElement().setAttribute("type", "button");
		closeButton.getElement().setAttribute("data-dismiss", "modal");
		closeButton.getElement().setAttribute("aria-label", "close");
		closeButton.getElement().setClassName("close");
		header.add(closeButton);
		
		ElementH h4 = new ElementH(4, title);
		header.add(h4);

		return header;
	}

	private static FlowPanel prepareRoot(String modalId) {
		FlowPanel root = new FlowPanel();
		root.getElement().setClassName("modal fade");
		root.getElement().setAttribute("role", "dialog");
		root.getElement().setId(modalId);
		return root;
	}
	
}
