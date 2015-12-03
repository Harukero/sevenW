package sevenWonders.client.presenter.view;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.elements.bootstrap.Accordion;
import sevenWonders.client.elements.gameSpecific.CardExplanationPanel;
import sevenWonders.client.presenter.interfaces.IRulesView;
import sevenWonders.client.presenter.interfaces.IRulesView.IRulesPresenter;
import sevenWonders.client.view.ReverseCompositeView;

public class RulesPresenterView extends ReverseCompositeView<IRulesPresenter>implements IRulesView {

	private FlowPanel root;

	@Override
	public void createView() {
		root = new FlowPanel();
		initWidget(root);
	}

	@Override
	public void setExplanationPanelContent(String cardsCategory) {
		root.clear();
		Accordion accordion = new Accordion("accordion-id");
		
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.add(new Label("End of the game"));
		
		accordion.addPanel(flowPanel, "titleId", "the end !", "theEndId");
		
		FlowPanel flowPanel2 = new FlowPanel();
		flowPanel2.add(new Label("End of the game, yeah, really"));
		accordion.addPanel(flowPanel2, "titleId2", "the end, really !", "theEndId2");

		root.add(accordion);
		CardExplanationPanel explantationPanel = new CardExplanationPanel(cardsCategory);
		explantationPanel.addCards();
		root.add(explantationPanel);
		
	}

}
