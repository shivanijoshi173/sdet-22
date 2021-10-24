package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author HP
 *
 */
public class JavaUtility 
{
	/**
	 * THIS METHOD GENERATES RANDOM NUMBER TO AVOID DUPLICATES.
	 */
	public static String getRamdomData()
	{
		Random random=new Random();
		int ran =random.nextInt(1000);
		return ""+ran;
	}
	
	/**
	 * THIS METHOD IS USED TO GENERATE CURRENT DATE
	 * @return currentdate
	 */
	public static String getCurrentDate()
	{
		Date date=new Date();
		String currentdate=date.toString();
		return currentdate;
	}
}
