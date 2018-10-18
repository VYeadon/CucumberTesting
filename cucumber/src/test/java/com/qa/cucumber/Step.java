package com.qa.cucumber;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	
	public WebDriver driver = null;
	
	public ExtentReports extent;
	public ExtentTest test;
	
	public TeaWebElements elementGetter;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Admin\\Documents\\TestingJava\\chromedriver.exe\\");
		
		driver = new ChromeDriver();

		extent = new ExtentReports("C:\\Users\\Admin\\Documents\\TestingJava\\cucumber\\CucumberReport.html",true);
		// Very important
		elementGetter = PageFactory.initElements(driver, TeaWebElements.class);
		//--------------
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		
		test = extent.startTest("Cucumber testing");
		
		driver.get("http://www.practiceselenium.com/welcome.html");
		
		test.log(LogStatus.INFO, "Entereted correct website");
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page(){
		try
		{
			elementGetter.clickMenuItem();
		}
	    catch(NullPointerException e3)
		{
	    	test.log(LogStatus.FAIL, "No menu link button availble");
	    	fail();
		}
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
	    try {
	    	// if no element exists will throw an error
	    	elementGetter.getmenuElement();
	    	
	    	test.log(LogStatus.INFO, "Menu elements have been found");
	    }
	    catch(NullPointerException e)
	    {
	    	test.log(LogStatus.FAIL, "No menu items availble");
	    	fail();
	    }
	}
	
	
	//--------------------------------------------------------------------------------------


	
	
	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
		try
		{
			elementGetter.clickCheckoutItem();;
			test.log(LogStatus.INFO, "Check out button for first menu item has been pressed");
		}
		catch (NullPointerException e4)
		{
			test.log(LogStatus.FAIL, "No checkout button");
	    	fail();
		}
	    }

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
	   try
	   {
		   elementGetter.getcheckOutForm();
		   
		   test.log(LogStatus.PASS, "");
	   }
	   catch(NullPointerException e2)
	    {
	    	test.log(LogStatus.FAIL, "Checkout page does not not load");
	    	fail();
	    }
	}
	
	@After
	public void teardown()
	{
		extent.endTest(test);
		extent.flush();
		extent.close();
		
		driver.quit();
	}
}
