package sevenWonders.client.presenter;

import java.util.HashMap;
import java.util.Map;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.presenter.interfaces.IEndGameView;
import sevenWonders.client.presenter.interfaces.IEndGameView.IEndGamePresenter;
import sevenWonders.client.presenter.view.EndGamePresenterView;
import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.GameModel;

@Presenter(view = EndGamePresenterView.class)
public class EndGamePresenter extends LazyPresenter<IEndGameView, IEventBus> implements IEndGamePresenter {

	public void onEndGame(GameModel model) {
		eventBus.setBody(view.asWidget());
		updateView(model);
	}

	private void updateView(GameModel model) {
		Map<String, Integer> scoreByPlayer = new HashMap<>();
		for (Board aiBoard : model.getAIBoards()) {
			scoreByPlayer.put(aiBoard.getWonder().getName(), aiBoard.computeScore());
		}
		Board playerBoard = model.getPlayerBoard();
		scoreByPlayer.put(playerBoard.getWonder().getName(), playerBoard.computeScore());
		view.setScoreTable(scoreByPlayer);
	}
	
}
