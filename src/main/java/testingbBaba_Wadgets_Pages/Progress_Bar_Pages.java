package testingbBaba_Wadgets_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import baselibrary.BaseLibrary;

public class Progress_Bar_Pages extends BaseLibrary
{
	 public Progress_Bar_Pages()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	    @FindBy(xpath="//*[text()='×']")
		private WebElement close ;
		
		@FindBy(xpath="//*[text()='Practice']")
		private WebElement prectices ;
		
		@FindBy(xpath="//button[@data-target='#widget']")
		private WebElement widgets;
		
		@FindBy(xpath = "//a[@href='#tab_20']")
		private WebElement progessbtn;
		
		@FindBy(xpath = "//button[@id='resetButton']")
		private WebElement startbtn;
		
		@FindBy(xpath = "//div[@id='myBar']")
		private WebElement checkingbar;
		
		
		public void closetowidgets()
		{
			close.click();
			prectices.click();
			widgets.click();
		}
		
		public void progessbtn()
		{
			progessbtn.click();

		}
		
		public void clickonstartbtn()
		{
			startbtn.click();
			
		}
		
		
		public void checking()
		{
		    String a =	checkingbar.getText();
		    System.out.println(a);
			
		}
		
		
		
		
		
		
		
}
