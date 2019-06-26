package keywords.base.appium.ios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;

import base.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import keywords.base.InputDate;

public class InputDateManagerIos extends BaseTest implements InputDate {

	@Override
	public void inputDate(By by, String date) {
		//conversion string => date
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
		Date input;
		try {
			input = format.parse(date);
			
			//identification des trois pickerwheels
			MobileElement days = iosDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[1]"));
			MobileElement months = iosDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[2]"));
			MobileElement years = iosDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[3]"));
		
			years.sendKeys(new SimpleDateFormat("yyyy", Locale.FRANCE).format(input));
			months.sendKeys(new SimpleDateFormat("MMMM", Locale.FRANCE).format(input));
			days.sendKeys((new SimpleDateFormat("dd", Locale.FRANCE).format(input)).replaceFirst("^0+(?!$)", ""));
			
			//clic sur OK
			iosDriver.findElement(MobileBy.AccessibilityId("Ok")).click();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
