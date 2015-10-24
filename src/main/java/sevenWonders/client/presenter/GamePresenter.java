package sevenWonders.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.controllers.BoardController;
import sevenWonders.client.presenter.interfaces.IGameView;
import sevenWonders.client.presenter.interfaces.IGameView.IGamePresenter;
import sevenWonders.client.presenter.view.GamePresenterView;

@Presenter(view = GamePresenterView.class)
public class GamePresenter extends LazyPresenter<IGameView, IEventBus> implements IGamePresenter {

	BoardController controller;

	public void onGoToGamePage() {
		view.initHand();
		eventBus.setBody(view.asWidget());
	}

	@Override
	public void setController(BoardController controller) {
		this.controller = controller;
	}

}
