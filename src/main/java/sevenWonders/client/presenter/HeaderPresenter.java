package sevenWonders.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.presenter.interfaces.IHeaderView;
import sevenWonders.client.presenter.interfaces.IHeaderView.IHeaderPresenter;
import sevenWonders.client.view.HeaderView;

@Presenter(view = HeaderView.class)
public class HeaderPresenter extends BasePresenter<IHeaderView, IEventBus> implements IHeaderPresenter {

	public void onStart(){
		eventBus.setHeader( view.asWidget() );
	}
	
	@Override
	public void startNewGame() {
		eventBus.goToPage1( "You clicked the menu." );
	}

	@Override
	public void openRulesPage() {
		eventBus.goToPage2( "You clicked the menu." );
	}
	
}
