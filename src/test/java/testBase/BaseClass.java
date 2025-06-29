package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseClass 
{
	
	public static WebDriver driver;
	public Logger logger;
	public Properties properties;
	
	//@BeforeClass(groups={"Sanity","Regression","Master"})
	@BeforeSuite(groups={"Sanity","Regression","Master"})
	@Parameters({"OS","Browser"})
	public void setUp(@Optional("Windows")String os,@Optional("chrome")String br) throws IOException 
	{
		try 
		{
		FileReader file= new FileReader("./src//test//resources//config.properties");
		properties=new Properties();
		properties.load(file);
	    } 
		catch (Exception e) 
		{
          e.printStackTrace();
        }
		
		
		logger = LogManager.getLogger(this.getClass());
		
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("Remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("Windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("Mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No Matching OS");
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("No Matching Browser");return;
			}
			
			driver=new RemoteWebDriver(new URL("http://192.168.0.114:4444/wd/hub"),capabilities);
		}
		
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("Local"))
		{
	
			switch (br.toLowerCase()) 
			{
			case "chrome": driver = new ChromeDriver(); break;
			case "edge"	: driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default: System.out.println("Invalid Browser Name");return;
			}
			}
			//driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(properties.getProperty("appURL"));
			driver.manage().window().maximize();
		
		}
	
	
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		String generatedNumber=RandomStringUtils.randomNumeric(3);
		return (generatedString+generatedNumber);
	}
	
	public String captureScreenshot(String screenshotName) {
        // Format timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        // Define screenshot path
        String destinationPath = "screenshots/" + screenshotName + "_" + timestamp + ".jpg";

        // Take screenshot
        TakesScreenshot takescreenshot = (TakesScreenshot) driver;
        File srcFile = (takescreenshot).getScreenshotAs(OutputType.FILE);
        
        File destFile = new File(destinationPath);
        
        try 
        {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved at: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destinationPath; // Return path for use in ExtentReports
    }

//	@AfterClass
//	public void tearDown() 
//	{
//		driver.quit();
//	}
}
