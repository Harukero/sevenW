package sevenWonders.server;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import sevenWonders.client.rpc.CardGetterService;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CardGetterServiceImpl extends RemoteServiceServlet implements CardGetterService {

	@Override
	public String getCards() throws IllegalArgumentException {
		URI resource = null;
		StringBuffer fileBuffer = new StringBuffer();
		try {
			resource = CardGetterServiceImpl.class.getResource("cards.json").toURI();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Path path = null;
		if (resource != null){			path = Paths.get(resource);
		}
		if (path == null) {
			throw new IllegalStateException("Error, the card resource doesn't exist");
		}
		try (Stream<String> lines = Files.lines(path)) {
			lines.forEach(x -> fileBuffer.append(x));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileBuffer.toString();
	}

}
