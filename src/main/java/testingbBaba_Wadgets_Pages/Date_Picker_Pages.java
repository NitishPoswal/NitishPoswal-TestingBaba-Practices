package testingbBaba_Wadgets_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibrary;

public class Date_Picker_Pages extends BaseLibrary
{
	 public Date_Picker_Pages()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	    @FindBy(xpath="//*[text()='×']")
		private WebElement close ;
		
		@FindBy(xpath="//*[text()='Practice']")
		private WebElement prectices ;
		
		@FindBy(xpath="//button[@data-target='#widget']")
		private WebElement widgets;
		
		@FindBy(xpath = "//a[@href='#tab_18']")
		private WebElement datebtn;
		
		@FindBy(xpath = "//div[@class='col-md-9 col-sm-12 form-inline']/input[@type='date']")
		private WebElement date;
		
		@FindBy(xpath = "//div[@class='col-md-9 col-sm-12 form-inline']/input[@type='datetime-local']")
		private WebElement datetime;
		
		
		public void closetowidgets()
		{
			close.click();
			prectices.click();
			widgets.click();
			datebtn.click();
		}
		
		public void dateselect()
		{
			date.sendKeys("27082024");
		}
		
		public void selectdateandtime()
		{
			datetime.sendKeys("270520290729");
		}
}
