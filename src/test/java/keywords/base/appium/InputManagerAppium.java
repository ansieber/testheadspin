package keywords.base.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.BaseTest;
import keywords.base.Input;

public class InputManagerAppium extends BaseTest implements Input {

	@Override
	public void input(By by, String text) {
		appiumDriver.findElement(by).sendKeys(text);
	}

	@Override
	public void inputAndPressEnter(By by, String text) {
		appiumDriver.findElement(by).sendKeys(text);
		appiumDriver.findElement(by).sendKeys(Keys.RETURN);
	}

	@Override
	public void inputAndClear(By by, String text) {
		appiumDriver.findElement(by).clear();
		appiumDriver.findElement(by).sendKeys(text);
	}
}
