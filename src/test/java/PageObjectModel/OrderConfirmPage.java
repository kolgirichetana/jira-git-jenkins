package PageObjectModel;

import org.openqa.selenium.By;
import Utilities.ActionMethods;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class OrderConfirmPage extends ActionMethods {

	public static String orderConfirmPage = "//h1[text()='OnLine Store Receipt']"; //xpath, Text
	public static String ReturnHomeBtn="bSubmit"; //name, button
	public static String finalMethodofPay="//*[contains(text(),'Payment:')]//following::strong"; //xpath, text
	public static String ReceiptAmount="//strong[contains(text(),'Grand')]//following::strong"; //xpath, text
	
	/**
	 * @author DHIRESH
	 * Description: Verify Order confirmation page
	 */	
	public static void verifyOrderConfirmPage()
	{
		ActionMethods.WaitTillObjectLoads(orderConfirmPage, "xpath");
		Assert.assertTrue(driver.findElement(By.xpath(orderConfirmPage)).isDisplayed());
		//ActionMethods.captureScreenshot("Order Confirmation Page");
	}
	
	
	/**
	 * @author DHIRESH
	 * Description: Click Return to Home page
	 */	
	public static void ClickReturnHomeBtn()
	{
		ActionMethods.clickButton(ReturnHomeBtn, "name");
	}
	
	
	/**
	 * @author DHIRESH
	 * Description: Verify Method of Payment
	 */	
	public static void VerifyMOP()
	{
		String ReceiptCC=ActionMethods.VerifyFinalCard(finalMethodofPay,"xpath");
		Assert.assertEquals(BillingInfoPage.FinalCCSelected, ReceiptCC);
	}
	
	
	/**
	 * @author DHIRESH
	 * Description: Verify Grand Total Amount
	 */
	public static void verifyReceiptAmount()
	{
		Float ReceiptAmt = ActionMethods.GetUnitPrice(ReceiptAmount, "name");
		Float CalcPrice = catalogPage.FinalTaxedPrice(catalogPage.FinalPrice);
		Assert.assertEquals(CalcPrice, ReceiptAmt, 0.0f);
		catalogPage.FinalPrice=0;
	}

}
