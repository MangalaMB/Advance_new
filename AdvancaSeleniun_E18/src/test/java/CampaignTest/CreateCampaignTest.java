package CampaignTest;

import java.io.IOException;
import java.time.Duration;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import Z_DDTPractice.DataProviderUsage;
import genericBaseClassUtility.BaseClass;
import genericListnerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class CreateCampaignTest extends BaseClass{
	
//	@Parameters("browser")
// @Test (invocationCount = 4, threadPoolSize = 4, priority=1)
// @Test (enabled = false)
	@Test()
//	(dataProvider="getData")
	public void createCampaignTest() throws IOException, InterruptedException {
	PropertiesFileUtility propUtil=new PropertiesFileUtility();
	String BROWSER = propUtil.readingDataFromPropFile("browser");
//	String BROWSER=browser;
	String URL = propUtil.readingDataFromPropFile("url");
	String UN = propUtil.readingDataFromPropFile("uname");
	String PWD = propUtil.readingDataFromPropFile("pwd");
	
	JavaUtility jUtil=new JavaUtility();
	int randomNum = jUtil.getRandomNum(5000);
	
	ExcelFileUtility exUtil=new ExcelFileUtility();
	String Campaign = exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
	String targetSize = exUtil.readingDataFromExcel("DDT", 1, 3);
	
	String expectedURL="http://49.249.28.218:8098/dashboard";
	//Launching the browser	
	WebDriver driver=null;	
//	ChromeOptions Coption=new ChromeOptions();	
//	FirefoxOptions Foption=new FirefoxOptions();	
//	EdgeOptions Eoption=new EdgeOptions();	
//	Coption.addArguments("--headless");	
//	Foption.addArguments("--headless");	
//	Eoption.addArguments("--headless");	
	if(BROWSER.equalsIgnoreCase("chrome"))	
	{	
		driver=new ChromeDriver();
	}	
	else if(BROWSER.equalsIgnoreCase("firefox"))	
	{	
		driver=new FirefoxDriver();
	}	
	else if(BROWSER.equalsIgnoreCase("edge"))	
	{	
		driver=new EdgeDriver();
	}	
	else	
	{	
		driver=new ChromeDriver();
	}	
	driver.manage().window().maximize();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	//navigating to ninza CRM	
	driver.get(URL);	

	LoginPage lp=new LoginPage(driver);
	lp.login(UN, PWD);
	DashboardPage dp=new DashboardPage(driver);
	Thread.sleep(2000);
	dp.getCampaignsLink().click();
	CampaignsPage cp=new CampaignsPage(driver);
	cp.getCreateCampaignBtn().click();
	CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
	ccp.createCampaignWithmandatoryFields(Campaign, targetSize);
	Thread.sleep(5000);
	String ConfMsg = cp.getConfMsg().getText();
	boolean status = ConfMsg.contains(Campaign);
	Assert.assertEquals(status, true, "Campaign not added");
		//Assert.assertTrue(status, "Campaign not added");
	Reporter.log("Campaign " +Campaign+" added successfully",true);
//	
//	if(ConfMsg.contains(Campaign))
//	{
//		Reporter.log("campaign "+Campaign+" added successfully");
//	}
//	else
//	{
//		Reporter.log("campaign not added");
//	}
	Thread.sleep(5000);
	dp.logout();
    //close the browser
    driver.quit();
	}
//	@Parameters("browser")
	@Test  (priority=1,groups= "Regression")
//	@Test  (dependsOnMethods = "createCampaignTest")
 public void createCampaignWithDateTest()throws IOException, InterruptedException {
 	PropertiesFileUtility propUtil=new PropertiesFileUtility();
 	String BROWSER = propUtil.readingDataFromPropFile("browser");
// 	String BROWSER=browser;
 	String URL = propUtil.readingDataFromPropFile("url");
 	String UN = propUtil.readingDataFromPropFile("uname");
 	String PWD = propUtil.readingDataFromPropFile("pwd");
 	
 	JavaUtility jUtil=new JavaUtility();
 	int randomNum = jUtil.getRandomNum(5000);
 	
 	ExcelFileUtility exUtil=new ExcelFileUtility();
 	String Campaign = exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
 	String targetSize = exUtil.readingDataFromExcel("DDT", 1, 3);
 //	
// 	System.out.println("Campaign: " + Campaign);
// 	System.out.println("targetSize: "+targetSize);
 	
 	String closeDate = jUtil.generateReqDate(30);
 	
 	String expectedURL="http://49.249.28.218:8098/dashboard";
 	//Launching the browser
 	WebDriver driver=null;	
 	ChromeOptions Coption=new ChromeOptions();	
 	FirefoxOptions Foption=new FirefoxOptions();	
 	EdgeOptions Eoption=new EdgeOptions();	
// 	Coption.addArguments("--headless");	
// 	Foption.addArguments("--headless");	
// 	Eoption.addArguments("--headless");	
 	if(BROWSER.equalsIgnoreCase("chrome"))	
 	{	
 		driver=new ChromeDriver();
 	}	
 	else if(BROWSER.equalsIgnoreCase("firefox"))	
 	{	
 		driver=new FirefoxDriver();
 	}	
 	else if(BROWSER.equalsIgnoreCase("edge"))	
 	{	
 		driver=new EdgeDriver();
 	}	
 	else	
 	{	
 		driver=new ChromeDriver();
 	}	

 	driver.manage().window().maximize();
 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 	//navigating to ninza CRM
 	driver.get(URL);
 	//enter the username and password
 	LoginPage lp=new LoginPage(driver);
 	lp.login(UN, PWD);
 		
 	
 	DashboardPage dp=new DashboardPage(driver);
 	Thread.sleep(2000);
 	
 	dp.getCampaignsLink().click();
 	CampaignsPage cp=new CampaignsPage(driver);
 	cp.getCreateCampaignBtn().click();
 	CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
 	ccp.createCampaignWithCloseDate(Campaign, targetSize,closeDate);
 	Thread.sleep(5000);
 	String ConfMsg = cp.getConfMsg().getText();
	boolean status = ConfMsg.contains(Campaign);
	Assert.assertEquals(status, true, "Campaign not added");
		//Assert.assertTrue(status, "Campaign not added");
	Reporter.log("Campaign " +Campaign+" added successfully",true);
 	
// 	if(ConfMsg.contains(Campaign))
// 	{
// 		Reporter.log("campaign "+Campaign+" added successfully");
// 	}
// 	else
// 	{
// 		Reporter.log("campaign not added");
// 	}
 	Thread.sleep(5000);
 	dp.logout();
//     close the browser
 	
     driver.quit();

 }


}

