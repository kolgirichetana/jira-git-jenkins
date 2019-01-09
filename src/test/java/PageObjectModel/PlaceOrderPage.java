package PageObjectModel;


import org.openqa.selenium.By;
import Utilities.ActionMethods;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PlaceOrderPage extends ActionMethods
{
	public static String ProceedOrderBtn="bSubmit"; //name, button
	public static String PlaceOrderPage = "//h1[text()='Place Order']"; //xpath, text
	public static String GrandTotalText = "//*[contains(text(),'Grand')]//following::strong"; //xpath, text
	/**
	 * @author DHIRESH
	 * Description: Click on Place order button
	 */
	public static void ClickProceedOrderBtn()
	{
		ActionMethods.clickButton(ProceedOrderBtn, "name");
	}
	
	/**
	 * @author DHIRESH
	 * Description: Verify landing on Place Order page
	 */
	public static void VerifyPlaceOrderPage()
	{
		ActionMethods.WaitTillObjectLoads(PlaceOrderPage, "xpath");
		Assert.assertTrue(driver.findElement(By.xpath(PlaceOrderPage)).isDisplayed());
		//ActionMethods.captureScreenshot("Place Order Page");
	}
	
	
	/**
	 * @author DHIRESH
	 * Description: Verify Grand Total Place Order page
	 */
	public static void VerifyGrandTotal()
	{
		Float GrandTotal=ActionMethods.GetUnitPrice(GrandTotalText, "xpath");
		Float CalculatedTaxedPrice=catalogPage.FinalTaxedPrice(catalogPage.FinalPrice);
		System.out.println("The calc price is "+CalculatedTaxedPrice+" The grand total is "+GrandTotal);
		Assert.assertEquals(GrandTotal, CalculatedTaxedPrice, 0.0f);
	}
	
}
