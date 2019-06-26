package keywords.base.appium.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keywords.base.appium.ClickManagerAppium;

public class ClickManagerIos extends ClickManagerAppium {

	@Override
	public void waitAndClick(By by) {
		driver.findElement(by).click();
	}
}
