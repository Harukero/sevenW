package sevenWonders.client.view;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.presenter.interfaces.IGameView;
import sevenWonders.client.presenter.interfaces.IGameView.IGamePresenter;

public class GameView extends ReverseCompositeView<IGamePresenter> implements IGameView {

	FlowPanel root = new FlowPanel();
	Grid header;
	Label leftPlayerBoard;
	Label rightPlayerBoard;
	Label text;
	ResourcesCounterView resourcesCounterView = new ResourcesCounterView();
	private BoardView playerBoard;

	/*
	 * The game view has 3 parts
	 * One is the header part : in this part you have the possibility to navigate between players boards
	 * the second corresponds to the resources part 
	 * the last one is the player's board
	 * @see com.mvp4g.client.view.LazyView#createView()
	 */
	
	@Override
	public void createView() {
		header = new Grid(1,3);
		header.getElement().setClassName("table");
		
		leftPlayerBoard = new Label();
		leftPlayerBoard.getElement().setClassName("alert alert-danger");
//		leftPlayerBoard.getElement().setAttribute("role", "alert");
		leftPlayerBoard.addStyleName(IStyleNames.DISPLAY_INLINE_BLOCK);
		header.setWidget(0, 0, leftPlayerBoard);
		
		text = new Label();
		text.getElement().setClassName("alert alert-info");
//		text.getElement().setAttribute("role", "alert");
		text.addStyleName(IStyleNames.DISPLAY_INLINE_BLOCK);
		header.setWidget(0, 1, text);

		rightPlayerBoard = new Label();
		rightPlayerBoard.getElement().setClassName("alert alert-danger");
//		rightPlayerBoard.getElement().setAttribute("role", "alert");
		rightPlayerBoard.addStyleName(IStyleNames.DISPLAY_INLINE_BLOCK);
		header.setWidget(0, 2, rightPlayerBoard);
		
		root.add(header);
		root.add(resourcesCounterView);
//		root.add(playerBoard);
		initWidget( root );
	}

	@Override
	public void setName( String name ) {
		leftPlayerBoard.setText("Left Player Board");
		text.setText( "Welcome to a new 3 players game.");
		rightPlayerBoard.setText("Right Player Board");
	}

}
