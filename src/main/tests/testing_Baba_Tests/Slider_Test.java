package testing_Baba_Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibrary;
import testingbBaba_Wadgets_Pages.Slider_Page;

public class Slider_Test extends BaseLibrary
{
	
	Slider_Page ob ;
	@BeforeTest(groups = "regression")
	@Parameters("browser")
	public void getlaunchbrowse(String browser)
	{
		getlaunchurl("https://testingbaba.com/old", browser);
		ob = new Slider_Page();
	}
	
	@AfterTest(groups = "regression")
	public void browserclose() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(priority = 1, groups = "regression")
	public void closetowidgets()
	{
		ob.closetowidgets();
	}
	
	@Test(priority = 2 , groups = "regression")
	public void slider()
	{
		ob.clickevent();
	}
}
