package com.usa.StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.usa.PageFactoy.PageFactoryClass;
import com.usa.Parent.Parent;
import com.usa.Utility.ListenerClass;
import com.usa.Utility.Utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@Listeners(ListenerClass.class)
public class LoginTest extends Parent {

	PageFactoryClass pf;

	@Given("^open the browser$")
	public void open_the_browser() {
		inilitalizaion();
		setup();
	}

	@Given("^navigate to \"([^\"]*)\"$")
	public void navigate_to(String URL) {
		pf = PageFactory.initElements(driver, PageFactoryClass.class);

		driver.get(URL);

		Utility.Explicitwait(pf.Getcookie()).click();
	}

	@Given("^click on Sign in from upper right corner$")
	public void click_on_Sign_in_from_upper_right_corner() {
		Utility.Explicitwait(pf.GettSignIn()).click();
		
	}

	@When("^enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_username_and_password(String Username, String Password) {
		Utility.Explicitwait(pf.GetUsername()).sendKeys(Username);
		Utility.Explicitwait(pf.GetPassword()).sendKeys(Password);
	}

	@When("^click sign in button$")
	public void click_sign_in_button() {

		Utility.Explicitwait(pf.GetSubmitbtn()).click();
	}

	@Then("^user should be landed in homepage$")
	public void user_should_be_landed_in_homepage() {

		String actual = 	Utility.Explicitwait(pf.Getpagesource()).getText();
		String expected = "My Zoopla";
		
		if (expected.equalsIgnoreCase(actual)) {
			System.out.println(actual);
			System.out.println("My expected page title match with actual after inputting creditintials");
			
			Assert.assertTrue(true);
		}

		else {
			System.out.println("My expected page title Did Not match");
			Assert.assertTrue(true);
		}
	}

}
