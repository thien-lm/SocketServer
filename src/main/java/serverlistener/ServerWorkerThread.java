package serverlistener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerWorkerThread extends Thread{

	private final static Logger LOGGER = LoggerFactory.getLogger(ServerWorkerThread.class);
	private Socket socket;
	
	public ServerWorkerThread( Socket socket)
	{
		this.socket = socket;
	}
	
	public void run()
	{
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
	try {
		
			
		 inputStream = socket.getInputStream();
		 outputStream = socket.getOutputStream();
		
		String html = "<html><head><title>ditmemay</title></head><body><h1>xnxx</h1></body></html>";
		final String CRLF = "\r\n";
		
		String response = 
				    "HTTP/1.1 200 OK" +CRLF + "Content-Length: "+html.getBytes().length
				    +CRLF + CRLF + html + CRLF + CRLF;
		
		outputStream.write(response.getBytes());
		
		
		
		//serverSocket.close();
		
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		if(inputStream!=null)
		{
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(outputStream!=null)
		{
		try {
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(socket!=null)
		{
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	LOGGER.info("Connection processing finish");
}
}