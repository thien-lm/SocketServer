import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import serverlistener.ServerListenerThread;

public class HTTPServer {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(HTTPServer.class);
	
	public static void main(String[] args) throws IOException {
		LOGGER.info("server is running");
		
		ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
		Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
		LOGGER.info(conf.getPort()+"");
		LOGGER.info(conf.getWebroot());
		
		try {
			ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(),conf.getWebroot());
			serverListenerThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
