package common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;





public class PropHandler
{

	public static String getProperties (String key)
	{
		try
		{
			
		
		File f= new File(System.getProperty("user.dir")+"\\Resources\\Property.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		}catch(Exception e)
		{
			return null;
		}
	}
}
