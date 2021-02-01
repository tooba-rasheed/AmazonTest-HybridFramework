package Amazon.EndtoEndProject;

import java.io.IOException;
import java.util.Iterator;

import java.util.Set;

import pageobjects.Addtocart;

import pageobjects.CartItems;
import pageobjects.HomePage;
import pageobjects.IphoneSearchPage;
import pageobjects.Iphonepricepage;
import pageobjects.Previewcart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class AmazonAddingSameItemstoCart extends Base {

	public static Logger Log = LogManager.getLogger(Base.class.getName());

	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		driver = InitializeDriver();

	}

	@Test(description = "Adding an item to cart and verifying its price", priority = 1)

	public void HomePage() throws IOException, InterruptedException {

		driver.get(prop.getProperty("urlhome"));
		// driver.get("http://www.amazon.ca/");

		HomePage hp = new HomePage(driver);

		hp.search().click();
		hp.search().sendKeys("Iphone");
		IphoneSearchPage Is = hp.searchenter();

		Thread.sleep(3000);
		Addtocart cart = Is.iphone();

		/*
		 * List<WebElement> allproducts = Is.optimizediphone11();
		 * 
		 * for (int i = 0; i < allproducts.size(); i++) {
		 * 
		 * String name = allproducts.get(i).getText(); if (name.
		 * contains("Apple iPhone 7 Factory Unlocked CDMA/GSM Smartphone - 128GB, Rose Gold (Renewed)"
		 * )) { allproducts.get(i).click(); break; }
		 * 
		 * }
		 */

		Iphonepricepage IP = new Iphonepricepage(driver);
		String Actual = IP.actualprice().getText(); // Actual price
		// System.out.println(Actual);
		Log.info(Actual);

		Previewcart addingvalidation = cart.addtocart();

		if (addingvalidation.addedconfirm().getText().contains("Not added")) {
			// System.out.println("Cant Add, stock is low");
			Log.info("Cant Add, stock is low");
		} else {
			driver.get(prop.getProperty("urlcart"));
			CartItems ci = new CartItems(driver);
			String priceincart = ci.cartprice().getText(); // price showing in cart
			// System.out.println(priceincart);
			Log.info(priceincart);

			Assert.assertEquals(Actual, priceincart); // adding assertion for comparison to validate price
			// System.out.println("PRICE VALIDATED");
			Log.info("PRICE VALIDATED");

		}

	}

	@Test(description = "Increasing quantity of item by different methods and validating", priority = 2)
	public void Increasequantity() throws InterruptedException {

		CartItems ci = new CartItems(driver);
		ci.increasequantity().click();
		ci.increasequantityto2().click();

		// adding explicit wait over here
		WebDriverWait wait = new WebDriverWait(driver, 5); // Globally creating object for explicit waits interface
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//*[@id=\'sc-subtotal-label-activecart\']"), "Subtotal (2 items):"));

		// Thread.sleep(3000); //Not a good practice
		String TOTALPRICE = ci.Total().getText();
		// System.out.println("Increasing quantity of items to 2 directly from the
		// cart");
		// System.out.println("Total price of 2 items is:" + TOTALPRICE);
		Log.info("Increasing quantity of items to 2 directly from the cart");
		Log.info("Total price of 2 items is:" + TOTALPRICE);

		ci.iphonename().click();

		Set<String> windows = driver.getWindowHandles(); // A Set is a Collection that cannot contain duplicate elements

		Iterator<String> it = windows.iterator();
		it.next();
		String childId = it.next();
		System.out.println("Now I am in another window to add 1 more");

		driver.switchTo().window(childId); // I am switching to another tab

		Addtocart cart = new Addtocart(driver);

		Previewcart addingvalidation = cart.addtocart();

		if (addingvalidation.addedconfirm().getText().contains("Not added")) {
			// System.out.println("Cant Add, stock is low");
			Log.info("Cant Add, stock is low");
		}

		else {

			driver.get(prop.getProperty("urlcart"));
			// driver.get("https://www.amazon.ca/gp/cart/view.html?ref_=nav_cart");

			// System.out.println("Total Number of items increased by 1 more:" +
			// ci.NumberofItems().getText());
			Log.info("Total Number of items increased by 1 more:" + ci.NumberofItems().getText());
		}

	}

	@AfterTest
	public void Teardown() {
		driver.quit();
	}

}
