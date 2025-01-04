package applicationutility;

import org.openqa.selenium.WebElement;

public interface Applicationsutility 
{
	public void doubleclick(WebElement ele);
	public void rightclick(WebElement ele);
	public void click(WebElement ele);
	
	public void tabhandle(int tanno);
	public void windowhandle(int winno);
	
	public void uploadfile(String path);
	
	public String getDate_time();
	
	
	public void selectindex(WebElement ele, int ind);
	public void selectvisibletext(WebElement ele, String text);
	public void selectvalue(WebElement ele, String value);
	
	public void dropdown(WebElement ele);
	public void hover(WebElement ele);
	
	public WebElement shadodom(String url);
}

