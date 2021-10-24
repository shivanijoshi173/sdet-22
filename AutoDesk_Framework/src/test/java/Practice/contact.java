package Practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class contact
{
	@Test
	public void org(XmlTest xml)
	{
		System.out.println("EXECUTE1");
		String URL = xml.getParameter("url");
		String UN = xml.getParameter("username");
		System.out.println(URL);
		System.out.println(UN);
	}
}
