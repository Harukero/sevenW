package sevenWonders.core.gameElements.actions;

import com.google.gwt.user.client.rpc.IsSerializable;

public interface IsAnAction extends IsSerializable{
	void doAction();
	
	void undoAction();
	
	String logAction(String language);
}
