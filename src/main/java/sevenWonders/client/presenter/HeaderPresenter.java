package sevenWonders.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.presenter.interfaces.IHeaderView;
import sevenWonders.client.presenter.interfaces.IHeaderView.IHeaderPresenter;
import sevenWonders.client.presenter.view.HeaderPresenterView;

@Presenter(view = HeaderPresenterView.class)
public class HeaderPresenter extends BasePresenter<IHeaderView, IEventBus> implements IHeaderPresenter {

	public void onStart() {
		eventBus.setHeader(view.asWidget());
	}

	@Override
	public void startNewGame(int nbPlayers) {
		eventBus.goToGamePage(nbPlayers);
	}

	@Override
	public void openRulesPage(String cardsCategory) {
		eventBus.goToRulesPage(cardsCategory);
	}

	@Override
	public void openHomePage() {
		eventBus.goToHomePage();
	}

}
