package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
WebDriver driver;
	
public ProductsPage (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//select[@class='form-control']")
private WebElement searchProductDD;

@FindBy(xpath="//input[@type='text' and @class='form-control' and @placeholder='Search by product Id']")
private WebElement ProductId;

@FindBy(xpath="//button[span[text()='Add Product']]")
private WebElement AddProduct;

public WebElement getAddProduct() {
	return AddProduct;
}

public WebElement getSearchProductDD() {
	return searchProductDD;
}

public WebElement getProductId() {
	return ProductId;
}

}


	
	
	
