package Amazon.EndtoEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.loginpage;
import pageobjects.loginpagecontinuePW;
import resources.Base;

public class AmazonLogin extends Base {
	public static Logger Log = LogManager.getLogger(Base.class.getName());

	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		driver = InitializeDriver();

	}

	@Test(priority = 0, dataProvider = "getData")

	public void loginPagaNavigation(String Email, String Password, String Text) {
		driver.get(prop.getProperty("urlhome"));
		HomePage home = new HomePage(driver);
		Actions action = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(home.accountsandList()));

		action.moveToElement(home.accountsandList()).build().perform();
		loginpage login = home.signin();
		login.typeemail().sendKeys(Email);

		login.continuelogin();

		loginpagecontinuePW continu = new loginpagecontinuePW(driver);

		boolean isElementPresent;

		try {
			isElementPresent = continu.wrongpassword().isDisplayed();
		} catch (Exception e) {
			isElementPresent = false;
		}
		if (isElementPresent) {
			Log.info("Wrong id");
		} else {

			continu.password().sendKeys(Password);
			Log.info(Text);
			continu.signin().click();

			if (Text.equals("Valid")) {
				if (home.hello().getText().contains("Hello, Demo")) {

					action.moveToElement(home.accountsandList()).build().perform();
					driver.findElement(By.cssSelector("#nav-item-signout")).click();
					Assert.assertTrue(true);
				}

				else {
					Assert.assertTrue(false);
				}
			}

			else if (Text.equals("Invalid")) {
				if (home.hello().getText().contains("Hello, Demo")) {

					action.moveToElement(home.accountsandList()).build().perform();
					driver.findElement(By.cssSelector("#nav-item-signout")).click();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(true);
				}

			}

		}
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][3];
		// 0th row
		data[0][0] = "tooba.rasheed94@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "Invalid";
		// 1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Invalid";

		data[2][0] = "tooba.salman90@gmail.com";
		data[2][1] = "Amazontest";
		data[2][2] = "Valid";

		return data;

	}

}
