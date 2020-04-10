package com.usa.PageFactoy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.usa.Parent.Parent;
import com.usa.Utility.Utility;

public class PageFactoryClass extends Parent {

	public PageFactoryClass() {

		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//*[@class='ui-button-primary ui-cookie-accept-all-medium-large']")
	private WebElement cookie;

	public WebElement Getcookie() {
		return cookie;
	}

	@FindBy(xpath = "//*[@class='button button--tertiary-dark account-link__text']")
	private WebElement signin;

	public WebElement GettSignIn() {
		return signin;
	}

	@FindBy(id = "signin_email")
	private WebElement Username;

	public WebElement GetUsername() {
		return Username;
	}

	@FindBy(id = "signin_password")
	private WebElement Password;

	public WebElement GetPassword() {
		return Password;
	}

	@FindBy(id = "signin_submit")
	private WebElement Submitbtn;

	public WebElement GetSubmitbtn() {
		return Submitbtn;
	}

	@FindBy(xpath = "//*[@class='account-link__text']")
	private WebElement pagesource;

	public WebElement Getpagesource() {
		return pagesource;
	}

	@FindBy(id = "search-input-location")
	private WebElement locationsearch;

	public WebElement GetlocationSearch() {
		return locationsearch;

	}

	@FindBy(xpath = "//*[@class='listing-results-price text-price']")
	private WebElement price;

	public WebElement Getprice() {
		return price;

	}

	public void PrintPrice() {
		
				List<WebElement> listprice = driver.findElements(By.xpath("//*[@class='listing-results-price text-price']"));
		System.out.println("Total property showed up after searching are:" + "" + listprice.size());
		for (int i = 0; i < listprice.size(); i++) {
			System.out.println("The prices of the houses are:" + "" + listprice.get(i).getText());
		}

	}

	public void ThirdPropperty() {
		List<WebElement> thirdproperty = driver
				.findElements(By.xpath("//*[@class='listing-results-price text-price']"));
		for (int j = 0; j < thirdproperty.size(); j++) {
			if (j > 1) {
				System.out.println("The third property from the list has been selected and the price is"
						+ thirdproperty.get(j).getAttribute("text"));

				thirdproperty.get(j).click();
				break;
			}
		}
	}

	@FindBy(xpath = "//*[@class='ui-agent__name']")
	private WebElement agentname;

	public WebElement Getagentname() {
		return agentname;
	}
	
	@FindBy(xpath = "//*[@class='ui-agent__tel ui-agent__text']")
	private WebElement agentPhonenumber;

	public WebElement GetagentPhone() {
		return agentPhonenumber;
	}


	
}
