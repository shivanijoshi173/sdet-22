package testScript;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_02createContact 
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
		//homepage===>click on contacts
		driver.findElement(By.linkText("Contacts")).click();
		//contact homepage====>click on create new contact icon
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//now on new organization creation page will display..
		//using select class for dropdown menu selecting 
		//title
		WebElement S1=driver.findElement(By.name("salutationtype"));
		Select s1=new Select(S1);
		s1.selectByValue("Mrs.");
		//fill all the details.
		driver.findElement(By.name("firstname")).sendKeys("Shivani");
		driver.findElement(By.name("lastname")).sendKeys("Joshi");
		driver.findElement(By.name("department")).sendKeys("TEST ENGINEER");
		driver.findElement(By.name("email")).sendKeys("shivanijoshi173@gmail.com");
		driver.findElement(By.name("mobile")).sendKeys("6756554565");
		driver.findElement(By.name("assistant")).sendKeys("Mona");
		driver.findElement(By.name("assistantphone")).sendKeys("6750004565");
		driver.findElement(By.name("reference")).click();
		
		//selecting Organization
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		String parent=driver.getWindowHandle();
		Set<String> win=driver.getWindowHandles();
		Iterator<String> it=win.iterator();
		while(it.hasNext())
		{
			String winId=it.next();
			if(!parent.equals(winId))
			{
				driver.switchTo().window(winId);
				System.out.println(driver.switchTo().window(winId).getTitle());
				driver.findElement(By.linkText("Test Yantra")).click();
				
			}
		}	
		driver.switchTo().window(parent);
		
		//using select class for dropdown menu selecting 
		//lead source
		WebElement S2=driver.findElement(By.name("leadsource"));
		Select s2=new Select(S2);
		s2.selectByValue("Self Generated");
		//Select date of birth.
		driver.findElement(By.id("jscal_field_birthday")).sendKeys("1996-03-17");
		Thread.sleep(2000);
		//address information
		driver.findElement(By.name("mailingstreet")).sendKeys("C/O Rajendra cloth center,shani chowk ashti");
		driver.findElement(By.name("mailingpobox")).sendKeys("414203");
		driver.findElement(By.name("mailingcity")).sendKeys("ashti");
		driver.findElement(By.name("mailingstate")).sendKeys("maharashtra");
		driver.findElement(By.name("mailingcountry")).sendKeys("India");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();
		Thread.sleep(2000);
		//Description
		driver.findElement(By.name("description")).sendKeys("INFORMATION OF PERSON WHO IS EMPLOYEE OF THAT ORGANIZATION ");
		Thread.sleep(2000);
		//to save contacts
		driver.findElement(By.xpath("//input[@name='button'][1]")).click();
		Thread.sleep(1000);
		//clicking on Administrator icon for logout
		WebElement logOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//to signout
		Actions a=new Actions(driver);
		a.moveToElement(logOut).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.close();
		}
		
}
