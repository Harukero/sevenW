package sevenWonders.client.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;

import sevenWonders.client.controllers.BoardController;

public interface IGameView extends IsWidget, LazyView {

	public interface IGamePresenter {
		void setController(BoardController controller);
	}

	void initHand();

}
