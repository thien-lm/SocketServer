import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonNode;

import util.Json;

public class ConfigurationManager {
	
	private static ConfigurationManager myConfigurationManager;
	private static Configuration myCurrentConfiguration;
	
	public ConfigurationManager() {
		
	}
	
	public static ConfigurationManager getInstance() 
	{
		if(myCurrentConfiguration == null) 
			myConfigurationManager = new ConfigurationManager();
		
		return myConfigurationManager;
		
	}
	
	/**
	 * load file with path
	 * @throws IOException 
	 */
	public void loadConfigurationFile(String filePath) throws IOException 
	{
		FileReader fileReader = new FileReader(filePath);
		StringBuffer sb = new StringBuffer();
		int i;
		while((i = fileReader.read()) != -1) 
		{
			sb.append((char)i);
		}
		
		JsonNode conf = Json.parse(sb.toString());
		myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
	}
	
	/**
	 * return current loaded configuration
	 */
	
	public Configuration getCurrentConfiguration() {
		if(myCurrentConfiguration == null)
		{
		throw new HttpConfigurationException("no current exception set");
		}
		
		return myCurrentConfiguration;
		
	}
	

	

}
