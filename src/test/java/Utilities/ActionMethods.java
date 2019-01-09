package Utilities;

import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionMethods extends BrowserSelect{

	/**
	 * @author DHIRESH
	 * Description: Clicking a button
	 */	
	public static void clickButton(String object,String property)
	{
		switch(property)
		{
		case "name":
			WebElement element=driver.findElement(By.name(object));
			element.click();
			break;
		case "id":
			WebElement element1=driver.findElement(By.id(object));
			element1.click();
			break;
		}
	}
	
	/**
	 * @author DHIRESH
	 * Description: Taking screenshot of the page
	 */	
	/*public static void captureScreenshot(String PageName)
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File source=screen.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(".\\target\\Screenshots\\"+PageName+".png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * @author DHIRESH
	 * Description: Wait for object to load on the page
	 */	
	public static void WaitTillObjectLoads(String Object, String ObjProperty) 
	{
		switch(ObjProperty)
		{
		case "name":
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.name(Object)));
		    break;
		case "xpath":
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Object)));
		    break;
		case "id":
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.id(Object)));
		    break;
		}
		
	}

	/**
	 * @author DHIRESH
	 * Description: Enter text in textbox
	 */	
	public static void EnterText(String TextBox, String Prop, String text)
	{
		switch(Prop)
		{
		case "name":
			WebElement element=driver.findElement(By.name(TextBox));
			element.sendKeys(text);
			break;
		case "xpath":
			WebElement element1=driver.findElement(By.xpath(TextBox));
			element1.sendKeys(text);
			break;
		case "id":
			WebElement element2=driver.findElement(By.xpath(TextBox));
			element2.sendKeys(text);
			break;
		}
	}

	/**
	 * @author DHIRESH
	 * Description: Clear text in textbox
	 */	
	public static void clearText(String TextBox, String ObjProp) {
		switch(ObjProp)
		{
		case "name":
			WebElement element=driver.findElement(By.name(TextBox));
			element.clear();
			break;
		case "xpath":
			WebElement element1=driver.findElement(By.xpath(TextBox));
			element1.clear();
			break;
		case "id":
			WebElement element2=driver.findElement(By.xpath(TextBox));
			element2.clear();
			break;
		}
		
	}

	/**
	 * @author DHIRESH
	 * Description: Get unit price from Catalog Page
	 */	
	public static Float GetUnitPrice(String ItemUnitPrice, String ObjProperty) 
	{
		float finalPrice=0;
		WebElement element = driver.findElement(By.xpath(ItemUnitPrice));
		String DollarPrice = element.getText();
		DollarPrice=DollarPrice.substring(2);
		finalPrice=Float.parseFloat(DollarPrice);
		return finalPrice;
	}
	
	/**
	 * @author DHIRESH
	 * Description: Get unit price from Catalog Page
	 */
	public static Float CalculatePrice(Float itemPrice, String orderQty) {
		float calcPrice=0;
		float qty=0;
		qty=Float.parseFloat(orderQty);
		calcPrice=itemPrice*qty;
		return calcPrice;
	}
	
	/**
	 * @author DHIRESH
	 * Description: Select credit card type
	 * @return 
	 */
	public static String SelectCard(String cardType, String Object) 
	{
			Select CCSelect = new Select(driver.findElement(By.name(Object)));
			CCSelect.selectByVisibleText(cardType);
			return cardType;
	}

	public static String VerifyFinalCard(String finalMethodofPay, String ObjProp) 
	{
		String CardText=driver.findElement(By.xpath(finalMethodofPay)).getText();
		System.out.println("The card text on receipt page is  => "+CardText);
		return CardText;
		
	}

}
