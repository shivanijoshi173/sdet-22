package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class samsungMobilePrice 
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
		WebElement nameandprice = driver.findElement(By.xpath("//div[contains(text(),'SAMSUNG Galaxy F22 (Denim Blue, 128 GB)')]/../../div[2]/div[1]/div[1]"));
		System.out.println(nameandprice.getText());
		driver.close();
	}
}
