package keywords.base.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import keywords.base.ClickManager;

public class ClickManagerSelenium extends ClickManager {

	@Override
	public void tap(By by) {
		WebElement element = webDriver.findElement(by);
		new Actions(webDriver)
		.moveToElement(element)
		.click()
		.build()
		.perform();
	}

	@Override
	public void tap(int x, int y) {
	}

	@Override
	public void longPress(int x, int y) {
	}
}
