package com.superProject.testCases;

import org.testng.annotations.Test;

import com.superProject.pageObject.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {
	
	
	
	@Test
	
	public void LoginTest()
	{
		driver.get(baseURL);
		logger.info("URL is open");
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered User name");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals(pagetitle)) 
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{	
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
	
	
	

}
