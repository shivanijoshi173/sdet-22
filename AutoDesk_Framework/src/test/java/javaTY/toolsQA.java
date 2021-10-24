package javaTY;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class toolsQA 
{   
	static 
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriverN.exe");
	}
	
	@Test
	public void toolsQATest() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tool-tips");
	
		WebElement clickingonbutton = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		Actions act=new Actions(driver);
		act.moveToElement(clickingonbutton).perform();
		
		Thread.sleep(4000);
		WebElement msgpopup = driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		
		String text = msgpopup.getText();
		Thread.sleep(2000);
		WebElement msgoutput = driver.findElement(By.id("toolTipTextField"));
		msgoutput.sendKeys(text);
		Thread.sleep(2000);
		System.out.println("displayed msg on textbox");
		driver.close();
	}
	
	
}
