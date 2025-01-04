package baselibrary;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import applicationutility.Applicationsutility;
import excelutility.Excel_ReadData;
import propertiesFile.Check_Box_Propertiesfile;
import screenshotutility.ScreenShot;
import waitutility.Wait;


public class BaseLibrary implements Excel_ReadData , Check_Box_Propertiesfile , Applicationsutility , Wait ,ScreenShot
{
	
	public static WebDriver driver;
	
	public void getlaunchurl (String url , String browser)
	{
		if(browser.equals("chrome"))
		{
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		}
		else if(browser.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\nitis\\eclipse-workspace\\Automation_Framework\\drivers\\geckodriver.exe");
	    driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		}
		else if(browser.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\nitis\\eclipse-workspace\\Automation_Framework\\drivers\\msedgedriver.exe");
	    driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		}
	}
	

	@Override
	public String getreaddata(int sheet, int row, int coln) 
	{
	
		String path ="C:\\Users\\nitis\\eclipse-workspace\\Automation_Framework\\testdata\\nameaddress.xlsx";
		String out = "";
		
		try 
		{
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheetAt(sheet);
			for (int i = 0; i < 4; i++) 
			{
				out = sh.getRow(row).getCell(coln).getStringCellValue();
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		  return out;
	}

	

	@Override
	public String getreaddata(String key)
	{
		String path="C:\\Users\\nitis\\eclipse-workspace\\Automation_Framework\\testdata\\readiobtn.properties";
		String out="";
		try 
		{
			FileInputStream fis = new FileInputStream(path);
			Properties pro = new Properties();
			pro.load(fis);
			out = pro.getProperty(key);
		} 
		
		catch (Exception e) 
		{
			System.out.println("Issue in getreaddata : " +e);
		}
		return out;
		
	}

	@Override
	public void doubleclick(WebElement ele) 
	{
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
		
	}

	@Override
	public void rightclick(WebElement ele) 
	{
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}

	@Override
	public void click(WebElement ele) 
	{
		Actions act = new Actions(driver);
		act.click(ele).perform();
	}

	@Override
	public void tabhandle(int tanno) 
	{
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> handle = new ArrayList<String>(handles);
		driver.switchTo().window(handle.get(tanno));
	}
	
	@Override
	public void windowhandle(int winno) 
	{
		Set<String> handle = driver.getWindowHandles();
		ArrayList<String> winhndl = new ArrayList<String>(handle);
		driver.switchTo().window(winhndl.get(winno));
		
		
	}

	@Override
	public void uploadfile(String path) 
	{		
		
		try 
		{
			StringSelection stl = new StringSelection(path);
			Clipboard clp =Toolkit.getDefaultToolkit().getSystemClipboard();
			clp.setContents(stl, null);
			
			
			Robot rb = new Robot();
			rb.delay(500);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.delay(500);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.delay(500);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} 
		catch (Exception e) 
		{
			System.out.println("Issue in uploadFile "+e);
		}
		
	}


	@Override
	public void getScreenshot(String foldername, String filename) 
	{
		
		try
		{
			String loc = System.getProperty("user.dir");
			String finalpath = loc+"//screenshot//"+foldername+"//"+filename+".png";
			
			TakesScreenshot ts =(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(finalpath));
			
			
			
		}
		catch (Exception e) 
		{
			System.out.println("Issue in getting Screenshot" +e);
		}
	}
	
	@AfterMethod
	public void resultanalysis(ITestResult result)
	{
		String name = result.getMethod().getMethodName();
		String datetime = getDate_time();
		name = name+datetime;
		try 
		{
			if (result.getStatus()==ITestResult.SUCCESS)
			{
				getScreenshot("passed", name);
				
			}
			else if (result.getStatus()==ITestResult.FAILURE)
			{
				getScreenshot("fail", name);
				
			}
			
			else if (result.getStatus()==ITestResult.SKIP)
			{
				getScreenshot("skip", name);
				
			}
		}
		catch (Exception e) 
		{
			
		}
	}


	@Override
	public String getDate_time() 
	{
		String value ="";
		
		try
		{
			Date db = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			value =sf.format(db);
				
		}
		catch (Exception e) 
		{
			System.out.println("Issue in Getting Date And Time" +e);
		}
		return value;
		
	}


	@Override
	public void selectindex(WebElement ele, int ind)
	{
		Select sel = new Select(ele);
		sel.selectByIndex(ind);
	}


	@Override
	public void selectvisibletext(WebElement ele, String text) 
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}


	@Override
	public void selectvalue(WebElement ele, String value)
	{
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}


	@Override
	public void dropdown(WebElement ele) 
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		
	}


	@Override
	public void hover(WebElement ele) 
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}


	@Override
	public WebElement shadodom(String url)
	{
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		WebElement ele = (WebElement) js.executeScript("return arguments[0].shadowRoot", url);
		return ele;
	}
	
	@DataProvider(name="logincred")
	public Object[][] logincredentials()
	{
		return new Object[][] {{"username1" , "password1"} ,{"username2" , "password2"}, {"username3" , "password3"}};
	}


	@Override
	public void waitforclick(WebElement ele) 
	{
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, null).until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}


}



