package Z_ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchingProduct {

	@Test
	public void testcase() {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demowebshop.tricentis.com/");
//	WebElement searchStore = driver.findElement(By.id("small-searchterms"));
//	searchStore.sendKeys("Computers");
//	driver.navigate().refresh();
//	searchStore.sendKeys("mobiles");
	POMClass objRepo=new POMClass(driver);
	objRepo.getSearchStore().sendKeys("Computers");
	driver.navigate().refresh();
	objRepo.getSearchStore().sendKeys("Mobiles");
	objRepo.getSearchBtn().click();
	

	}

}
