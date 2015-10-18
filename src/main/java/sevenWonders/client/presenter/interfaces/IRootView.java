package sevenWonders.client.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public interface IRootView extends IsWidget {

	public interface IRootPresenter {

	}
	
	void setHeader( Widget header );

	void setMenu( Widget menu );

	void setBody( Widget body );

}
