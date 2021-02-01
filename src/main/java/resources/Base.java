package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	static Xls_Reader reader;

	public WebDriver InitializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Tooba\\eclipse-workspace\\EndtoEndProject\\src\\main\\java\\resources\\Data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Tooba\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if (browserName.equals("Firefox")) {
			// System.setProperty("webdriver.gecko.driver", "path for gecko driver");
			// driver= new FirefoxDriver();
		}

		else if (browserName.equals("IE")) {
			// System.setProperty("webdriver.IE.driver", "path for IE driver");
			// driver= new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	

		public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
			FileUtils.copyFile(source, new File(destinationFile));
			return destinationFile;

		
	}
		
		public ArrayList<Object[]> getDataFromExcel(){
			ArrayList<Object[]> myData= new ArrayList<Object[]>();
			
			try {
				reader= new Xls_Reader("C:\\Users\\Tooba\\eclipse-workspace\\EndtoEndProject\\src\\main\\java\\resources\\Signupdata.xlsx");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			for(int rowNum=2; rowNum<=reader.getRowCount("Amazonsignup"); rowNum++) {
				String Name=reader.getCellData("Amazonsignup", "Name", rowNum);
				String Email=reader.getCellData("Amazonsignup", "Email", rowNum);
				String Password=reader.getCellData("Amazonsignup", "Password" , rowNum);
				
				Object obj[]= {Name, Email, Password};
				myData.add(obj);
			}
			return myData;
		}
	
}
