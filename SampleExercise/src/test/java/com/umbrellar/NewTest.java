package com.umbrellar;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.umbrellar.POM.RegisterPage;
import com.umbrellar.POM.loginPage;

import junit.framework.Assert;

public class NewTest extends BrowserFunctions {
	String parentWin;

	@Parameters({ "username", "password" })
	@Test()
	public void invalidlogin(String username, String password) throws InterruptedException {
		Thread.sleep(5000);

		parentWin = driver.getWindowHandle();
		System.out.println(parentWin);
		Set<String> allWin = driver.getWindowHandles();
		for (String child : allWin) {
			if (!parentWin.equals(child)) {

				driver.switchTo().window(child);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//*[@id='app']/div/div/div/div/div/form/div[1]/input"))));
		loginPage ob = new loginPage(driver);
		ob.typeUsername(username);
		ob.typePass(password);
		ob.clickSignup();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[1]"))));
		WebElement alert = driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[1]"));
		Assert.assertEquals("Username or password is incorrect", alert.getText());
		if (alert.isDisplayed()) {
			ob.clickRegister();
			Thread.sleep(2000);
		}

	}

	@Parameters({ "firstname", "lastname", "username", "password" })
	@Test()
	public void register(String firstname, String lastname, String username, String password)
			throws InterruptedException {
		{
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			RegisterPage regPage = new RegisterPage(driver);

			regPage.typefirstName(firstname);
			regPage.typelastName(lastname);
			regPage.typeUsername(username);
			regPage.typePass(password);
			regPage.clickRegister();

			Thread.sleep(2000);
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[1]"))));
			WebElement alert = driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[1]"));

			Assert.assertEquals("Registration successful", alert.getText());
			if (alert.isDisplayed()) {
				loginPage ob = new loginPage(driver);
				ob.typeUsername(username);
				ob.typePass(password);
				ob.clickSignup();
				Thread.sleep(2000);
				WebElement registered = driver.findElement(By.xpath("//*[@id='app']/div/div/div/div/div/h1"));
				Assert.assertEquals(firstname + "!", registered.getText().split("Hi ")[1]);

				List<WebElement> users = driver.findElements(By.xpath("//*[@id='app']/div/div/div/div/div/ul/li"));
				for (WebElement user : users) {

					Assert.assertEquals(user.getText().split(" - ")[0], firstname + " " + lastname);

				}
			}

		}
	}

}
