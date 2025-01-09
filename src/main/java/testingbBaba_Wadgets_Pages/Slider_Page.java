package testingbBaba_Wadgets_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibrary;

public class Slider_Page extends BaseLibrary
{

	 public Slider_Page()
	 {
		PageFactory.initElements(driver, this);
	 }
	
	 @FindBy(xpath="//*[text()='×']")
	 private WebElement close ;
		
     @FindBy(xpath="//*[text()='Practice']")
	 private WebElement prectices ;
		
	 @FindBy(xpath="//button[@data-target='#widget']")
	 private WebElement widgets;
		
	 @FindBy(xpath = "//a[@href='#tab_19']")
	 private WebElement sliderbtn;
		
	 @FindBy(xpath = "//input[@class='range-slider__range']")
	 private WebElement slider;
		
       public void closetowidgets()
		{
			close.click();
			prectices.click();
			widgets.click();
			sliderbtn.click();
		}
		
	public void clickevent()
	{
		slider.click();
		xyaxisdraganddrop(slider, 50, 0);
	}
}
