package testingBaba_Wadgets_Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibrary;
import testingbBaba_Wadgets_Pages.Auto_Complete_Pages;

public class Auto_Complete_Tests extends BaseLibrary
{
	Auto_Complete_Pages ob ;
	@BeforeTest(groups = "regression")
	@Parameters("browser")
	public void getlaunchbrowse(String browser)
	{
		getlaunchurl("https://testingbaba.com/old", browser);
		ob = new Auto_Complete_Pages();
	}
	
	@AfterTest(groups = "regression")
	public void browserclose()
	{
		driver.quit();
	}
	
	@Test(priority = 1, groups = "regression")
	public void closetowidgets()
	{
		ob.closetowidgets();
	}

	@Test(priority = 2, groups = "regression")
	public void sendcountry()
	{
		ob.sendcountry();
	}
	
	@Test(priority = 3, groups = "regression")
	public void auto()
	{
		ob.autocomple();
	}

}
