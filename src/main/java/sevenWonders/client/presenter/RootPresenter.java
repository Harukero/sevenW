package sevenWonders.client.presenter;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import sevenWonders.client.IEventBus;
import sevenWonders.client.presenter.interfaces.IRootView;
import sevenWonders.client.presenter.interfaces.IRootView.IRootPresenter;
import sevenWonders.client.view.RootView;

@Presenter(view = RootView.class)
public class RootPresenter extends BasePresenter<IRootView, IEventBus>implements IRootPresenter {

	public void onStart() {
		eventBus.goToHomePage();
	}

	public void onSetHeader(Widget header) {
		view.setHeader(header);
	}

	public void onSetMenu(Widget menu) {
		view.setMenu(menu);
	}

	public void onSetBody(Widget body) {
		view.setBody(body);
	}

}
