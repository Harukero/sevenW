package sevenWonders.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>CardGetterService</code>.
 */
public interface CardGetterServiceAsync {
	void getCards(AsyncCallback<String> callback) throws IllegalArgumentException;
}
