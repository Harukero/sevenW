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

	private static final Map<Anchor, Integer> gameTypeToNumberOfPlayers = new HashMap<>();

	static {
		gameTypeToNumberOfPlayers.put(new Anchor(IConstants.THREE_PLAYER_GAME), Integer.valueOf(3));
		gameTypeToNumberOfPlayers.put(new Anchor(IConstants.FOUR_PLAYER_GAME), Integer.valueOf(4));
		gameTypeToNumberOfPlayers.put(new Anchor(IConstants.FIVE_PLAYER_GAME), Integer.valueOf(5));
		gameTypeToNumberOfPlayers.put(new Anchor(IConstants.SIX_PLAYER_GAME), Integer.valueOf(6));
		gameTypeToNumberOfPlayers.put(new Anchor(IConstants.SEVEN_PLAYER_GAME), Integer.valueOf(7));
	}

	public HeaderView() {

		root = new FlowPanel();
		navBar = new NavBar("SEVEN WONDERS", "MAIN_MENU");

		DropdownElement categoriesDropdown = new DropdownElement("idDropCategories", IConstants.RULES_PAGE);
		addEntriesToCategoriesDropdown(categoriesDropdown);
		navBar.addNavElement(categoriesDropdown);

		DropdownElement dropdownElement = new DropdownElement("idDrop", IConstants.NEW_GAME);
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
