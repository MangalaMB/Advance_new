package ProductTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.CreateProductsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductsPage;

//@Listeners
public class CreateProduct {

	@Test()  
	//(groups= "Integration")
	public void addProductTest() throws IOException, InterruptedException {
		PropertiesFileUtility propUtil=new PropertiesFileUtility();
		String BROWSER = propUtil.readingDataFromPropFile("browser");
		String URL = propUtil.readingDataFromPropFile("url");
		String UN = propUtil.readingDataFromPropFile("uname");
		String PWD = propUtil.readingDataFromPropFile("pwd");
		
		JavaUtility jutil=new JavaUtility();
		int randNum = jutil.getRandomNum(2000);
		ExcelFileUtility excelUtil=new ExcelFileUtility();
		String prodName = excelUtil.readingDataFromExcel("Product", 1, 2)+randNum;
		String quantity = excelUtil.readingDataFromExcel("Product", 1, 3);
		String price = excelUtil.readingDataFromExcel("Product", 1, 4);
		
//		System.out.println("prodName: "+prodName);
//		System.out.println("quantity: "+quantity);
//		System.out.println("price: "+price);	
		
		//Launching the browser
		WebDriver driver=null;
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
		dp.getProductsLink().click();
		
		ProductsPage pp=new ProductsPage(driver);
		pp.getAddProduct().click();
		
		CreateProductsPage cpp= new CreateProductsPage(driver);
		cpp.addProductWithmandatoryFields(prodName, quantity, price);
		
		Thread.sleep(2000);
		//verification of dashboard
//		driver.findElement(By.linkText("Products")).click();
//		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
//		driver.findElement(By.name("productName")).sendKeys(prodName);
//		WebElement categatoryDD = driver.findElement(By.name("productCategory"));
//		WebDriverUtility Wutil=new WebDriverUtility();
//		Wutil.select(categatoryDD, "Others");
//		driver.findElement(By.name("quantity")).sendKeys(quantity);
//		driver.findElement(By.name("price")).sendKeys(price);
//		WebElement vendorDD = driver.findElement(By.name("vendorId"));
//		Wutil.select(vendorDD, "VID_015");
//		driver.findElement(By.xpath("//button[text()='Add']")).click();
//		Thread.sleep(5000);
		String confMsg = driver.findElement(By.xpath("//div[text()='Product "+prodName+" Successfully Added']")).getText();
		if(confMsg.contains(prodName))
		{
			Reporter.log("Product added successfully");
		}
		else
		{
			Reporter.log("Product not added");
		}
		Thread.sleep(2000);
		//logout
//		DashboardPage dp=new DashboardPage(driver);
//		dp.logout();
//        close the browser
        driver.quit();
	}
		
	}


 