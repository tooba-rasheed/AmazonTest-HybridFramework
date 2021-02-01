package Amazon.EndtoEndProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.registrationpage;
import resources.Base;

public class DataDrivenSignup extends Base {
	public static Logger Log = LogManager.getLogger(Base.class.getName());

	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		driver = InitializeDriver();

	}

	@Test(dataProvider = "getTestData")
	public void Registration(String Name, String Email, String Password) throws InterruptedException {
		driver.get(prop.getProperty("urlsignup"));

		registrationpage register = new registrationpage(driver);

		register.name().clear();
		register.name().sendKeys(Name);

		register.email().clear();
		register.email().sendKeys(Email);

		register.password().clear();
		register.password().sendKeys(Password);

		register.passwordcheck().clear();
		register.passwordcheck().sendKeys(Password);

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = getDataFromExcel();
		return testData.iterator(); // for iterating elements of excel sheet in sequence

	}

	@AfterTest
	public void Teardown() {
		driver.quit();
	}
}
