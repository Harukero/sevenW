package sevenWonders.client.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;

public interface IHeaderView extends IsWidget {

	public interface IHeaderPresenter {
		void startNewGame();

		void openRulesPage();

		void openHomePage();

	}

}
