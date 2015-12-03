package sevenWonders.client.presenter.view;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.presenter.interfaces.IEndGameView;
import sevenWonders.client.presenter.interfaces.IEndGameView.IEndGamePresenter;
import sevenWonders.client.view.ReverseCompositeView;

public class EndGamePresenterView extends ReverseCompositeView<IEndGamePresenter> implements IEndGameView {
	
	private FlowPanel root = new FlowPanel();
	
	@Override
	public void createView() {
		root.add(new Label("End of the game"));
		
		initWidget(root);
	}
}
