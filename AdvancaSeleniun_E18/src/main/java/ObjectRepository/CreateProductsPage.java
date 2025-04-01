package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateProductsPage {

	WebDriver driver;
	
	public CreateProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="productName")
	private WebElement productName;
	
	@FindBy(xpath="//select[@name='productCategory']")
	private WebElement selectCategoryDD;
	
	@FindBy(name="quantity")
	private WebElement quantity;
	
	@FindBy(name="price")
	private WebElement pricePerUnit;
	
	@FindBy(xpath="//select[@name='vendorId']")
	private WebElement selectVndrDD;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement addBtn;

	
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSelectCategoryDD() {
		return selectCategoryDD;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPricePerUnit() {
		return pricePerUnit;
	}

	public WebElement getSelectVendorDD() {
		return selectVndrDD;
	}
	
	public WebElement getaddBtn() {
		return addBtn;
	}

		public void addProductWithmandatoryFields(String prodName, String qty, String price  )
	{
		productName.sendKeys(prodName);
		quantity.clear();
		quantity.sendKeys(qty);
		pricePerUnit.sendKeys(price);
		
		WebDriverUtility wUtil= new WebDriverUtility();
		wUtil.select(selectCategoryDD, 1);
		wUtil.select(selectVndrDD, "VID_001");
        addBtn.click();
		
	}

}
