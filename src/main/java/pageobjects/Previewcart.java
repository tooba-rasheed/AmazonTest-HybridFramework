package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Previewcart {

	public WebDriver driver;
	private final By AddedOrNot = By.cssSelector("h1.a-size-medium.a-text-bold");
	

	public Previewcart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement addedconfirm() {
		return driver.findElement(AddedOrNot);

	}



}
