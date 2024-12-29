package testingBaba_Wadgets_Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibrary;
import testingbBaba_Wadgets_Pages.Accordion_Pages;

public class Accordion_Tests extends BaseLibrary
{
	Accordion_Pages ob;
	
	@BeforeTest(groups = "regression")
	@Parameters("browser")
	public void getlaunchbrowse(String browser)
	{
		getlaunchurl("https://testingbaba.com/old", browser);
		ob = new Accordion_Pages();
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
	public void clickonaccordionbtn()
	{
		ob.clickonaccordion();
	}
	
	@Test(priority = 3, groups = "regression")
	public void clickonfirst()
	{
		ob.clickonfirst();
	}
	
	@Test(priority = 4, groups = "regression")
	public void validate1()
	{
		ob.gettext();
	}
}
