package testingbBaba_Wadgets_Pages;

import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibrary;

public class Slider_Pages extends BaseLibrary 
{
	public Slider_Pages()
	{
		PageFactory.initElements(driver, this);
	}
}
