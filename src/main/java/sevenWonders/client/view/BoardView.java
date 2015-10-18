package sevenWonders.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class BoardView extends Composite {

	private FlowPanel root;
	
	public BoardView() {
		root = new FlowPanel();
		
		initWidget(root);
	}
	
}
