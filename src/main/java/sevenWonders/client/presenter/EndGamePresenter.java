package sevenWonders.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.presenter.interfaces.IEndGameView;
import sevenWonders.client.presenter.interfaces.IEndGameView.IEndGamePresenter;
import sevenWonders.client.presenter.view.EndGamePresenterView;
import sevenWonders.core.gameElements.GameModel;

@Presenter(view = EndGamePresenterView.class)
public class EndGamePresenter extends LazyPresenter<IEndGameView, IEventBus> implements IEndGamePresenter {

	public void onEndGame(GameModel model) {
		eventBus.setBody(view.asWidget());
	}
	
}
