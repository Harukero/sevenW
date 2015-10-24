package sevenWonders.client.presenter.view;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import sevenWonders.client.presenter.interfaces.IHomePageView;
import sevenWonders.client.presenter.interfaces.IHomePageView.IHomePagePresenter;
import sevenWonders.client.view.ReverseCompositeView;

public class HomePagePresenterView extends ReverseCompositeView<IHomePagePresenter>implements IHomePageView {

	private FlowPanel root;

	public HomePagePresenterView() {
		root = new FlowPanel();
		Label label = new Label("coucou");
		root.add(label);
		initWidget(root);
	}

	@Override
	public void createView() {

	}

}
