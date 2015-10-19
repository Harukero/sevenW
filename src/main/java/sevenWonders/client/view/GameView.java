package sevenWonders.client.view;

import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.presenter.interfaces.IGameView;
import sevenWonders.client.presenter.interfaces.IGameView.IGamePresenter;

public class GameView extends ReverseCompositeView<IGamePresenter>implements IGameView {

	private FlowPanel root = new FlowPanel();
	private BoardView playerBoard;

	/*
	 * The game view has 3 parts One is the header part : in this part you have
	 * the possibility to navigate between players boards the second corresponds
	 * to the resources part the last one is the player's board
	 * 
	 * @see com.mvp4g.client.view.LazyView#createView()
	 */

	@Override
	public void createView() {
		playerBoard = new BoardView();
		root.add(playerBoard);
		playerBoard.setVisible(false);
		initWidget(root);
	}

	@Override
	public void initHand() {
		playerBoard.setVisible(true);
		playerBoard.initHand();
	}

}
