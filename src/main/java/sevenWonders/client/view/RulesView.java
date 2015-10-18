package sevenWonders.client.view;

import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IConstants;
import sevenWonders.client.constants.Iid;
import sevenWonders.client.elements.CardExplanationPanel;
import sevenWonders.client.elements.TabPanel;
import sevenWonders.client.presenter.interfaces.IRulesView;
import sevenWonders.client.presenter.interfaces.IRulesView.IRulesPresenter;

public class RulesView extends ReverseCompositeView<IRulesPresenter>implements IRulesView {

	TabPanel root = new TabPanel();

	@Override
	public void createView() {

		addSelectorToNewCardExplnationPanel("Raw Materials", Iid.RAW_MATERIALS, IConstants.JSON_RAW);
		addSelectorToNewCardExplnationPanel("Manufactured Goods", Iid.MANUFATURED_GOODS, IConstants.JSON_MANUFACTURED);
		addSelectorToNewCardExplnationPanel("Civilian Structures", Iid.CIVILIAN, IConstants.JSON_CIVILIAN);
		addSelectorToNewCardExplnationPanel("Scientific Structure", Iid.SCIENTIFIC, IConstants.JSON_SCIENCE);
		addSelectorToNewCardExplnationPanel("Commercial Structure", Iid.COMMERCIAL, IConstants.JSON_COMMERCIAL);
		addSelectorToNewCardExplnationPanel("Military Structure", Iid.MILITARY, IConstants.JSON_MILITARY);
		addSelectorToNewCardExplnationPanel("Guilds", Iid.GUILDS, IConstants.JSON_GUILDS);

		initWidget(root);
	}

	private void addSelectorToNewCardExplnationPanel(String selectorTitle, String selectorId, String cardsCategory) {
		FlowPanel guilds = root.addNewSelector(selectorTitle, selectorId);
		CardExplanationPanel explantationPanel = new CardExplanationPanel(cardsCategory);
		guilds.add(explantationPanel);
		explantationPanel.addCards();
	}

}
