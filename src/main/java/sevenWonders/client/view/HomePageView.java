package sevenWonders.client.view;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.presenter.interfaces.IHomePageView;
import sevenWonders.client.presenter.interfaces.IHomePageView.IHomePagePresenter;

public class HomePageView extends ReverseCompositeView<IHomePagePresenter>implements IHomePageView {

	private FlowPanel root;

	public HomePageView() {
		root = new FlowPanel();
		Label label = new Label("coucou");
		root.add(label);
		initWidget(root);
	}

	@Override
	public void createView() {

	}

}
