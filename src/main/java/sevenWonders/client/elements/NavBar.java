package sevenWonders.client.elements;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.constants.IStyleNames;

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
		nav.getElement().setClassName(IStyleNames.NAVBAR);
		nav.getElement().addClassName(IStyleNames.NAVBAR_DEFAULT);
		if (brand != null) {
			addBrandElement(brand);
		}

		navbarCollapse = new FlowPanel();
		navbarCollapse.getElement().setClassName(IStyleNames.COLLAPSE);
		navbarCollapse.getElement().addClassName(IStyleNames.NAVBAR_COLLAPSE);
		navbarCollapse.getElement().setId(id);

		navbarNav = new ElementUl();
		navbarNav.getElement().setClassName(IStyleNames.NAV);
		navbarNav.getElement().addClassName(IStyleNames.NAVBAR_NAV);

		navbarCollapse.add(navbarNav);
		nav.add(navbarCollapse);

		initWidget(nav);
	}

	private void addBrandElement(String brand) {
		FlowPanel panel = new FlowPanel();
		panel.getElement().setClassName(IStyleNames.NAVBAR_HEADER);
		brandAnchor = new Anchor(brand);
		brandAnchor.getElement().setClassName(IStyleNames.NAVBAR_BRAND);

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
