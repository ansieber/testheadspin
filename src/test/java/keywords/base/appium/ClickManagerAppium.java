package keywords.base.appium;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import keywords.base.ClickManager;
import keywords.base.Tap;

public class ClickManagerAppium extends ClickManager implements Tap {
	
	@Override
	public void tap(By by) {
		MobileElement element = appiumDriver.findElement(by);
		this.tap(element.getCenter().x, element.getCenter().y);
	}

	@Override
	public void tap(int x, int y) {
		new TouchAction<>(appiumDriver).tap(PointOption.point(x, y)).perform();
	}

	@Override
	public void longPress(int x, int y) {
	}
}
