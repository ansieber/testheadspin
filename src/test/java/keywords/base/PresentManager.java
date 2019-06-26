package keywords.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class PresentManager extends BaseTest implements Present, WaitUntil {

	@Override
	public boolean isPresent(By by) {
		boolean value = false;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty()) {
			value = true;
		}
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		return value;
	}
	
	public boolean isVisible(By by) {
		boolean value;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (driver.findElements(by).isEmpty()) {
			return false;
		}
		value = driver.findElement(by).isDisplayed();
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		
		return value;
	}

	@Override
	public void waitUntilElementVisible(By by) {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	@Override
	public boolean checkTextPresent(String text) {
		return (driver.getPageSource().toUpperCase().contains(text.toUpperCase()));
	}
	
	@Override
	public boolean checkTextPresentWithBy(By by, String text) {
		waitUntilElementVisible(by);
		String currentText = driver.findElement(by).getText().toUpperCase();
		return currentText.contains(text.toUpperCase());
	}
}
