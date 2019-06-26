package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;

import keywords.base.ClickManager;
import keywords.base.Input;
import keywords.base.InputDate;
import keywords.base.InputTime;
import keywords.base.Photo;
import keywords.base.PresentManager;
import keywords.base.Scroll;
import keywords.base.Web;
import keywords.base.WebManager;
import keywords.base.appium.ClickManagerAppium;
import keywords.base.appium.InputManagerAppium;
import keywords.base.appium.ScrollManagerAppium;
import keywords.base.appium.android.InputDateManagerAndroid;
import keywords.base.appium.android.InputTimeManagerAndroid;
import keywords.base.appium.android.PhotoManagerAndroid;
import keywords.base.appium.ios.ClickManagerIos;
import keywords.base.appium.ios.InputDateManagerIos;
import keywords.base.appium.ios.InputTimeManagerIos;
import keywords.base.appium.ios.PhotoManagerIos;
import keywords.base.selenium.ClickManagerSelenium;
import keywords.base.selenium.InputManagerSelenium;

public class BasePage extends BaseTest {

	protected static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
	
	private static ClickManager clickManager;
	private static Input inputManager;
	private static PresentManager presentManager;
	private static InputDate inputDateManager;
	private static InputTime inputTimeManager;
	private static Web webManager;
	private static Photo photoManager;
	private static Scroll scrollManager;
	
	private static boolean singleton = false;

	public BasePage() {
		if (singleton == false) {
			presentManager = new PresentManager();
			webManager = new WebManager();
			if (getPlatform().equals("ANDROID"))
				setAndroidManager();
			else if (getPlatform().equals("IOS"))
				setIosManager();
			else if (getPlatform().equals("SELENIUM"))
				setSeleniumManager();
			else
				throw new SkipException("Pas de platforme valide");
			singleton = true;
		}
	}
	
	private void setSeleniumManager() {
		LOGGER.info("Set up Manager for SELENIUM");

		clickManager = new ClickManagerSelenium();
		inputManager = new InputManagerSelenium();
	}

	private void setIosManager() {
		//LOGGER.info("Set up Manager for IOS");
		clickManager = new ClickManagerIos();
		inputManager = new InputManagerAppium();
		inputDateManager = new InputDateManagerIos();
		inputTimeManager = new InputTimeManagerIos();
		scrollManager = new ScrollManagerAppium();
		photoManager = new PhotoManagerIos();
	}

	private void setAndroidManager() {
		//LOGGER.info("Set up Manager for Android");
		clickManager = new ClickManagerAppium();
		inputManager = new InputManagerAppium();
		photoManager = new PhotoManagerAndroid();
		inputDateManager = new InputDateManagerAndroid();
		inputTimeManager = new InputTimeManagerAndroid();
		scrollManager = new ScrollManagerAppium();
	}

	public ClickManager getClickManager() {
		return clickManager;
	}

	public Input getInputManager() {
		return inputManager;
	}

	public PresentManager getPresentManager() {
		return presentManager;
	}

	public InputDate getInputDateManager() {
		return inputDateManager;
	}

	public InputTime getInputTimeManager() {
		return inputTimeManager;
	}

	public Scroll getScrollManager() {
		return scrollManager;
	}

	public Web getWebManager() {
		return webManager;
	}

	public Photo getPhotoManager() {
		return photoManager;
	}
}
