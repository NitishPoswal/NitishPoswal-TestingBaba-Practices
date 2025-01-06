package testing_Baba_Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibrary;
import testingbBaba_Wadgets_Pages.Date_Picker_Pages;

public class Date_Picker_Tests extends BaseLibrary
{
	Date_Picker_Pages ob ;
	@BeforeTest(groups = "regression")
	@Parameters("browser")
	public void getlaunchbrowse(String browser)
	{
		getlaunchurl("https://testingbaba.com/old", browser);
		ob = new Date_Picker_Pages();
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
	public void pickdate()
	{
		ob.dateselect();
	}
	
	@Test(priority = 2, groups = "regression")
	public void pickdateandtime()
	{
		ob.selectdateandtime();
	}
	

}
