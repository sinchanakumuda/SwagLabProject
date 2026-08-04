package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
	FileInputStream fs=new FileInputStream("./src/test/resources/commondata.properties");
	Properties p=new Properties();
	p.load(fs);
	
	String value = p.getProperty(key);
	return value;
	}

}
