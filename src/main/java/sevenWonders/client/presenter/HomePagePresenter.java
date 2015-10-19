package sevenWonders.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.presenter.interfaces.IHomePageView;
import sevenWonders.client.presenter.interfaces.IHomePageView.IHomePagePresenter;
import sevenWonders.client.view.HomePageView;

@Presenter(view = HomePageView.class)
public class HomePagePresenter extends LazyPresenter<IHomePageView, IEventBus>implements IHomePagePresenter {

	public void onGoToHomePage() {
		eventBus.setBody(view.asWidget());
	}

}
