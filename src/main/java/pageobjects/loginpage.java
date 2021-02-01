package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage {
	

	public WebDriver driver;
	
	private final By email=By.id("ap_email");
	private final By continuelogin=By.id("continue");


	public loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement typeemail()
	{
		return driver.findElement(email);
	}
	
	public loginpagecontinuePW continuelogin()
	{
		driver.findElement(continuelogin).click();
		loginpagecontinuePW continu=new loginpagecontinuePW(driver);
		return continu;
		
	}

}
