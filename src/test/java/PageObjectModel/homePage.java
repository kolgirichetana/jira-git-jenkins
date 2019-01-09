package PageObjectModel;

import org.openqa.selenium.By;

import Utilities.ActionMethods;

import junit.framework.Assert;



/**
 * Unit test for simple App.
 */
@SuppressWarnings("deprecation")
public class homePage extends ActionMethods
{
    public static String EnterGMObtn="bSubmit";  //name, button
    public static String AboutGMObtn="bAbout";  //name, button
    public static String BrowserTestbtn="bBrowserTest"; //name, button
    public static String GMOHomePage = "//*[text()='GMO OnLine']"; //Xpath, Text
    public static String AboutGMOPage = "//h1[text()='About This Site']"; //Xpath, Text
    public static String GMOTestPage = "//img[@alt='Netscape']"; //Xpath, Text
    
    //Click button to enter GMO site
    public static void ClickEnterGMObtn()
    {
    	ActionMethods.clickButton(EnterGMObtn,"name");
    }
    //Click button to know about GMO site
    public static void ClickAboutGMObtn()
    {
    	ActionMethods.clickButton(AboutGMObtn,"name");
    }
    //Click button for Browser Test page
    public static void ClickBrowserTestbtn()
    {
    	ActionMethods.clickButton(BrowserTestbtn,"name");
    }

    public static void VerifyGmoHomePage()
    {
    	ActionMethods.WaitTillObjectLoads(GMOHomePage,"xpath");
    	Assert.assertTrue(driver.findElement(By.xpath(GMOHomePage)).isDisplayed());
   // 	ActionMethods.captureScreenshot("GMO home page");
    }
    
    
    public static void VerifyAboutGmoPage()
    {
    	ActionMethods.WaitTillObjectLoads(AboutGMOPage,"xpath");
    	Assert.assertTrue(driver.findElement(By.xpath(AboutGMOPage)).isDisplayed());
   // 	ActionMethods.captureScreenshot("GMO home page");
    }
    
    public static void VerifyTestPage()
    {
    	ActionMethods.WaitTillObjectLoads(GMOTestPage,"xpath");
    	Assert.assertTrue(driver.findElement(By.xpath(GMOTestPage)).isDisplayed());
   // 	ActionMethods.captureScreenshot("GMO home page");
    }
    
}
