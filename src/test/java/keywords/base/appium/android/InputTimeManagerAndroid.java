package keywords.base.appium.android;

import org.apache.commons.io.IOUtils;

import base.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import keywords.base.InputTime;

public class InputTimeManagerAndroid extends BaseTest implements InputTime {

	@Override
	public void inputTime(String hour, String minute) {
		int sdk = checkVersionSDK();

		if (sdk == -1) {
			throw new NullPointerException("La version du SDK est incorrecte !");
		} else if (sdk >= 21) {
			inputOnTimeAndroidV5Plus(hour, minute);
		} else if (sdk < 21) {
			inputOnTimeAndroid4(hour, minute);
		}
	}

	private int checkVersionSDK() {
		Runtime runtime = Runtime.getRuntime();
		String[] command = { "adb","shell", "getprop", "ro.build.version.sdk" };
		Process process;
		int sdk = -1;
		try {
			process = runtime.exec(command);
			process.waitFor();
			String output = IOUtils.toString(process.getInputStream(),"UTF-8").split("\\r")[0];
			LOGGER.debug("version SDK : [" + output + "]");
			sdk = Integer.parseInt(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdk;
	}
	
	//Fonction privee d'input sur le widget de selection d'heure sur android (versions r�centes >= 6)
	private void inputOnTimeAndroidV5Plus(String hour, String minute) {
		hour = hour.replaceFirst("^0+(?!$)", "");
		minute = minute.replaceFirst("^0+(?!$)", "");

		androidDriver.findElement(MobileBy.AccessibilityId(hour)).click();
		
		androidDriver.findElement(MobileBy.AccessibilityId(minute)).click();;
		
		androidDriver.findElement(MobileBy.id("android:id/button1")).click();;
	}
	
	
	//Fonction privee d'input sur le widget de selection d'heure sur android (anciennes version < 6)
	private void inputOnTimeAndroid4(String hour, String minute) {
		MobileElement selectedHour = androidDriver.findElementsById("numberpicker_input").get(0);
		MobileElement selectedMin = androidDriver.findElementsById("numberpicker_input").get(1);
		
		MobileElement scrollHoursBtn = androidDriver.findElementByXPath("//android.widget.NumberPicker[1]/android.widget.Button[1]");
		MobileElement scrollMinBtn = androidDriver.findElementByXPath("//android.widget.NumberPicker[2]/android.widget.Button[1]");
		
		while(!selectedMin.getText().contains(minute)) {
			(scrollMinBtn).click();
		}
		while(!selectedHour.getText().contains(hour)) {
			(scrollHoursBtn).click();
		}
		
		MobileElement okBtn = androidDriver.findElementById("android:id/button1");
		(okBtn).click();
	}
}
