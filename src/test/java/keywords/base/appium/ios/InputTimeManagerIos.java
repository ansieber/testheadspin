package keywords.base.appium.ios;

import base.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import keywords.base.InputTime;

public class InputTimeManagerIos extends BaseTest implements InputTime {	

	@Override
	public void inputTime(String hour, String minute) {
		MobileElement hoursWheel = iosDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[1]"));
		MobileElement minWheel = iosDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[2]"));
		
		hoursWheel.setValue(hour);
		minWheel.setValue(minute);
		
		iosDriver.findElement(MobileBy.AccessibilityId("Ok")).click();
	}
}
