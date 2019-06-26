package keywords.base.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.BaseTest;
import keywords.base.Input;

public class InputManagerSelenium extends BaseTest implements Input {

	@Override
	public void input(By by, String text) {
		webDriver.findElement(by).sendKeys(text);
	}

	@Override
	public void inputAndPressEnter(By by, String text) {
		webDriver.findElement(by).sendKeys(text);
		webDriver.findElement(by).sendKeys(Keys.RETURN);
	}

	@Override
	public void inputAndClear(By by, String text) {
		webDriver.findElement(by).clear();
		webDriver.findElement(by).sendKeys(text);
	}
	
}
