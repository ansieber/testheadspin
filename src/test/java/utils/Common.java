package utils;

import java.io.File;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseTest;
import base.ExtentTestManager;

public class Common {

	public static String getTimeValue() throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar cal = Calendar.getInstance();
		return df.format(cal.getTime());
	}	
	
	public static void sleep(long millisecond) {
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	public static String addDate(int field, int value) {
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date;

		calendar.add(field, value);
		date = dateFormat.format(calendar.getTime());
		return date;
	}

	public static String addHour(int value) {
		Calendar calendar = Calendar.getInstance(Locale.FRANCE);
		DateFormat dateFormat = new SimpleDateFormat("HH");
		String hour;

		calendar.add(Calendar.HOUR_OF_DAY, value);
		hour = dateFormat.format(calendar.getTime());
		return hour;
	}

	public static String addMinute(int value) {
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("mm");
		String minute;

		calendar.add(Calendar.MINUTE, value);
		minute = dateFormat.format(calendar.getTime());
		return minute;
	}
	
	/**
	 * Retourne une valeur à travers l'udid de l'appareil récupéré
	 * par {@link BaseTest.strGetDeviceName} qui est en base 16
	 * convertit en base 10 et modulo par {@code range}.
	 * 
	 * @param range 
	 * @return La valeur du modulo de l'udid et de {@code range}
	 */
	public static int getValueFromUdid(int range) {
		String udidHexadecimal = BaseTest.strGetDeviceName;
		BigInteger udidBase10 = new BigInteger(udidHexadecimal, 16);
		int result;

		result = udidBase10.mod(new BigInteger(Integer.toString(range))).intValue();
		return result;
	}
	
//	public static void logExtentManager(String screenshotName, String extentManagerStepName) {
//		File screenshot = takeScreenshot("entrer_mdp_" + new Date().getTime());
//		ExtentTestManager.getTest().log(LogStatus.PASS, "Entrer mdp", 
//				ExtentTestManager.getTest().addScreenCapture(screenshot.getCanonicalPath()));
//	}
	
	
}
