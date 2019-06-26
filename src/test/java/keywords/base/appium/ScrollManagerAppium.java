package keywords.base.appium;

import java.time.Duration;

import base.BaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import keywords.base.Scroll;
import utils.Common;

public class ScrollManagerAppium extends BaseTest implements Scroll {

	@Override
	public void scroll(int fromX, int fromY, int toX, int toY) {
		new TouchAction<>(appiumDriver).press(PointOption.point(fromX, fromY))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
        .moveTo(PointOption.point(toX, toY))
        .release()
        .perform();
		Common.sleep(1000);
	}

	@Override
	public void scrollDown() {
		int pressX = appiumDriver.manage().window().getSize().width / 2;

		// 4/5 of the screen as the bottom finger-press point
		int bottomY = appiumDriver.manage().window().getSize().height * 4/5;

		int topY = appiumDriver.manage().window().getSize().height / 5;

		// Scrolls with TouchAction by itself
		scroll(pressX, bottomY, pressX, topY);
	}
	
	@Override
	public void scrollUp() {
		int pressX = driver.manage().window().getSize().width / 2;

		// 4/5 of the screen as the bottom finger-press point
		int bottomY = driver.manage().window().getSize().height * 4/5;

		int topY = driver.manage().window().getSize().height / 5;

		// Scrolls with TouchAction by itself
		scroll(pressX, topY, pressX, bottomY);	
	}
	
	@Override
	public void scrollRight() {
		final int offsetFromScreenSide = 5;
		
		int startX = driver.manage().window().getSize().width - offsetFromScreenSide;
		int endX = offsetFromScreenSide;
		
		int pressY = driver.manage().window().getSize().height / 2;
		
		scroll(startX, pressY, endX, pressY);	
	}

	@Override
	public void scrollLeft() {
		final int offsetFromScreenSide = 5;
		
		int startX = offsetFromScreenSide;
		int endX = driver.manage().window().getSize().width - offsetFromScreenSide;
		
		int pressY = driver.manage().window().getSize().height / 2;
		
		scroll(startX, pressY, endX, pressY);	
	}

	
}
