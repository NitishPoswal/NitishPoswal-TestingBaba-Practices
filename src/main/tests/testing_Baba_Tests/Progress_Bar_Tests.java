package testing_Baba_Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibrary;
import testingbBaba_Wadgets_Pages.Progress_Bar_Pages;

public class Progress_Bar_Tests extends BaseLibrary 
{
	Progress_Bar_Pages ob ;
	@BeforeTest(groups = "regression")
	@Parameters("browser")
	public void getlaunchbrowse(String browser)
	{
		getlaunchurl("https://testingbaba.com/old", browser);
		ob = new Progress_Bar_Pages();
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
	public void progessbtn()
	{
		ob.progessbtn();
	}
	
	@Test(priority = 3, groups = "regression")
	public void clickonstartbtn()
	{
		ob.clickonstartbtn();
	}
	
	@Test(priority = 4, groups = "regression")
	public void checking() throws InterruptedException
	{
		Thread.sleep(2000);
		ob.checking();
	}
	

}
