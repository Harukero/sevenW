package sevenWonders.server;

import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import sevenWonders.client.rpc.DoAIPlayActionService;
import sevenWonders.core.gameElements.GameModel;

@SuppressWarnings("serial")
public class DoAIPlayActionServiceImpl extends RemoteServiceServlet implements DoAIPlayActionService {

	private static final Logger logger = Logger.getLogger(DoAIPlayActionServiceImpl.class.getName());
	
	
	@Override
	public void aiTurn(GameModel model) {
		logger.warning("!!!! AI Turn !!!!");
	}
}
