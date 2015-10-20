package sevenWonders.client.view;

import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.elements.CardExplanationPanel;
import sevenWonders.client.presenter.interfaces.IRulesView;
import sevenWonders.client.presenter.interfaces.IRulesView.IRulesPresenter;

public class RulesView extends ReverseCompositeView<IRulesPresenter>implements IRulesView {

	private FlowPanel root;

	@Override
	public void createView() {
		root = new FlowPanel();
		initWidget(root);
	}

	@Override
	public void setExplanationPanelContent(String cardsCategory) {
		root.clear();
		CardExplanationPanel explantationPanel = new CardExplanationPanel(cardsCategory);
		explantationPanel.addCards();
		root.add(explantationPanel);
	}

}
