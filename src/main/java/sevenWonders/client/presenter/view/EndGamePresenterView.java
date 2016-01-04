package sevenWonders.client.presenter.view;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.presenter.interfaces.IEndGameView;
import sevenWonders.client.presenter.interfaces.IEndGameView.IEndGamePresenter;
import sevenWonders.client.view.ReverseCompositeView;

public class EndGamePresenterView extends ReverseCompositeView<IEndGamePresenter> implements IEndGameView {
	
	private FlowPanel root = new FlowPanel();
	private FlowPanel scoreTable = new FlowPanel();
	
	@Override
	public void createView() {
		root.add(new Label("End of the game"));
		root.add(scoreTable);
		initWidget(root);
	}

	@Override
	public void setScoreTable(Map<String, Integer> scoreByPlayer) {
		scoreTable.clear();
		for (Entry<String, Integer> scoreAndPlayerName : scoreByPlayer.entrySet()) {
			FlowPanel scoreLine = new FlowPanel();
			scoreLine.add(new Label(scoreAndPlayerName.getKey()));
			scoreLine.add(new Label(Integer.toString(scoreAndPlayerName.getValue())));
			scoreTable.add(scoreLine);
		}
	}
	
}
