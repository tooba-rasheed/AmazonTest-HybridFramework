package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartItems {

	
	public WebDriver driver;
	
	private final By itemprice =By.cssSelector(".a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold");
	private final By quantity= By.cssSelector("#a-autoid-0-announce");
	private final By quantity2=By.id("sc-update-quantity-select_2");
	private final By TotalAmount=By.xpath("//*[@id=\"sc-subtotal-amount-buybox\"]/span");
	private final By iphonename=By.xpath("//span[contains(text(),'Apple iPhone 11 Pro, 256GB, Midnight Green - Fully Unlocked (Renewed)')]");
	private final By NumberofItems=By.cssSelector(".a-row.a-spacing-mini.sc-subtotal.sc-subtotal-activecart.sc-java-remote-feature");
	private final By Deletesoap=By.xpath("//input[@name=\"submit.delete.C941c4dfe-4844-4ebf-b5dc-a4add7db52ba\"]");
	private final By Deleteeyecream=By.xpath("//input[@name=\"submit.delete.C33310f70-d4f5-488e-bec5-cf28a7a98938\"]");
	private final By Deleteserum=By.xpath("//input[@name=\"submit.delete.C5e1eae09-971a-484d-95f8-fd68f2fea155\"]");
	private final By emptycart=By.xpath("//h2[contains(text(),'Your Amazon Cart is empty')]");
	private final By deleteall=By.xpath("//input[@value=\"Delete\"]");
	
	public CartItems(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement cartprice()
	{
		return driver.findElement(itemprice);
	
	}
	
	public WebElement increasequantity()
	{
		return driver.findElement(quantity);
	}
	
	public WebElement increasequantityto2()
	{
		return driver.findElement(quantity2);
	}
	
	public WebElement Total()
	{
		return driver.findElement(TotalAmount);
	}
	
	public WebElement iphonename()
	{
		return driver.findElement(iphonename);
	}

	public WebElement NumberofItems()
	{
		return driver.findElement(NumberofItems);
	}
	
	public WebElement Deletesoap()
	{
		return driver.findElement(Deletesoap);
	}
	
	public WebElement Deleteeyecream()
	{
		return driver.findElement(Deleteeyecream);
	}
	
	public WebElement Deleteserum()
	{
		return driver.findElement(Deleteserum);
	}

	
	public WebElement emptycart()
	{
		return driver.findElement(emptycart);
	}
	
	public List<WebElement> deleteall()
	{
		return (List<WebElement>) driver.findElements(deleteall);
	}

}
