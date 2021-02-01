package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpagecontinuePW {
	
public WebDriver driver;
	
	private final By password=By.cssSelector("#ap_password");
	private final By Wrongpassword=By.cssSelector("#auth-error-message-box > div > div > ul > li > span");
	private final By SigninButton=By.cssSelector("#signInSubmit");
	

	


	public loginpagecontinuePW(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement wrongpassword()
	{
		return driver.findElement(Wrongpassword);
	}
	
	public WebElement signin()
	{
		return driver.findElement(SigninButton);
	}
	
		
}
