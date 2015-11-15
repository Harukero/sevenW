package sevenWonders.client.presenter.view;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

import sevenWonders.client.constants.IConstants;
import sevenWonders.client.presenter.interfaces.IHomePageView;
import sevenWonders.client.presenter.interfaces.IHomePageView.IHomePagePresenter;
import sevenWonders.client.view.ReverseCompositeView;

public class HomePagePresenterView extends ReverseCompositeView<IHomePagePresenter>implements IHomePageView {

	private FlowPanel root;

	public HomePagePresenterView() {
		root = new FlowPanel();
		Image label = new Image(IConstants.IMAGE_RHODES_WALL);
		root.add(label);
		initWidget(root);
	}

	@Override
	public void createView() {

	}

}
