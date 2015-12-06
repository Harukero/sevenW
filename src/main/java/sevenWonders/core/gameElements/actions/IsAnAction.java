package sevenWonders.core.gameElements.actions;

import com.google.gwt.user.client.rpc.IsSerializable;

import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Card;

public interface IsAnAction extends IsSerializable{
	void doAction();
	
	void undoAction();
	
	String logAction(String language);

	GameActionType getActionType();
	
	Board getPlayer();

	Card getCard();
}
