package sevenWonders.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import sevenWonders.core.gameElements.GameModel;

public interface DoAIPlayActionServiceAsync {
	void aiTurn(GameModel model, AsyncCallback<Void> callback);
}
