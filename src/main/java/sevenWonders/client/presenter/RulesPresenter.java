package sevenWonders.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.presenter.interfaces.IRulesView;
import sevenWonders.client.presenter.interfaces.IRulesView.IRulesPresenter;
import sevenWonders.client.view.RulesView;

@Presenter(view = RulesView.class)
public class RulesPresenter extends LazyPresenter<IRulesView, IEventBus> implements IRulesPresenter {

	public void onGoToPage2(String name){
		eventBus.setBody( view.asWidget() );
	}
	
}
