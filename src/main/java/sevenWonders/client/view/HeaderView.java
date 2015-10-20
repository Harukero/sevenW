package sevenWonders.client.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IConstants;
import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.DropdownElement;
import sevenWonders.client.elements.ElementLitem;
import sevenWonders.client.elements.NavBar;
import sevenWonders.client.presenter.interfaces.IHeaderView;
import sevenWonders.client.presenter.interfaces.IHeaderView.IHeaderPresenter;

public class HeaderView extends ReverseCompositeView<IHeaderPresenter>implements IHeaderView {

	private FlowPanel root;
	private Anchor rulesButton;
	private Anchor startButton;
	private NavBar navBar;

	private static final Map<Anchor, String> cardsCategoryToJsonId = new HashMap<>();

	static {
		cardsCategoryToJsonId.put(new Anchor(IConstants.TITLE_RAW), IConstants.JSON_RAW);
		cardsCategoryToJsonId.put(new Anchor(IConstants.TITLE_MANUFACTURED), IConstants.JSON_MANUFACTURED);
		cardsCategoryToJsonId.put(new Anchor(IConstants.TITLE_CIVILIAN), IConstants.JSON_CIVILIAN);
		cardsCategoryToJsonId.put(new Anchor(IConstants.TITLE_SCIENCE), IConstants.JSON_SCIENCE);
		cardsCategoryToJsonId.put(new Anchor(IConstants.TITLE_COMMERCIAL), IConstants.JSON_COMMERCIAL);
		cardsCategoryToJsonId.put(new Anchor(IConstants.TITLE_MILITARY), IConstants.JSON_MILITARY);
		cardsCategoryToJsonId.put(new Anchor(IConstants.TITLE_GUILDS), IConstants.JSON_GUILDS);
	}

	public HeaderView() {

		root = new FlowPanel();
		navBar = new NavBar("SEVEN WONDERS", "MAIN_MENU");

		DropdownElement categoriesDropdown = new DropdownElement("idDropCategories", IConstants.RULES_PAGE);
		addEntriesToCategoriesDropdown(categoriesDropdown);
		navBar.addNavElement(categoriesDropdown);

		DropdownElement dropdownElement = new DropdownElement("idDrop", IConstants.NEW_GAME);

		ElementLitem listItemGame = new ElementLitem();
		startButton = new Anchor(IConstants.NEW_GAME);
		listItemGame.add(startButton);
		dropdownElement.addDropdownElement(listItemGame);

		navBar.addNavElement(dropdownElement);

		navBar.addStyleName(IStyleNames.MENU);
		root.add(navBar);
		bind();

		initWidget(root);
	}

	private void addEntriesToCategoriesDropdown(DropdownElement categoriesDropdown) {
		for (Entry<Anchor, String> anchorToJson : cardsCategoryToJsonId.entrySet()) {
			Anchor anchor = anchorToJson.getKey();
			final String json = anchorToJson.getValue();
			anchor.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					presenter.openRulesPage(json);
				}
			});
			ElementLitem listItem = new ElementLitem(anchor);
			categoriesDropdown.addDropdownElement(listItem);
		}
	}

	public void bind() {
		startButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.startNewGame();
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
