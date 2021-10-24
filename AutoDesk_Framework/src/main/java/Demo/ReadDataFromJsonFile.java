package Demo;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadDataFromJsonFile 
{
	@Test
	public void getDataFromJson() throws Throwable
	{
		FileReader reader=new FileReader("./Data/CommonData.json");
		JSONParser parser=new JSONParser();
		Object object=parser.parse(reader);
		JSONObject jsonobject=(JSONObject)object;
		String Url=jsonobject.get("url").toString();
		String Browser=jsonobject.get("Browser").toString();
		String US=jsonobject.get("username").toString();
		String Pwd=jsonobject.get("password").toString();
		System.out.println(Url);
		System.out.println(Browser);
		System.out.println(US);
		System.out.println(Pwd);
		
}

}



