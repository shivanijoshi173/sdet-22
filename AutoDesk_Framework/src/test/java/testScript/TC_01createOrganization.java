package testScript;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_01createOrganization
{
	static 
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriverN.exe");
	}
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//enter url
		driver.get("http://localhost:8888/");
		
		//login details
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//homepage===>click on organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//organization homepage====>click on create new organization icon
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//now on new organization creation page will display..
		//fill all the details.
		driver.findElement(By.name("accountname")).sendKeys("Test Yantra");
		driver.findElement(By.name("website")).sendKeys("www.testyantra.com");
		driver.findElement(By.id("employees")).sendKeys("7608");
		driver.findElement(By.id("phone")).sendKeys("8888888888");
		driver.findElement(By.id("email1")).sendKeys("hr@testyantra.com");
		driver.findElement(By.id("ownership")).sendKeys("Manager");
		driver.findElement(By.id("email2")).sendKeys("helpdesk@testyantra.com");
		driver.findElement(By.name("annual_revenue")).clear();
		driver.findElement(By.name("annual_revenue")).sendKeys("45687656");
		
		//using select class for dropdown menu selecting 
		//INDUSTRY
		WebElement S1=driver.findElement(By.name("industry"));
		Select s1=new Select(S1);
		s1.selectByValue("Technology");
		
		//using select class for dropdown menu selecting 
		//RATING
		WebElement S2=driver.findElement(By.name("rating"));
		Select s2=new Select(S2);
		s2.selectByValue("Active");
		
		//using select class for dropdown menu selecting 
		//ACCOUNT TYPE
		WebElement S3=driver.findElement(By.name("accounttype"));
		Select s3=new Select(S3);
		s3.selectByValue("Analyst");
		
		//chaning checkbox from user to group
		driver.findElement(By.xpath("//input[@value='T']")).click();
		
		//using select class for dropdown menu selecting 
		//assigned_group_id
		WebElement S4=driver.findElement(By.name("assigned_group_id"));
		Select s4=new Select(S4);
		s4.selectByVisibleText("Support Group");
		
		//click on save button
		driver.findElement(By.xpath("//input[@name='button'][1]")).click();
		Thread.sleep(1000);
		//clicking on Administrator icon for logout
		 WebElement logOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		//using Actions class logout
		Actions a=new Actions(driver);
		a.moveToElement(logOut).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
	}
	
}
