package Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFile 
{
	@Test
	public void readDataFromPropertyFile() throws IOException
	{
		/* read the data from properties file*/
		//STEP1: Get the java representation object of physical file*/
		FileInputStream fis=new FileInputStream("./Data/CommonData.properties");
		//STEP2: create an object of the properties class ANd load all the keys:value par*/
		Properties pobj=new Properties();
		pobj.load(fis);
		//STEP3: Read the values using get property("key")
		String URL=pobj.getProperty("url");
		String Browser=pobj.getProperty("Browser");
		String USERNAME=pobj.getProperty("username");
		String Password=pobj.getProperty("password");
		System.out.println(URL);
		System.out.println(Browser);
		System.out.println(USERNAME);
		System.out.println(Password);
	}
	

}
