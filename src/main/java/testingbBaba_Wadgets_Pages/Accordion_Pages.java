 package testingbBaba_Wadgets_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibrary;

public class Accordion_Pages extends BaseLibrary
{
	 public Accordion_Pages()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	    @FindBy(xpath="//*[text()='×']")
		private WebElement close ;
		
		@FindBy(xpath="//*[text()='Practice']")
		private WebElement prectices ;
		
		@FindBy(xpath="//button[@data-target='#widget']")
		private WebElement widgets;
		
		@FindBy(xpath="//a[@href='#tab_16']")
		private WebElement accordion;
		
		@FindBy(xpath = "//button[@data-target='#collapse1']")
		private WebElement first;
		
		@FindBy(xpath = "//div[@id='collapse1']/div/p")
		private WebElement firsttexthead;
		
		@FindBy(xpath = "//div[@id='collapse1']/div/text()[2]")
		private WebElement firsttextpera;
		
		@FindBy(xpath = "")
		private WebElement second;
		
		@FindBy(xpath = "")
		private WebElement secondtexthead;
		
		@FindBy(xpath = "")
		private WebElement secondtextpera;
		
		@FindBy(xpath = "")
		private WebElement third;
		
		@FindBy(xpath = "")
		private WebElement thirdtexthead;
		
		@FindBy(xpath = "")
		private WebElement thirdtextpera;
		

		
		public void closetowidgets()
		{
			close.click();
			prectices.click();
			widgets.click();
			
		}
		
		public void clickonaccordion()
		{
			accordion.click();
		}
		
		public void clickonfirst()
		{
			first.click();
		}
		
		public void gettext()
		{
			String head =firsttexthead.getText();
			String pera =firsttextpera.getText();
			System.out.println(head);
			System.out.println(pera);
//			SoftAssert sf = new SoftAssert();
//			sf.assertEquals(head, getreaddata("head1"));
//			sf.assertEquals(pera, getreaddata("pera1"));	
		}
		
		public void validate2()
		{
			
		}
		
}
