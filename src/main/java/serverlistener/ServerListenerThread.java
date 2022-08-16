package serverlistener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerListenerThread extends Thread{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ServerListenerThread.class);
	private int port;
	private String webroot;
	private ServerSocket serverSocket;
	
	public ServerListenerThread(int port, String webroot) throws IOException
	{
		this.port = port;
		this.webroot = webroot;
		this.serverSocket = new ServerSocket(this.port);
	}
	
	public void run()
	{
       try {
			while(serverSocket.isBound() && !serverSocket.isClosed())
			{
			Socket socket = serverSocket.accept();
			LOGGER.info("connected" + socket.getInetAddress());
			ServerWorkerThread serverWorkerThread = new ServerWorkerThread(socket);
			serverWorkerThread.start();
			}	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
       finally
       {
    	   if(serverSocket != null)
    	   {
    		   try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   }
       }

	}
	}


