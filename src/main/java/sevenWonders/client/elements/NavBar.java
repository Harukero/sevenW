package sevenWonders.client.elements;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class NavBar extends Composite {

	private ElementNav nav;
	private FlowPanel navbarCollapse;
	private ElementUl navbarNav;
	private Anchor brandAnchor;
	private HandlerRegistration brandHandler;

	public NavBar(String id) {
		this(null, id);
	}

	public NavBar(String brand, String id) {
		nav = new ElementNav();
		nav.getElement().setClassName("navbar navbar-default");
		if (brand != null) {
			addBrandElement(brand);
		}

		// <div class="collapse navbar-collapse"
		// id="bs-example-navbar-collapse-1">
		navbarCollapse = new FlowPanel();
		navbarCollapse.getElement().setClassName("collapse navbar-collapse");
		navbarCollapse.getElement().setId(id);
		// <ul class="nav navbar-nav">

		navbarNav = new ElementUl();
		navbarNav.getElement().setClassName("nav navbar-nav");

		navbarCollapse.add(navbarNav);
		nav.add(navbarCollapse);

		initWidget(nav);
	}

	private void addBrandElement(String brand) {
		FlowPanel panel = new FlowPanel();
		panel.getElement().setClassName("navbar-header");
		brandAnchor = new Anchor(brand);
		brandAnchor.getElement().setClassName("navbar-brand");

		panel.add(brandAnchor);
		nav.add(panel);
	}

	public void addNavElement(Widget widget) {
		navbarNav.add(widget);
	}

	public void addBrandClickHandler(ClickHandler handler) {
		if (brandAnchor != null) {
			if (brandHandler != null) {
				brandHandler.removeHandler();
			}
			brandHandler = brandAnchor.addClickHandler(handler);
		}
	}

}
