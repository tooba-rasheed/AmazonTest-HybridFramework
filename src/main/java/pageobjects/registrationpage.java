package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registrationpage {
	public WebDriver driver;
	private final By YourName = By.cssSelector("#ap_customer_name");
	private final By Email = By.cssSelector("#ap_email");
	private final By Password = By.cssSelector("#ap_password");
	private final By PasswordAgain = By.cssSelector("#ap_password_check");

	public registrationpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement name() {
		return driver.findElement(YourName);

	}
	
	public WebElement email() {
		return driver.findElement(Email);

	}
	
	public WebElement password() {
		return driver.findElement(Password);

	}
	
	public WebElement passwordcheck() {
		return driver.findElement(PasswordAgain);

	}
	



}
