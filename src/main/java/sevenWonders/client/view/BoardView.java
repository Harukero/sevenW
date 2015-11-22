package sevenWonders.client.view;

import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.Iid;
import sevenWonders.client.controllers.BasicBoardController;
import sevenWonders.client.elements.ModalOpenerButton;
import sevenWonders.client.elements.ModalPopup;
import sevenWonders.client.view.ResourcesCounterView.ResourceCounterType;
import sevenWonders.core.gameElements.Board;

public class BoardView extends BasicBoardView {

	private BasicBoardController leftPlayerBoard;
	private BasicBoardController rightPlayerBoard;
	private FlowPanel buttonsPanel;
	public BoardView() {
		super();
	}

	@Override
	protected void initRoot() {
		buttonsPanel = new FlowPanel();
		prepareShowLeftPlayersBoardButton();
		prepareShowRightPlayersBoardButton();
		root.add(buttonsPanel);
		super.initRoot();
	}
	
	@Override
	protected ResourcesCounterView getAccurateResourceCounter() {
		return new ResourcesCounterView(ResourceCounterType.MAIN_PLAYER);
	}
	
	private void prepareShowRightPlayersBoardButton() {
		rightPlayerBoard = new BasicBoardController<BasicBoardView>(new BasicBoardView());

		ModalPopup popupRightPlayer = ModalPopup.createModalPopup(constants.RIGHT_PLAYER_BOARD(), Iid.ResourcesCounterView_ModalRight,
				rightPlayerBoard.getView());
		root.add(popupRightPlayer);
		ModalOpenerButton rightPlayerBoardButton = new ModalOpenerButton(constants.RIGHT_PLAYER_BOARD(), Iid.ResourcesCounterView_ModalRight);

		buttonsPanel.add(rightPlayerBoardButton);		
	}

	private void prepareShowLeftPlayersBoardButton() {
		leftPlayerBoard = new BasicBoardController<BasicBoardView>(new BasicBoardView());
		ModalPopup popupLeftPlayer = ModalPopup.createModalPopup(constants.LEFT_PLAYER_BOARD(), Iid.ResourcesCounterView_ModalLeft,
				leftPlayerBoard.getView());
		root.add(popupLeftPlayer);
		ModalOpenerButton leftPlayerBoardButton = new ModalOpenerButton(constants.LEFT_PLAYER_BOARD(), Iid.ResourcesCounterView_ModalLeft);
		
		buttonsPanel.add(leftPlayerBoardButton);
	}
	
	public void setLeftPlayerBoard(Board board) {
		leftPlayerBoard.prepareView(board);
	}
	
	public void setRightPlayerBoard(Board board) {
		rightPlayerBoard.prepareView(board);
	}
	
}
