package sevenWonders.client;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;

import sevenWonders.client.presenter.GamePresenter;
import sevenWonders.client.presenter.HeaderPresenter;
import sevenWonders.client.presenter.HomePagePresenter;
import sevenWonders.client.presenter.RootPresenter;
import sevenWonders.client.presenter.RulesPresenter;

@Events(startPresenter = RootPresenter.class)
public interface IEventBus extends EventBus {

	@Start
	@Event(handlers = { HeaderPresenter.class, RootPresenter.class })
	void start();

	/*
	 * Layout events
	 */
	@Event(handlers = RootPresenter.class)
	void setHeader(Widget header);

	@Event(handlers = RootPresenter.class)
	void setMenu(Widget menu);

	@Event(handlers = RootPresenter.class)
	void setBody(Widget body);

	/*
	 * Place events
	 */
	@Event(handlers = GamePresenter.class)
	void goToGamePage(int nbPlayers);

	@Event(handlers = RulesPresenter.class)
	void goToRulesPage(String cardsCategory);

	@Event(handlers = HomePagePresenter.class)
	void goToHomePage();
}
