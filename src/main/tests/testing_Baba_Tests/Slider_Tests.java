package testing_Baba_Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibrary;
import testingbBaba_Wadgets_Pages.Date_Picker_Pages;

public class Slider_Tests extends BaseLibrary
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

}
