package testScript;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;   


class TC_01CreateOrganizationWithJson
{
	static 
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriverN.exe");
	}
	public static void main(String[] args) throws Throwable
	{
	WebDriver driver=new ChromeDriver();
	//creating objects of FileUtility,WebdriverUtility,JAvaUtility, ExcelUtility to use there generic methods in this progrmas .
	//FILEUTILITY WE USED FOR ACCESSING DATA FROM JSON 
	FileUtility file=new FileUtility();
	//WEBDRIVERUTILITY WE USED FOR ACCESSING SELECT CLASS AND ACTIONS CLASS METHODS 
	WebDriverUtility webd=new WebDriverUtility();
	//JavaUtility WE USED FOR ACCESSING RANDOM NUMDATA FOR AVOIDING DUPLICATES
	JavaUtility ju=new JavaUtility();
	//ExcelUtility WE USED FOR ACCESSING DATA FROM EXCEL
	ExcelUtility eu=new ExcelUtility();
		
	driver.manage().window().maximize();
	//IMPLICIT WAIT
	webd.waitUntilPageLoad(driver);
	
	//TAKING DATA FROM JSON
	String url = file.getDataFromJson("url");
	String username = file.getDataFromJson("username");
	String password = file.getDataFromJson("password");
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();  
	
	//homepage===>click on organization
	driver.findElement(By.linkText("Organizations")).click();
	
	//organization homepage====>click on create new organization icon
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//now on new organization creation page will display..
	//fill all the details.
	//driver.findElement(By.name("accountname")).sendKeys("Test Yantra");
	String orgName=eu.getExcelData("Sheet1", 1, 1);
	System.out.println(orgName);
	driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRamdomData());
	
	String website=eu.getExcelData("Sheet1", 1, 3);
	driver.findElement(By.name("website")).sendKeys(website);
	
	driver.findElement(By.id("phone")).sendKeys("8888888888");
	driver.findElement(By.id("employees")).sendKeys("7608");
	
	String email1=eu.getExcelData("Sheet1", 1, 10);
	driver.findElement(By.id("email1")).sendKeys(email1);
	
	String email2=eu.getExcelData("Sheet1", 1, 11);
	driver.findElement(By.id("email2")).sendKeys(email2);
	
	String ownership=eu.getExcelData("Sheet1", 1, 12);
	driver.findElement(By.id("ownership")).sendKeys(ownership);
	
	driver.findElement(By.name("annual_revenue")).clear();
	driver.findElement(By.name("annual_revenue")).sendKeys("45687656");
	
	//using select class method(SelectOption) from WebDriverUtility class for dropdown menu selecting 
	//INDUSTRY
	WebElement S1=driver.findElement(By.name("industry"));
	webd.SelectOption(S1,"Technology");
	
	//using select class method(SelectOption) from WebDriverUtility class for dropdown menu selecting 
	//RATING
	WebElement S2=driver.findElement(By.name("rating"));
	webd.SelectOption(S2,"Active");
	
	//using select class method(SelectOption) from WebDriverUtility class for dropdown menu selecting 
	//ACCOUNT TYPE
	WebElement S3=driver.findElement(By.name("accounttype"));
	webd.SelectOption(S3,"Analyst");
	
	//chaning checkbox from user to group
	driver.findElement(By.xpath("//input[@value='T']")).click();
	
	//using select class method(SelectOption) from WebDriverUtility class for dropdown menu selecting 
	//assigned_group_id
	WebElement S4=driver.findElement(By.name("assigned_group_id"));
	webd.SelectOption(S4, "Support Group");
	
	//click on save button
	driver.findElement(By.xpath("//input[@name='button'][1]")).click();
	Thread.sleep(1000);
	//clicking on Administrator icon for logout
	 WebElement logOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	//using Actions class method(mouseOver) from WebDriverUtility class logout
	 webd.mouseOver(driver, logOut);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.close();
	
	
	}
	
}
