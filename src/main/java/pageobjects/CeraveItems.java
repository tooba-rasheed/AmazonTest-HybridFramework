package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CeraveItems {
	
	public WebDriver driver;
	
	private final By Eyecream=By.xpath("//span[contains(text(),'CeraVe Eye Repair Cream Eye Cream with Hyaluronic Acid To Reduces the Look Of Dark circles & Puffiness Ophthalmologist Tested for Sensitive Eye Area Fragrance Free, 14.2 Grams')]");
	private final By soap=By.xpath("//span[contains(text(),'CeraVe Hydrating Cleansing Bar Soap-Free Body and Face Cleanser Bar with Hyaluronic Acid and Ceramides Fragrance Free & Non-Irritating, 128 Grams')]");
	private final By serum=By.xpath("//span[contains(text(),'CeraVe Anti aging retinol Serum for Face | Cream Serum to help Smooth Fine Lines | Fragrance Free, 30 Milliliters')]");

	
	public CeraveItems(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public Addtocart eyecream()
	{
		driver.findElement(Eyecream).click();
		Addtocart ad = new Addtocart(driver);
		return ad;

	}
	
	public Addtocart soap()
	{
		driver.findElement(soap).click();
		Addtocart ad = new Addtocart(driver);
		return ad;

	}
	
	public Addtocart serum()
	{
		driver.findElement(serum).click();
		Addtocart ad = new Addtocart(driver);
		return ad;
	}
	
}