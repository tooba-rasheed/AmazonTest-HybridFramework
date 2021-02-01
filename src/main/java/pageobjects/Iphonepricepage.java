package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Iphonepricepage {

	public WebDriver driver;

	private final By priceofiphone11 = By.xpath("//span[@id='price_inside_buybox']");

	public Iphonepricepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement actualprice() {
		return driver.findElement(priceofiphone11);
	}

}
