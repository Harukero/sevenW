package sevenWonders.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.presenter.interfaces.IRulesView;
import sevenWonders.client.presenter.interfaces.IRulesView.IRulesPresenter;
import sevenWonders.client.presenter.view.RulesPresenterView;

@Presenter(view = RulesPresenterView.class)
public class RulesPresenter extends LazyPresenter<IRulesView, IEventBus>implements IRulesPresenter {

	public void onGoToRulesPage(String cardsCategory) {
		eventBus.setBody(view.asWidget());
		setExplanationPanelContent(cardsCategory);
	}

	private void setExplanationPanelContent(String cardsCategory) {
		view.setExplanationPanelContent(cardsCategory);
	}

}
