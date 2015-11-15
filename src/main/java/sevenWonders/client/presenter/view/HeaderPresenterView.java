package sevenWonders.client.presenter.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IConstants;
import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.constants.Iid;
import sevenWonders.client.elements.DropdownElement;
import sevenWonders.client.elements.ElementLitem;
import sevenWonders.client.elements.NavBar;
import sevenWonders.client.internationalization.ViewConstants;
import sevenWonders.client.presenter.interfaces.IHeaderView;
import sevenWonders.client.presenter.interfaces.IHeaderView.IHeaderPresenter;
import sevenWonders.client.view.ReverseCompositeView;

public class HeaderPresenterView extends ReverseCompositeView<IHeaderPresenter> implements IHeaderView {

	private FlowPanel root;
	private NavBar navBar;
	private static ViewConstants constants = GWT.create(ViewConstants.class);

	private static final Map<Anchor, String> cardsCategoryToJsonId = new HashMap<>();

	static {
		cardsCategoryToJsonId.put(new Anchor(constants.TITLE_RAW()), IConstants.JSON_CATEGORY_RAW);
		cardsCategoryToJsonId.put(new Anchor(constants.TITLE_MANUFACTURED()), IConstants.JSON_CATEGORY_MANUFACTURED);
		cardsCategoryToJsonId.put(new Anchor(constants.TITLE_CIVILIAN()), IConstants.JSON_CATEGORY_CIVILIAN);
		cardsCategoryToJsonId.put(new Anchor(constants.TITLE_SCIENCE()), IConstants.JSON_CATEGORY_SCIENCE);
		cardsCategoryToJsonId.put(new Anchor(constants.TITLE_COMMERCIAL()), IConstants.JSON_CATEGORY_COMMERCIAL);
		cardsCategoryToJsonId.put(new Anchor(constants.TITLE_MILITARY()), IConstants.JSON_CATEGORY_MILITARY);
		cardsCategoryToJsonId.put(new Anchor(constants.TITLE_GUILDS()), IConstants.JSON_CATEGORY_GUILDS);
	}

	private static final Map<Anchor, Integer> gameTypeToNumberOfPlayers = new HashMap<>();

	static {
		gameTypeToNumberOfPlayers.put(new Anchor(constants.THREE_PLAYER_GAME()), Integer.valueOf(3));
		gameTypeToNumberOfPlayers.put(new Anchor(constants.FOUR_PLAYER_GAME()), Integer.valueOf(4));
		gameTypeToNumberOfPlayers.put(new Anchor(constants.FIVE_PLAYER_GAME()), Integer.valueOf(5));
		gameTypeToNumberOfPlayers.put(new Anchor(constants.SIX_PLAYER_GAME()), Integer.valueOf(6));
		gameTypeToNumberOfPlayers.put(new Anchor(constants.SEVEN_PLAYER_GAME()), Integer.valueOf(7));
	}

	public HeaderPresenterView() {

		root = new FlowPanel();
		navBar = new NavBar(IConstants.GAME_NAME, Iid.HeaderPresenterView_MainMenu);

		DropdownElement categoriesDropdown = new DropdownElement(Iid.HeaderPresenterView_DropdownRulesPageCategories, constants.RULES_PAGE());
		addEntriesToCategoriesDropdown(categoriesDropdown);
		navBar.addNavElement(categoriesDropdown);

		DropdownElement dropdownElement = new DropdownElement(Iid.HeaderPresenterView_DropdownNewGame, constants.NEW_GAME());
		addEntriesToGameTypeDropdown(dropdownElement);
		navBar.addNavElement(dropdownElement);

		navBar.addStyleName(IStyleNames.MENU);
		root.add(navBar);
		bind();

		initWidget(root);
	}

	private void addEntriesToGameTypeDropdown(DropdownElement gameDropdown) {
		for (Entry<Anchor, Integer> anchorToJson : gameTypeToNumberOfPlayers.entrySet()) {
			Anchor anchor = anchorToJson.getKey();
			final Integer nbPlayer = anchorToJson.getValue();
			anchor.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					presenter.startNewGame(nbPlayer);
				}
			});
			ElementLitem listItem = new ElementLitem(anchor);
			gameDropdown.addDropdownElement(listItem);
		}

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
		navBar.addBrandClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.openHomePage();
			}
		});
	}

}
