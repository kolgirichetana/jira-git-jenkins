package StepDefinitions;


import com.cucumber.listener.Reporter;

import PageObjectModel.BillingInfoPage;
import PageObjectModel.catalogPage;
import PageObjectModel.homePage;
import PageObjectModel.OrderConfirmPage;
import PageObjectModel.PlaceOrderPage;
import Utilities.BrowserSelect;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login {
	
	@Given("^Open \"(.*?)\" browser and launch GMO$")
	public void open_browser_and_launch_GMO(String browserName) throws Throwable {
	    BrowserSelect.startApplication(browserName);
	    Reporter.addStepLog("Browser is launched");
	}

	@When("^user is on GMO home page$")
	public void user_is_on_GMO_home_page() throws Throwable {
		homePage.VerifyGmoHomePage();
	}

	@Then("^click on Enter GMO button$")
	public void click_on_Enter_GMO_button() throws Throwable {
		homePage.ClickEnterGMObtn();
		Reporter.addStepLog("Select GMO");
	}

	@Then("^verify user is on Catalog page$")
	public void verify_user_is_on_Catalog_page() throws Throwable {
	    catalogPage.VerifyCatalogPage();
	    Reporter.addStepLog("User on Catalog page");
	}
	
	@Then("^I enter \"(.*?)\" quantity for \"(.*?)\" item$")
	public void i_enter_quantity_for_item(String qty, String item) throws Throwable {
		catalogPage.EnterItemQuantity(qty,item);
	}

	@Then("^click on Place An Order button$")
	public void click_on_Place_An_Order_button() throws Throwable {
	    catalogPage.ClickSubmitBtn();
	}
	
	@Then("^verify user is on Place Order page$")
	public void verify_user_is_on_Place_Order_page() throws Throwable {
	    PlaceOrderPage.VerifyPlaceOrderPage();
	}
	
	
	@Then("^verify grand total amount is correct$")
	public void verify_grand_total_amount_is_correct() throws Throwable {
	    PlaceOrderPage.VerifyGrandTotal();
	}
	
	@Then("^click on Proceed with Order button$")
	public void click_on_Proceed_with_Order_button() throws Throwable {
	    PlaceOrderPage.ClickProceedOrderBtn();
	}

	@Then("^verify user is on Billing Information page$")
	public void verify_user_is_on_Billing_Information_page() throws Throwable {
	    BillingInfoPage.VerifyBillingInfoPage();
	}
	
	@Then("^I enter \"(.*?)\" as name$")
	public void i_enter_as_name(String name) throws Throwable {
		BillingInfoPage.enterBillName(name);
	}

	@Then("^I enter \"(.*?)\" as address and \"(.*?)\" as City and \"(.*?)\" as state and \"(.*?)\" as Zip code$")
	public void i_enter_as_address_and_as_City_and_as_state_and_as_Zip_code(String address, String city, String state, String zip) throws Throwable {
	    BillingInfoPage.enterBillAddress(address);
	    BillingInfoPage.enterBillCity(city);
	    BillingInfoPage.enterBillState(state);
	    BillingInfoPage.enterBillZipcode(zip);
	}

	@Then("^I enter \"(.*?)\" as phone number and \"(.*?)\" as email id$")
	public void i_enter_as_phone_number_and_as_email_id(String phone, String email) throws Throwable {
	    BillingInfoPage.enterBillPhone(phone);
	    BillingInfoPage.enterBillEmail(email);
	}
	
	@Then("^I select \"(.*?)\" creditcard and enter \"(.*?)\" as CC number and \"(.*?)\" as expiry date$")
	public void i_select_creditcard_and_enter_as_CC_number_and_as_expiry_date(String cardType, String CCnumber, String CCExpiry) throws Throwable {
	    BillingInfoPage.SelectCCType(cardType);
		BillingInfoPage.enterCardNumber(CCnumber);
		BillingInfoPage.enterCardExpiry(CCExpiry);		
	}

	@Then("^I check the Ship to same as Bill address checkbox$")
	public void i_check_the_Ship_to_same_as_Bill_address_checkbox() throws Throwable {
	    BillingInfoPage.ClickSameAsBill();
	}

	@Then("^I click on Place the Order button$")
	public void i_click_on_Place_the_Order_button() throws Throwable {
	    BillingInfoPage.ClickPlaceOrderButton();
	}
	
	@Then("^verify user is on Order Confirmation Page$")
	public void verify_user_is_on_Order_Confirmation_Page() throws Throwable {
		OrderConfirmPage.verifyOrderConfirmPage();
	}

	@Then("^verify the credit card and Grand total amount$")
	public void verify_the_credit_card_and_Grand_total_amount() throws Throwable {
	   OrderConfirmPage.VerifyMOP();
	   OrderConfirmPage.verifyReceiptAmount();
	}

	@Then("^click on Return to Home page button$")
	public void click_on_Return_to_Home_page_button() throws Throwable {
	    OrderConfirmPage.ClickReturnHomeBtn();
	}
	
	@Then("^user close the browser$")
	public void user_close_the_browser() throws Throwable {
		   BrowserSelect.closeBrowser();
	}
}
