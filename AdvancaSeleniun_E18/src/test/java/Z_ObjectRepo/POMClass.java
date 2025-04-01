package Z_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMClass {
	
	WebDriver driver;
	
		public POMClass(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}

	@FindBy(id="small-searchterms")
private	WebElement searchStore;
	
	public WebElement getSearchStore() {
		return searchStore;
	}

	public void setSearchStore(WebElement searchStore) {
		this.searchStore = searchStore;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(WebElement searchBtn) {
		this.searchBtn = searchBtn;
	}

	@FindBy(xpath="//input[@type='submit']")
	private	WebElement searchBtn;
	
	
	
	

}
