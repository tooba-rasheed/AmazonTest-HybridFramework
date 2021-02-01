package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	private final By search = By.cssSelector("[id='twotabsearchtextbox']");
	private final By searchenter = By.cssSelector("[id='nav-search-submit-button']");
	private final By accountsandlist = By.cssSelector("#nav-link-accountList");
	private final By signin = By.cssSelector("#nav-al-signin");
	private final By hello = By.cssSelector("#nav-link-accountList-nav-line-1");

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement search() {
		return driver.findElement(search);

	}

	public IphoneSearchPage searchenter() {
		driver.findElement(searchenter).click();
		IphoneSearchPage Is = new IphoneSearchPage(driver);
		return Is;

	}
	
	public WebElement accountsandList() {
		return driver.findElement(accountsandlist);

	}
	
	public loginpage signin() {
		driver.findElement(signin).click();
		loginpage login =new loginpage(driver);
		return login;
		

	}
	
	public WebElement hello() {
		return driver.findElement(hello);

	}

}
