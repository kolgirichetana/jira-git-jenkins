package PageObjectModel;


import org.openqa.selenium.By;

import Utilities.ActionMethods;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BillingInfoPage extends ActionMethods
{
	public static String BillNameBox="billName"; //name, textbox
	public static String BillAddressBox="billAddress";  //name, textbox
	public static String BillCityBox="billCity";  //name, textbox
	public static String BillStateBox="billState";  //name, textbox
	public static String BillZipBox="billZipCode";  //name, textbox
	public static String BillPhoneBox="billPhone";  //name, textbox
	public static String BillEmailBox="billEmail";  //name, textbox
	public static String BillCCType="CardType"; //name, 
	public static String BillCreditCardNumber="CardNumber"; //name, textbox
	public static String BillCCExpiryNumber="CardDate"; //name, textbox
	public static String ShipSameAsBillCheckbox="shipSameAsBill";  //name, Checkbox
	public static String PlaceOrderBtn="bSubmit"; //name, button
	public static String BillingInfoPage = "//h1[text()='Billing Information']"; //xpath, Text
	
	public static String FinalCCSelected=null;
	
	/**
	 * @author DHIRESH
	 * Description: Enter name on Billing information page
	 */	
	public static void enterBillName(String bName)
	{
		ActionMethods.clearText(BillNameBox,"name");
		ActionMethods.EnterText(BillNameBox,"name",bName);
	}
	
	/**
	 * @author DHIRESH
	 * Description: Enter address on Billing information page
	 */	
	public static void enterBillAddress(String bAddress)
	{
		ActionMethods.clearText(BillAddressBox,"name");
		ActionMethods.EnterText(BillAddressBox,"name",bAddress);
	}
	
	/**
	 * @author DHIRESH
	 * Description: Enter city on Billing information page
	 */	
	public static void enterBillCity(String bCity)
	{
		ActionMethods.clearText(BillCityBox,"name");
		ActionMethods.EnterText(BillCityBox,"name",bCity);
	}
	
	/**
	 * @author DHIRESH
	 * Description: Enter state on Billing information page
	 */	
	public static void enterBillState(String bState)
	{
		ActionMethods.clearText(BillStateBox,"name");
		ActionMethods.EnterText(BillStateBox,"name",bState);
	}
	
	/**
	 * @author DHIRESH
	 * Description: Enter Zipcode on Billing information page
	 */	
	public static void enterBillZipcode(String bZip)
	{
		ActionMethods.clearText(BillZipBox,"name");
		ActionMethods.EnterText(BillZipBox,"name",bZip);
	}

	/**
	 * @author DHIRESH
	 * Description: Enter Phone number on Billing information page
	 */	
	public static void enterBillPhone(String bPhone)
	{
		ActionMethods.clearText(BillPhoneBox,"name");
		ActionMethods.EnterText(BillPhoneBox,"name",bPhone);
	}
	
	/**
	 * @author DHIRESH
	 * Description: Enter email on Billing information page
	 */	
	public static void enterBillEmail(String bEmail)
	{
		ActionMethods.clearText(BillEmailBox,"name");
		ActionMethods.EnterText(BillEmailBox,"name",bEmail);
	}
	
	/**
	 * @author DHIRESH
	 * Description: Enter Card Number on Billing information page
	 */	
	public static void enterCardNumber(String bCCNumber)
	{
		ActionMethods.clearText(BillCreditCardNumber,"name");
		ActionMethods.EnterText(BillCreditCardNumber,"name",bCCNumber);
	}
	
	/**
	 * @author DHIRESH
	 * Description: Enter Card Expiry Date on Billing information page
	 */	
	public static void enterCardExpiry(String bCCExpiry)
	{
		ActionMethods.clearText(BillCCExpiryNumber,"name");
		ActionMethods.EnterText(BillCCExpiryNumber,"name",bCCExpiry);
	}
	
	/**
	 * @author DHIRESH
	 * Description: Click the Same as Bill checkbox on Billing information page
	 */
	public static void ClickSameAsBill()
	{
		ActionMethods.clickButton(ShipSameAsBillCheckbox, "name");
	}
	
	/**
	 * @author DHIRESH
	 * Description: Click the place order button on Billing information page
	 */
	public static void ClickPlaceOrderButton()
	{
		ActionMethods.clickButton(PlaceOrderBtn, "name");
	}
	
	/**
	 * @author DHIRESH
	 * Description: Verify landing on Billing Info page
	 */
	public static void VerifyBillingInfoPage()
	{
		ActionMethods.WaitTillObjectLoads(BillingInfoPage, "xpath");
		Assert.assertTrue(driver.findElement(By.xpath(BillingInfoPage)).isDisplayed());
		//ActionMethods.captureScreenshot("Billing Information Page");
	}

	/**
	 * @author DHIRESH
	 * Description: Verify landing on Billing Info page
	 */
	public static void SelectCCType(String cardType) 
	{
		FinalCCSelected = ActionMethods.SelectCard(cardType,BillCCType);
		System.out.println("The selected credit card is => "+FinalCCSelected);
	}
}

