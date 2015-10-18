package sevenWonders.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IConstants;
import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.elements.CollapsePanel;
import sevenWonders.client.elements.ListItemWidget;
import sevenWonders.client.elements.UnorderedListWidget;
import sevenWonders.client.presenter.interfaces.IHeaderView;
import sevenWonders.client.presenter.interfaces.IHeaderView.IHeaderPresenter;

public class HeaderView extends ReverseCompositeView<IHeaderPresenter>implements IHeaderView {

	private FlowPanel root;
	private Anchor rulesButton;
	private Anchor startButton;
	private FlowPanel section;
	private UnorderedListWidget ul;

	public HeaderView() {

		root = new FlowPanel();
		CollapsePanel collapsePanel = new CollapsePanel(IConstants.SEVEN_WONDERS_MENU, "header");
		root.add(collapsePanel);

		section = new FlowPanel();
		ul = new UnorderedListWidget();
		ul.getElement().setClassName("nav nav-pills");
		ListItemWidget listItemGame = new ListItemWidget();
		startButton = new Anchor(IConstants.NEW_GAME);
		listItemGame.add(startButton);

		ListItemWidget listItemRules = new ListItemWidget();
		rulesButton = new Anchor(IConstants.RULES_PAGE);
		listItemRules.add(rulesButton);

		ul.add(listItemGame);
		ul.add(listItemRules);

		section.add(ul);
		section.addStyleName(IStyleNames.MENU);
		collapsePanel.setBody(section);
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
	}

}
