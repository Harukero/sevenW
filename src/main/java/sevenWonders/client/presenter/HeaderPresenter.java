package sevenWonders.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.presenter.interfaces.IHeaderView;
import sevenWonders.client.presenter.interfaces.IHeaderView.IHeaderPresenter;
import sevenWonders.client.view.HeaderView;

@Presenter(view = HeaderView.class)
public class HeaderPresenter extends BasePresenter<IHeaderView, IEventBus>implements IHeaderPresenter {

	public void onStart() {
		eventBus.setHeader(view.asWidget());
	}

	@Override
	public void startNewGame(int nbPlayers) {
		eventBus.goToGamePage();
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
