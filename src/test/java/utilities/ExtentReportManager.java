package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	//public ITestContext testContext;
	String repname;
	
	public void onStart(ITestContext testContext)
	{
		SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String currentDateTimeStamp = df.format(dt);
		
		//String currentDateTimeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		repname="TestReport-" + currentDateTimeStamp+".html";
		
		//sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+repname);
		sparkReporter=new ExtentSparkReporter(".\\Reports\\"+repname);
		
		sparkReporter.config().setDocumentTitle("OpenCart Automation Report");
		sparkReporter.config().setReportName("OpenCart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("Environment", "SIT");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		
		
		String os = testContext.getCurrentXmlTest().getParameter("OS");
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("Browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
	}
	
	 public void onTestSuccess(ITestResult result)
	 {
		 test=extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.PASS,result.getName()+" got successfully executed.");
		 
	 }
	 
	 
	 public void onTestFailure(ITestResult result)
	 {
		 test=extent.createTest(result.getName());
		 test.assignCategory(result.getMethod().getGroups());
		 
		 test.log(Status.FAIL,result.getName()+" got failed.");
		 test.log(Status.INFO,result.getThrowable().getMessage());
		 
		 try 
		 {
		 BaseClass baseclass = new BaseClass();
		 String ssPath=baseclass.captureScreenshot(result.getName());
		 test.addScreenCaptureFromPath(ssPath);
		 }
		 catch (Exception e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 public void onTestSkipped(ITestResult result)
	 {
		 test=extent.createTest(result.getName());
		 test.assignCategory(result.getMethod().getGroups());
		 
		 test.log(Status.SKIP,result.getName()+" got skipped.");
		 test.log(Status.INFO,result.getThrowable().getMessage());
	 
	 }
	
	 public void onFinish(ITestContext context)
	 {
		 extent.flush();
		 
		 //Opens Extent report automatically in the Browser
		 String extentReportPath= System.getProperty("user.dir")+"\\reports\\"+repname;
		 File extentReport = new File(extentReportPath);
		 
		 try 
		 {
			 Desktop.getDesktop().browse(extentReport.toURI());

		 }
		 catch(Exception ex)
		 {
			ex.printStackTrace(); 
		 }
		 
		 //Automatically send the ExtentReport via email
		 
		/* try 
		 {
			 URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports"+repname);
			 
			 //Create the email message
			 ImageHtmlEmail email= new ImageHtmlEmail();
			 
			 email.setDataSourceResolver(new DataSourceUrlResolver(url));
			 email.setHostName("smtp.googleemail.com");
			 email.setSmtpPort(465);
			 email.setAuthenticator(new DefaultAuthenticator("morevinayak153@gmail.com", "Mvinayak@21"));
			 email.setSSLOnConnect(true);
			 email.setFrom("morevinayak153@gmail.com"); //Sender
			 email.setSubject("OpenCart Extent Report");
			 email.setMsg("Please find the attached report of Open Cart Automation Test Cases");
			 email.addTo("morevinayak153@gmail.com"); //Receiver
			 email.attach(url,"extent report","Please check Report...");
			 email.send();
			 
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }*/
		 
	 }
	 
	 


}
