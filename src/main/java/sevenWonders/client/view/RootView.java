package sevenWonders.client.view;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import sevenWonders.client.presenter.interfaces.IRootView;
import sevenWonders.client.presenter.interfaces.IRootView.IRootPresenter;

public class RootView extends ReverseCompositeView<IRootPresenter> implements IRootView {


	FlowPanel root;
	Widget header, menu, body;
	
	public RootView() {
		root = new FlowPanel();
		
		header = new FlowPanel();
		menu = new FlowPanel();
		body = new FlowPanel();
		
		root.add(header);
		root.add(menu);
		root.add(body);
		initWidget(root);
	}

	@Override
	public void setHeader( Widget header ) {
		root.remove(this.header);
		this.header = header;
		root.insert(header, 0);
	}

	@Override
	public void setMenu( Widget menu ) {
		root.remove(this.menu);
		this.menu = menu;
		root.insert(menu, 1);
	}

	@Override
	public void setBody( Widget body ) {
		root.remove(this.body);
		this.body = body;
		root.insert(body, 2);
	}

}
