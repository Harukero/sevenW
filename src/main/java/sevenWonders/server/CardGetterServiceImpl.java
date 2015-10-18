package sevenWonders.server;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import sevenWonders.client.rpc.CardGetterService;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CardGetterServiceImpl extends RemoteServiceServlet implements CardGetterService {

	public String getCards() throws IllegalArgumentException {
		URI resource = null;
		StringBuffer fileBuffer = new StringBuffer();
		try {
			resource = CardGetterServiceImpl.class.getResource("cards.json").toURI();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Stream<String> lines = Files.lines(Paths.get(resource))) {
			lines.forEach(x -> fileBuffer.append(x));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileBuffer.toString();
	}

}
