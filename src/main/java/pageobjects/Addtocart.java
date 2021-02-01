package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Addtocart {

	public WebDriver driver;

	private final By addtocart = By.cssSelector("#add-to-cart-button");

	public Addtocart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public Previewcart addtocart() {
		driver.findElement(addtocart).click();
		Previewcart addingvalidation = new Previewcart(driver);
		return addingvalidation;
	}

}
