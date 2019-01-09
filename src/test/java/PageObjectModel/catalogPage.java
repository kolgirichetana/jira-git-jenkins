package PageObjectModel;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import Utilities.ActionMethods;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class catalogPage extends ActionMethods {
	public static String TentQtyBox="QTY_TENTS"; //name, textbox
	public static String BackpackQtyBox="QTY_BACKPACKS"; //name, textbox
	public static String SunglassesBox="QTY_GLASSES"; //name, textbox
	public static String SocksBox="QTY_SOCKS"; //name, textbox
	public static String BootsBox="QTY_BOOTS"; //name, textbox
	public static String ShortsBox="QTY_SHORTS"; //name, textbox
	public static String ResetBtn="bReset"; //name, button
	public static String SubmitBtn="bSubmit"; //name, button
	public static String CatalogPage="//h1[text()='OnLine Catalog']"; //xpath, text
	public static String TentsUnitPrice="//tr[2]/td[3]"; //xpath, text
	public static String BackPackUnitPrice="//tr[3]/td[3]"; //xpath, text
	public static String SunglassUnitPrice="//tr[4]/td[3]"; //xpath, text
	public static String SocksUnitPrice="//tr[5]/td[3]"; //xpath, text
	public static String BootsUnitPrice="//tr[6]/td[3]"; //xpath, text
	public static String ShortsUnitPrice="//tr[7]/td[3]"; //xpath, text
	public static float FinalPrice=0;
		
	public static void ClickResetBtn()
	{
		ActionMethods.clickButton(ResetBtn, "name");
	}
	
	public static void ClickSubmitBtn()
	{
		ActionMethods.clickButton(SubmitBtn, "name");
	}
	
	public static void SunglassBoxQty(String OrderQty)
	{
		ActionMethods.EnterText(SunglassesBox,"name",OrderQty);
		Float ItemPrice=ActionMethods.GetUnitPrice(SunglassUnitPrice,"xpath");
		Float CalcPrice=ActionMethods.CalculatePrice(ItemPrice,OrderQty);
		FinalPrice=FinalPrice+CalcPrice;
	}
	
	public static void VerifyCatalogPage()
    {
    	ActionMethods.WaitTillObjectLoads(CatalogPage,"xpath");
    	Assert.assertTrue(driver.findElement(By.xpath(CatalogPage)).isDisplayed());
    //	ActionMethods.captureScreenshot("Catalog page");
    }
	
	
	public static float FinalTaxedPrice(float FinalPrice)
	{
		float taxedPrice=(float)(FinalPrice*1.05);  //5% tax
		taxedPrice=taxedPrice + 5; //Shipment Charges
		DecimalFormat df = new DecimalFormat("###.##");
		String roundPrice=df.format(taxedPrice);
		taxedPrice= Float.parseFloat(roundPrice);
		return taxedPrice;
	}

	public static void EnterItemQuantity(String OrderQty, String item) {
		switch(item)
		{
		case "Tents":
			ActionMethods.clearText(TentQtyBox, "name");
			ActionMethods.EnterText(TentQtyBox,"name",OrderQty);
			Float ItemPrice=ActionMethods.GetUnitPrice(TentsUnitPrice,"xpath");
			Float CalcPrice=ActionMethods.CalculatePrice(ItemPrice,OrderQty);
			FinalPrice=FinalPrice+CalcPrice;
			break;
		case "Backpack":
			ActionMethods.clearText(BackpackQtyBox, "name");
			ActionMethods.EnterText(BackpackQtyBox,"name",OrderQty);
			Float ItemPrice1=ActionMethods.GetUnitPrice(BackPackUnitPrice,"xpath");
			Float CalcPrice1=ActionMethods.CalculatePrice(ItemPrice1,OrderQty);
			FinalPrice=FinalPrice+CalcPrice1;
			break;
		case "Sunglass":
			ActionMethods.clearText(SunglassesBox, "name");
			ActionMethods.EnterText(SunglassesBox,"name",OrderQty);
			Float ItemPrice2=ActionMethods.GetUnitPrice(SunglassUnitPrice,"xpath");
			Float CalcPrice2=ActionMethods.CalculatePrice(ItemPrice2,OrderQty);
			FinalPrice=FinalPrice+CalcPrice2;
			break;
		case "Socks":
			ActionMethods.clearText(SocksBox, "name");
			ActionMethods.EnterText(SocksBox,"name",OrderQty);
			Float ItemPrice3=ActionMethods.GetUnitPrice(SocksUnitPrice,"xpath");
			Float CalcPrice3=ActionMethods.CalculatePrice(ItemPrice3,OrderQty);
			FinalPrice=FinalPrice+CalcPrice3;
			break;
		case "Boots":
			ActionMethods.clearText(BootsBox, "name");
			ActionMethods.EnterText(SocksBox,"name",OrderQty);
			Float ItemPrice4=ActionMethods.GetUnitPrice(SocksUnitPrice,"xpath");
			Float CalcPrice4=ActionMethods.CalculatePrice(ItemPrice4,OrderQty);
			FinalPrice=FinalPrice+CalcPrice4;
			break;
		case "Shorts":
			ActionMethods.clearText(ShortsBox, "name");
			ActionMethods.EnterText(ShortsBox,"name",OrderQty);
			Float ItemPrice5=ActionMethods.GetUnitPrice(ShortsUnitPrice,"xpath");
			Float CalcPrice5=ActionMethods.CalculatePrice(ItemPrice5,OrderQty);
			FinalPrice=FinalPrice+CalcPrice5;
			break;
		}
		
	}
	
}
