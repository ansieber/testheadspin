package keywords.base.appium.ios;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import keywords.base.Photo;
import keywords.base.appium.ClickManagerAppium;

public class PhotoManagerIos implements Photo {

	@Override
	public void joinPhoto() {
		clickPhotoSelectionIOS();
	}
	
	public void clickPhotoSelectionIOS() {
		By libraryButton = MobileBy.AccessibilityId("libraryButton");
		By firstPicture = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeImage'");
		By validPicture = MobileBy.AccessibilityId("confirmButton");
		
		ClickManagerAppium clickManager = new ClickManagerAppium();
		
		clickManager.waitAndClick(libraryButton);
		clickManager.tap(firstPicture);
		clickManager.waitAndClick(validPicture);
	}

	@Override
	public void clickPopupPermissionPicture() {	
	}
}
