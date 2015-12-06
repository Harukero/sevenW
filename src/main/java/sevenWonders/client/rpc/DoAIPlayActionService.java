package sevenWonders.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import sevenWonders.core.gameElements.GameModel;
import sevenWonders.core.gameElements.actions.IsAnAction;

@RemoteServiceRelativePath("aiTurn")
public interface DoAIPlayActionService extends RemoteService {
	GameModel aiTurn(GameModel model, String uiLanguage, IsAnAction playerAction, int turnNumber);
}
