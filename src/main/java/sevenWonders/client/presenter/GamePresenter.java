package sevenWonders.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.presenter.interfaces.IGameView;
import sevenWonders.client.presenter.interfaces.IGameView.IGamePresenter;
import sevenWonders.client.view.GameView;

@Presenter(view = GameView.class)
public class GamePresenter extends LazyPresenter<IGameView, IEventBus>implements IGamePresenter {

	public void onGoToGamePage() {
		view.initHand();
		eventBus.setBody(view.asWidget());
	}

}
