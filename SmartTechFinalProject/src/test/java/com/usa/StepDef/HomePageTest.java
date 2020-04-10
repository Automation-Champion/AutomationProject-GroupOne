package com.usa.StepDef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.usa.PageFactoy.PageFactoryClass;
import com.usa.Parent.Parent;
import com.usa.Utility.ListenerClass;
import com.usa.Utility.Utility;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Listeners(ListenerClass.class)
public class HomePageTest extends Parent {
	PageFactoryClass pf;

	@When("^for properties search \"([^\"]*)\"$")
	public void for_properties_search(String Location) {
		pf = PageFactory.initElements(driver, PageFactoryClass.class);
		Utility.Explicitwait(pf.GetlocationSearch()).sendKeys(Location);
		Utility.Explicitwait(pf.GetlocationSearch()).sendKeys(Keys.ENTER);

	}

	@When("^print price for all the properties$")
	public void print_price_for_all_the_properties() {

		pf.PrintPrice();

	}

	@When("^select third property from the list$")
	public void select_third_property_from_the_list() {

		pf.ThirdPropperty();

	}

	@When("^verify agent name and phone number$")
	public void verify_agent_name_and_phone_number() {

		System.out.println("The Agent Name is:" + "" + Utility.Explicitwait(pf.Getagentname()).getText());
		System.out.println("The Phone number of the agent is:" + " " + Utility.Explicitwait(pf.GetagentPhone()).getText());
	}

	@Then("^logout from your account$")
	public void logout_from_your_account() {

		teardown();
	}
}
