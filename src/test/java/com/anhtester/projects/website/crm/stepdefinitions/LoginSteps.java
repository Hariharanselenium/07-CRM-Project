package com.anhtester.projects.website.crm.stepdefinitions;

import com.anhtester.common.CommonPageCRM;
import com.anhtester.keywords.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.anhtester.keywords.WebUI.getCurrentUrl;
import static com.anhtester.keywords.WebUI.verifyContains;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginSteps extends CommonPageCRM {

    @Given("User navigate to url {string}")
    public void userNavigateToUrl(String url) {
        //WebUI.getURL(url);
    }

    @When("User login with username {string} and password {string} valid")
    public void userLoginWithUsernameAndPasswordValid(String email, String password) {
        getSignInPage().signIn(email, password);
    }

    @When("User login with username {string} and password {string} invalid")
    public void userLoginWithUsernameAndPasswordInvalid(String email, String password) {
        getSignInPage().signIn(email, password);
    }

    @Then("The user redirect to Dashboard page")
    public void theUserRedirectToDashboardPage() {
        WebUI.waitForPageLoaded();
        verifyContains(getCurrentUrl(), getDashboardPage().pageUrl, "Can not redirect to the dashboard page.");

    }

    @Then("The user can not redirect to Dashboard page")
    public void theUserCanNotRedirectToDashboardPage() {
        WebUI.verifyElementNotPresent(getSignInPage().labelEmailError, "FAIL. User sign in successfully");
    }

    @And("The error message is displays")
    public void theErrorMessageIsDisplays() {
        WebUI.verifyElementPresent(getSignInPage().alertErrorMessage, "The error message does not display");
    }
    
    @When("click the store")
    public void clickstore() {
    	WebUI.clickElement(By.xpath("//span[normalize-space()='Store']"));
    	
    }
    @When("Add to card {string} for the given product")
    public void Addproduct(String product) {
    	
    	List<WebElement> productname =	WebUI.getWebElements(By.xpath("//div[@class='card']/descendant::div[contains(@class,'strong')]"));
    	for (int i = 0; i < productname.size(); i++) {
    		if (productname.get(i).getText().equalsIgnoreCase(product)) {
    			WebUI.getWebElements(By.xpath("//div[@class='card']/descendant::div[contains(.,'Add to cart')]")).get(i).click();
    		}
    	}
    }
    @When("click checkout")
    public void checkout() {
    	WebUI.clickElement(By.xpath("//a[@id='item-checkout-button']"));
    }
    @When("click submit")
    public void submit() {
    	WebUI.clickElement(By.xpath("//button[@type='submit']"));
    }
    @When("verify the store page title")
    public void storetitle() {
    	Assert.assertEquals(WebUI.getPageTitle(), "Store | RISE - Ultimate Project Manager and CRM");
    }
    @When("verify the checkout title")
    public void checkouttitle() {
    	Assert.assertEquals(WebUI.getPageTitle(), "Store | RISE - Ultimate Project Manager ");

    }
    @Then("verify product the {string} in invoice")
    public void checkproductname(String ProductName) {
    	Assert.assertEquals(WebUI.getTextElement(By.xpath("((//table/tbody/tr)[5]/td)[1]")), ProductName);
    	
    }
}
