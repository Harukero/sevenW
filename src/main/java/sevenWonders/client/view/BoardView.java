package sevenWonders.client.view;

import com.google.gwt.user.client.ui.FlowPanel;

import sevenWonders.client.constants.IAttributeNames;
import sevenWonders.client.constants.Iid;
import sevenWonders.client.controllers.BasicBoardController;
import sevenWonders.client.elements.bootstrap.ModalOpenerButton;
import sevenWonders.client.elements.bootstrap.ModalPopup;
import sevenWonders.client.elements.html.ElementSpan;
import sevenWonders.client.view.ResourcesCounterView.ResourceCounterType;
import sevenWonders.core.gameElements.Board;

public class BoardView extends BasicBoardView {

	private BasicBoardController<BasicBoardView> leftPlayerBoard;
	private BasicBoardController<BasicBoardView> rightPlayerBoard;
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
		ElementSpan span = new ElementSpan();
		span.setStyleName("glyphicon glyphicon-align-right");
		span.getElement().setAttribute("aria-hidden", IAttributeNames.VAL_TRUE);
		ModalOpenerButton rightPlayerBoardButton = new ModalOpenerButton(Iid.ResourcesCounterView_ModalRight);
		rightPlayerBoardButton.setHTML(constants.RIGHT_PLAYER_BOARD() + " <span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span>");

		buttonsPanel.add(rightPlayerBoardButton);		
	}

	private void prepareShowLeftPlayersBoardButton() {
		leftPlayerBoard = new BasicBoardController<BasicBoardView>(new BasicBoardView());
		ModalPopup popupLeftPlayer = ModalPopup.createModalPopup(constants.LEFT_PLAYER_BOARD(), Iid.ResourcesCounterView_ModalLeft,
				leftPlayerBoard.getView());
		root.add(popupLeftPlayer);
		ElementSpan span = new ElementSpan();
		span.setStyleName("glyphicon glyphicon-align-left");
		span.getElement().setAttribute("aria-hidden", IAttributeNames.VAL_TRUE);
		ModalOpenerButton leftPlayerBoardButton = new ModalOpenerButton(Iid.ResourcesCounterView_ModalLeft);
		leftPlayerBoardButton.setHTML("<span class=\"glyphicon glyphicon-menu-left\" aria-hidden=\"true\"></span> " + constants.LEFT_PLAYER_BOARD());
		
		buttonsPanel.add(leftPlayerBoardButton);
	}
	
	public void setLeftPlayerBoard(Board board) {
		leftPlayerBoard.prepareView(board);
	}
	
	public void setRightPlayerBoard(Board board) {
		rightPlayerBoard.prepareView(board);
	}
	
}
