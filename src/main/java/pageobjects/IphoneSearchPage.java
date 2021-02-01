package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class IphoneSearchPage {

	public WebDriver driver;

	//private final By optimizedIphone11 = By.cssSelector("h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-4");
	private final By selectiphone = By.xpath("//span[contains(text(),'Apple iPhone 11 Pro, 256GB, Midnight Green - Fully Unlocked (Renewed)')]");

	public IphoneSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	/*public List<WebElement> optimizediphone11() {

		return (List<WebElement>) driver.findElements(optimizedIphone11); //typecasted return type

	}*/
	
	public Addtocart iphone() {
		driver.findElement(selectiphone).click();
		Addtocart ad = new Addtocart(driver);
		return ad;
	}

}
