package keywords.base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public abstract class ClickManager extends BaseTest implements Click, Tap {

	@Override
	public void waitAndClick(By by) {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}

	@Override
	public void waitAjaxAndClick(By by) {
		webDriverEvent.findElement(by); // Synchro ajax beforeFindBy  SeleniumEventListener.java
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}
	
}
