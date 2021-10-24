package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class samsungAllMobileNames
{
	static
	{
			System.setProperty("webdriver.chrome.driver","./driver/chromedriverN.exe");
	}

	public static void main(String args[])
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("samsung mobiles"+Keys.ENTER);
		//System.out.println("hi");
		List<WebElement> allMobiles = driver.findElements(By.xpath("//div[contains(text(),'SAMSUNG')]"));
		//System.out.println("hello");
		int count = allMobiles.size();
		System.out.println("COUNT:"+count);
		for(int i=0;i<count;i++)
		{
			String allText = allMobiles.get(i).getText();
			System.out.println(allText);
		}
		driver.close();
		
	}
}
