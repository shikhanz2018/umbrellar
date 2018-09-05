package com.umbrellar.POM;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.umbrellar.ActionDriver;

public class RegisterPage extends ActionDriver {
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	String firstName = "//*[@id='app']/div/div/div/div/div/form/div[1]/input";
	String lastName = "//*[@id='app']/div/div/div/div/div/form/div[2]/input";
	String userName = "//*[@id='app']/div/div/div/div/div/form/div[3]/input";
	String password = "//*[@id='app']/div/div/div/div/div/form/div[4]/input";
	String register = "//*[@id='app']/div/div/div/div/div/form/div[5]/button";

	public By getfirstName() {
		return By.xpath(firstName);
	}

	public By getlastName() {
		return By.xpath(lastName);
	}

	public By getusername() {
		return By.xpath(userName);
	}

	public By getPass() {
		return By.xpath(password);
	}

	

	public By getRegister() {
		return By.xpath(register);
	}

	/*************************/

	public void typefirstName(String value) {
		type(getfirstName(), value);
	}

	public void typelastName(String value) {
		type(getlastName(), value);
	}

	public void typePass(String value) {
		type(getPass(), value);
	}

	public void typeUsername(String value) {
		type(getusername(), value);
	}

	public void clickRegister() {
		click(getRegister());

	}

}
