package com.umbrellar.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.umbrellar.ActionDriver;

public class loginPage extends ActionDriver {
	public loginPage(WebDriver driver) {
		super(driver);
	}

	String username = "//*[@id='app']/div/div/div/div/div/form/div[1]/input";
	String pass = "//*[@id='app']/div/div/div/div/div/form/div[2]/input";
	String signup = "//button[contains(text(),'Login')]";
	String register = "//*[@id='app']/div/div/div/div/div/form/div[3]/a";

	public By getusername() {
		return By.xpath(username);
	}

	public By getPass() {
		return By.xpath(pass);
	}

	public By getSignup() {
		return By.xpath(signup);
	}

	public By getRegister() {
		return By.xpath(register);
	}

	/*************************/

	public void typePass(String value) {
		type(getPass(), value);
	}

	public void typeUsername(String value) {
		type(getusername(), value);
	}

	public void clickSignup() {
		click(getSignup());

	}

	public void clickRegister() {
		click(getRegister());

	}

}
