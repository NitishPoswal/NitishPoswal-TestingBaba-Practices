package testingbBaba_Wadgets_Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibrary;

public class Auto_Complete_Pages extends BaseLibrary
{
	 public Auto_Complete_Pages()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	    @FindBy(xpath="//*[text()='×']")
		private WebElement close ;
		
		@FindBy(xpath="//*[text()='Practice']")
		private WebElement prectices ;
		
		@FindBy(xpath="//button[@data-target='#widget']")
		private WebElement widgets;
		
		@FindBy(xpath = "//a[@href='#tab_17']")
		private WebElement autocomplete;
		
		@FindBy(xpath = "//iframe[@src=\"Autocomplete.html\"]")
		private WebElement frame;
		
		@FindBy(xpath = "//input[@placeholder='Country']")
		private WebElement country;
		
		public void closetowidgets()
		{
			close.click();
			prectices.click();
			widgets.click();
			autocomplete.click();
		}
		
		public void sendcountry()
		{
			driver.switchTo().frame(frame);
			country.sendKeys("IN");
			
		}
		
		public void autocomple()
		{
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			driver.switchTo().defaultContent();
		}
}
