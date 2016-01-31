package sevenWonders.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.controllers.BoardController;
import sevenWonders.client.presenter.interfaces.IGameView;
import sevenWonders.client.presenter.interfaces.IGameView.IGamePresenter;
import sevenWonders.client.presenter.view.GamePresenterView;
import sevenWonders.core.gameElements.GameModel;

@Presenter(view = GamePresenterView.class)
public class GamePresenter extends LazyPresenter<IGameView, IEventBus> implements IGamePresenter {

	private BoardController controller;
	private GameModel model;

	public void onGoToGamePage(int nbPlayers) {
		prepareModel(Math.min(Math.max(3, nbPlayers), 7));
		view.initHand();
		eventBus.setBody(view.asWidget());
	}

	private void prepareModel(int nbPlayer) {
		model = new GameModel(nbPlayer);
		model.prepareModel();
	}

	@Override
	public void setController(BoardController controller) {
		this.controller = controller;
		this.controller.prepareView(model.getPlayerBoard());
		this.controller.setModel(model);
		this.controller.setEventBus(getEventBus());
	}
}
