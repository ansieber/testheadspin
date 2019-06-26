package keywords.base.appium.android;

import org.openqa.selenium.By;

import base.BaseTest;
import keywords.base.Photo;
import keywords.base.PresentManager;
import keywords.base.appium.ClickManagerAppium;

public class PhotoManagerAndroid extends BaseTest implements Photo {

	private static ClickManagerAppium click = new ClickManagerAppium();
	private static PresentManager present = new PresentManager();
	
	private static String textViewDocs = "//android.widget.TextView[@text = 'Docs']";
	private static String textViewDocuments = "//android.widget.TextView[@text = 'Documents']";
	private static String textViewFichiers = "//android.widget.TextView[@text = 'Fichiers']";
	private static String textViewResolverGrid = "//*[@resource-id = 'com.huawei.android.internal.app:id/resolver_grid']";
	private static String iconThumb = "//*[@resource-id = 'com.android.documentsui:id/icon_thumb']";
	
	private static String packageInstallerAllow = "//*[@resource-id = 'com.android.packageinstaller:id/permission_allow_button']";
	
	@Override
	public void joinPhoto() {
		clickPhotoSelectionAndroid();
		
		// A voir si ce tap est utile pour les autres téléphones, pas utile sur le Samsung S6
//		click.tap(120, 400);
	}

	public void clickPopupPermissionPicture() {
		if (present.isPresent(By.xpath(packageInstallerAllow))) {
			click.waitAndClick(By.xpath(packageInstallerAllow));
		}			
	}
	
	public void clickPhotoSelectionAndroid() {
		
		if (present.isPresent(By.xpath(textViewDocs))) {
			click.waitAndClick(By.xpath(textViewDocs));
		} else if (present.isPresent(By.xpath(textViewDocuments))) {
			click.waitAndClick(By.xpath(textViewDocuments));
		} else if (present.isPresent(By.xpath(textViewFichiers))) {
			click.waitAndClick(By.xpath(textViewFichiers));
		} else if (present.isPresent(By.xpath(textViewResolverGrid))) {
			click.waitAndClick(By.xpath(textViewResolverGrid + "/android.widget.LinearLayout[last()]"));
		} else if (present.isPresent(By.xpath(iconThumb))) {
			click.waitAndClick(By.xpath(iconThumb));
		}
	}
}
