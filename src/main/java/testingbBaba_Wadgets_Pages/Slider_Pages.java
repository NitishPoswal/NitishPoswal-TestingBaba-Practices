package testingbBaba_Wadgets_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibrary;

public class Slider_Pages extends BaseLibrary 
{
	public Slider_Pages()
	{
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath="//*[text()='×']")
		private WebElement close ;
		
     @FindBy(xpath="//*[text()='Practice']")
		private WebElement prectices ;
		
	 @FindBy(xpath="//button[@data-target='#widget']")
		private WebElement widgets;
		
	 @FindBy(xpath = "")
	 private WebElement slider;
		
		
       public void closetowidgets()
		{
			close.click();
			prectices.click();
			widgets.click();
			slider.click();
		}
		
	public void clickevent()
	{
		
	}
}
