package sevenWonders.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IConstants;
import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.DropdownElement;
import sevenWonders.client.elements.ElementLi;
import sevenWonders.client.elements.NavBar;
import sevenWonders.client.presenter.interfaces.IHeaderView;
import sevenWonders.client.presenter.interfaces.IHeaderView.IHeaderPresenter;

public class HeaderView extends ReverseCompositeView<IHeaderPresenter>implements IHeaderView {

	private FlowPanel root;
	private Anchor rulesButton;
	private Anchor startButton;
	private NavBar navBar;

	public HeaderView() {

		root = new FlowPanel();
		navBar = new NavBar("SEVEN WONDERS", "MAIN_MENU");
		ElementLi listItemGame = new ElementLi();
		startButton = new Anchor(IConstants.NEW_GAME);
		listItemGame.add(startButton);
		navBar.addNavElement(listItemGame);

		ElementLi listItemRules = new ElementLi();
		rulesButton = new Anchor(IConstants.RULES_PAGE);
		listItemRules.add(rulesButton);
		navBar.addNavElement(listItemRules);

		DropdownElement dropdownElement = new DropdownElement("idDrop", IConstants.NEW_GAME);
		dropdownElement.addDropdownElement(listItemGame);
		navBar.addNavElement(dropdownElement);

		navBar.addStyleName(IStyleNames.MENU);
		root.add(navBar);
		bind();

		initWidget(root);
	}

	public void bind() {
		startButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.startNewGame();
			}
		});
		rulesButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.openRulesPage();
			}
		});
		navBar.addBrandClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.openHomePage();
			}
		});
	}

}
