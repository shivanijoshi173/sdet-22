package Demo;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadDataFromJsonNew 
{   
	@Test
	public void readdatafromjson() throws Throwable
	{
		//read the data from json file
		FileReader file=new FileReader("./Data/CommonData.json");
		
		//convert the json file into java object.
		JSONParser jsonobj= new JSONParser();
		Object jobj=jsonobj.parse(file);
		
		//type cast the java object into hashmap
		HashMap map=(HashMap)jobj;
		String USERNAME=map.get("username").toString();
		System.out.println("USERNAME:-  "+USERNAME);
		
		String PASSWORD=map.get("password").toString();
		System.out.println("PASSWORD:-  "+PASSWORD);
		
		String URL=map.get("url").toString();
		System.out.println("URL:-       "+URL);
		
		String BROWSER=map.get("Browser").toString();
		System.out.println("BROWSER:-   "+BROWSER);
		
		
		
	}

}
