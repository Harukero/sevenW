package sevenWonders.client.presenter.interfaces;

import java.util.Map;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;

public interface IEndGameView extends IsWidget, LazyView {
	public interface IEndGamePresenter {
	}

	void setScoreTable(Map<String, Integer> scoreByPlayer);
}
