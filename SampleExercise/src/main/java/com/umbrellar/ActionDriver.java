package com.umbrellar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionDriver {

	protected static WebDriver driver;

	@SuppressWarnings("static-access")
	public ActionDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String title() {
		String pgTitle = driver.getTitle();
		return pgTitle;
	}

	public void click(By locator) {

		WebElement w = driver.findElement(locator);
		w.click();
	}

	public void type(By locator, String value) {
		WebElement w = driver.findElement(locator);
		w.clear();
		w.sendKeys(value);

	}
}
