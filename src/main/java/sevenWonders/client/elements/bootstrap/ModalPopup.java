package sevenWonders.client.elements.bootstrap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.html.ElementH;
import sevenWonders.client.internationalization.ViewConstants;

public class ModalPopup extends Composite {

	private FlowPanel root;
	private FlowPanel document;
	private FlowPanel content;
	private FlowPanel header;
	private FlowPanel body;
	private FlowPanel footer;
	
	public static interface IDialogCustomizer {
		void addElementsToFooter(FlowPanel footer);
		void setBody(FlowPanel body);
	}
	
	
	private static final ViewConstants constants = GWT.create(ViewConstants.class);
	
	private ModalPopup(String title, String modalId) {
		root = prepareRoot(modalId);
		
		document = new FlowPanel();
		document.getElement().setClassName(IStyleNames.MODAL_DIALOG);
		document.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_DOCUMENT);
		
		content = new FlowPanel();
		content.getElement().setClassName(IStyleNames.MODAL_CONTENT);
		
		header = prepareHeader(title);
		
		body = new FlowPanel();
		body.getElement().setClassName(IStyleNames.MODAL_BODY);
		
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
	
	public static ModalPopup createModalPopup(String title, String modalId, Widget widget) {
		ModalPopup popup = new ModalPopup(title, modalId);
		popup.setBody(widget);
		return popup;
	}

	private static FlowPanel prepareFooter() {
		FlowPanel footer = new FlowPanel();
		footer.getElement().setClassName(IStyleNames.MODAL_FOOTER);
		
		Button closeButton = new Button(constants.CLOSE());
		closeButton.getElement().setAttribute(IAttributeNames.ATT_TYPE, IAttributeNames.VAL_BUTTON);
		closeButton.getElement().setClassName(IStyleNames.BTN);
		closeButton.getElement().addClassName(IStyleNames.BTN_DEFAULT);
		closeButton.getElement().setAttribute(IAttributeNames.ATT_DATA_DISMISS, IAttributeNames.VAL_MODAL);

		footer.add(closeButton);
		
		return footer;
	}


	private static FlowPanel prepareHeader(String title) {
		FlowPanel header = new FlowPanel();
		header.getElement().setClassName(IStyleNames.MODAL_HEADER);

		Button closeButton = new Button("<span aria-hidden=\"true\">&times;</span>");
		closeButton.getElement().setAttribute(IAttributeNames.ATT_TYPE, IAttributeNames.VAL_BUTTON);
		closeButton.getElement().setAttribute(IAttributeNames.ATT_DATA_DISMISS, IAttributeNames.VAL_MODAL);
		closeButton.getElement().setAttribute(IAttributeNames.ATT_ARIA_LABEL, IAttributeNames.VAL_CLOSE);
		closeButton.getElement().setClassName(IStyleNames.CLOSE);
		header.add(closeButton);
		
		ElementH h4 = new ElementH(4, title);
		header.add(h4);

		return header;
	}

	private static FlowPanel prepareRoot(String modalId) {
		FlowPanel root = new FlowPanel();
		root.getElement().setClassName(IStyleNames.MODAL);
		root.getElement().addClassName(IStyleNames.FADE);
		root.getElement().setAttribute(IAttributeNames.ATT_ROLE, IAttributeNames.VAL_DIALOG);
		root.getElement().setId(modalId);
		return root;
	}
	
	 public static void openModalPopup(String title, String modalId, Widget widget) {
		final ModalPopup popup = createModalPopup(title, modalId, widget);
		RootPanel.get().add(popup);
		openModal(modalId);
	 }
	 
	 public static void openModalPopup(String title, String modalId, IDialogCustomizer customizer) {
		 final ModalPopup popup = new ModalPopup(title, modalId);
		 customizer.addElementsToFooter(popup.footer);
		 customizer.setBody(popup.body);
		 RootPanel.get().add(popup);
		 openModal(modalId);
	 }
	
	 
	 
	 private static native void openModal(String id) /*-{
		$wnd.$('#'+id).modal();
		$wnd.$('#'+id).on('hidden.bs.modal', function (e) {
			$wnd.$('#'+id).remove();
		});
	}-*/;
	 
	 public static native void close(String id) /*-{
		$wnd.$('#'+id).modal('hide');
	}-*/;


}
