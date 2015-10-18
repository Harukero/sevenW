package sevenWonders.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("getCards")
public interface CardGetterService extends RemoteService {
	String getCards() throws IllegalArgumentException;
}
