package Amazon.EndtoEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Addtocart;
import pageobjects.CartItems;
import pageobjects.CeraveItems;
import resources.Base;

public class AmazonAddingMultipleItemstoCart extends Base {

	public static Logger Log = LogManager.getLogger(Base.class.getName());

	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		driver = InitializeDriver();
		Log.info("Driver is initialized");

	}

	@Test(description = "Adding multiple items", priority = 1)

	public void AddingMultipleItems() throws IOException, InterruptedException {

		CeraveItems beauty = new CeraveItems(driver);
		// Addtocart add = new Addtocart(driver); bad practice

		for (int i = 0; i < 3; i++) {
			driver.get(prop.getProperty("urlmulti"));

			if (i == 0) {
				Addtocart ad = beauty.serum(); // optimized method
				ad.addtocart();
				// System.out.println("Serum added to cart");
				Log.info("Serum added to cart");

			} else if (i == 1) {
				Addtocart ad = beauty.eyecream();
				ad.addtocart();
				// System.out.println("eyecream added to cart");
				Log.info("eyecream added to cart");

			} else if (i == 2) {

				Addtocart ad = beauty.soap();
				ad.addtocart();
				// System.out.println("soap added to cart");
				Log.info("Soap added to cart");

			}

		}

		driver.get(prop.getProperty("urlcart"));
		CartItems cart = new CartItems(driver);
		System.out.println(cart.NumberofItems().getText());
		Log.info(cart.NumberofItems().getText());

	}

	@Test(description = "Removing all items and verifying it", priority = 2)

	public void RemovingAllItems() throws IOException, InterruptedException {

		System.out.println("Deleting all items now");
		CartItems cart = new CartItems(driver);

		System.out.println(cart.deleteall().size());
		try {
			for (int i = 0; i < cart.deleteall().size(); i++) {
				cart.deleteall().get(i).click();
				i--;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Its because when you remove an element from a list, the list's elements move up. 
		//So if you remove first element i.e at index 0 the element at index 1 will be shifted to index 0 
		//but your loop counter will keep increasing in every iteration. 
		//so instead of getting the updated 0th index element you get 1st index element. 
		//So just decrease the counter by one every time you remove an element from your list.

		Log.info("Deleted all items>>" + cart.emptycart().getText());

	}

	@AfterTest
	public void Teardown() {
		driver.quit();
	}

}
