package Amazon.EndtoEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class AmazonValidateTitle extends Base {
	
public static Logger Log=  LogManager.getLogger(Base.class.getName());
	
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =InitializeDriver();

	}
	

	@Test(description = "Validating title", priority = 1)

	public void Validatingtitle() throws IOException, InterruptedException {

	
		driver.get(prop.getProperty("urlhome"));
		String title=driver.getTitle();
		Assert.assertEquals(title, "Homepage");
		Log.info("TitleValidated");
		}
		
	@AfterTest
	public void Teardown() {
		driver.quit();
	}

}