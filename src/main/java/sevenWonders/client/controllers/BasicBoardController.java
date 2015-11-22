package sevenWonders.client.controllers;

import sevenWonders.client.view.BasicBoardView;
import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.GameModel;

public class BasicBoardController <X extends BasicBoardView> {
	protected final X view;
	protected Board board;
	protected GameModel model;

	
	public BasicBoardController(X view) {
		this.view = view;
	}
	
	public BasicBoardView getView() {
		return view;
	}
	
	public void prepareView(Board board) {
		this.board = board;
		view.updateHand(board.getHand());
		view.initGameZone(board.getPlayedCards());
		view.getResourcesCounterView().updateView(board.getResources());

	}
}
