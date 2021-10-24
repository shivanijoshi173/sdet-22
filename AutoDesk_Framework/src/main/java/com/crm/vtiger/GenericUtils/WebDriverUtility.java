package com.crm.vtiger.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author HP
 *
 */

public class WebDriverUtility 
{
	/**
	 * IMPLICIT WAIT
	 * THIS METHOD WAITS FOR 20 SECS FOR PAGE LOADING
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * NSEE OR STALEELEMENTREFFEXCEPTION
	 * THIS METHOD WAIT FOR THE ELEMENT TO BE VISIBLE
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * THIS METHOD WAIT FOR THE ELEMENT TO BE CLICKED.
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count=0;
		while(count<40)
		{
			try {
				element.click();
				break;
				}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * THIS METHOD ENABLES USER TO HANDLE DROPDOWN USING VISIBLE TEXT
	 * @param element
	 * @param option
	 */
	public void SelectOption(WebElement element,String option)
	{
		Select select=new Select(element);
		select.selectByVisibleText(option);
	}
	
	/**
	 * THIS METHOD ENABLES USER TO HANDLE DROPDOWN USING INDEX
	 * @param element
	 * @param index
	 */
	public void SelectOption(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * THIS METHOD WILL PERFORM MOUSE OVER ACTION
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * THIS METHOD WILL PERFORM RIGHT CLICK OPERATION
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * THIS METHOD HELPS TO SWITCH FROM ONE WINDOW TO ANOTHER
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindows(WebDriver driver,String partialWinTitle)
	{
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext())
		{
			String winId=it.next();
			String title=driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
		
	}
	
	/**
	 * ACCEPT ALERT
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * CANCEL ALERT
	 * @param driver
	 */
	public void cancleAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * THIS METHOD IS USED FOR SCROLLING ACTION IN A WEBPAGE
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	/**
	 * THIS METHOD IS USED FOR HANDLEING FRAMES BY INDEX
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * THIS METHOD IS USED FOR HANDLEING FRAMES BY WEBELEMENT
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * THIS METHOD IS USED FOR HANDLEING FRAMES BY ID OR NAME
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrame(WebDriver driver, String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	/**
	 * THIS METHOD IS USED FOR TAKING SCREENSHOT 
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws Throwable
	 */
	public String takeScreenshot(WebDriver driver,String screenshotname) throws Throwable
	{
		String screenshotpath="./screenshot/"+screenshotname+JavaUtility.getCurrentDate()+".PNG";
		// we use java utility.getcurrent date coz to get date so that will get to know on which date test case got failed and its same in screenshot or not
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(screenshotpath);
		Files.copy(src, dest);
		return screenshotname;
	}
	
	/**
	 * THIS METHOD IS USED FOR PRESSING ENTER KEY
	 * @throws Throwable
	 */
	public void pressEnterKey() throws Throwable
	{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}
}
