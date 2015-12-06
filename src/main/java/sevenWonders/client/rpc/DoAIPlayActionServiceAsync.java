package sevenWonders.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import sevenWonders.core.gameElements.GameModel;
import sevenWonders.core.gameElements.actions.IsAnAction;

public interface DoAIPlayActionServiceAsync {
	void aiTurn(GameModel model, String uiLanguage, IsAnAction playerAction, int turnNumber, AsyncCallback<GameModel> callback);
}
