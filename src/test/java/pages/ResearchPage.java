package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class ResearchPage extends BasePage {
	private static By input_magasin;
	private static By btn_magasinId;
	private static By btn_magasinTitle;
	private static By btn_goIntoDrive;
	
	public ResearchPage() {
		if (getPlatform().equals("ANDROID")) {
			input_magasin = By.xpath("(//input[contains(@id,'Recherche')])[1]");
			btn_magasinId = By.xpath("//a[contains(@onclick,'103101')]");
			btn_magasinTitle = By.xpath("//a[contains(@data-description,'Roques sur Garonne')]");
			btn_goIntoDrive = By.xpath("//a[contains(@class,'bouton popinPRPL-informationsMagasin-bouton')]");
		} else if (getPlatform().equals("IOS")) {
			input_magasin = By.xpath("(//input[contains(@id,'Recherche')])[1]");
			btn_magasinId = By.xpath("//a[contains(@onclick,'103101')]");
			btn_magasinTitle = By.xpath("//a[contains(@data-description,'Roques sur Garonne')]");
			btn_goIntoDrive = By.xpath("//a[contains(@class,'bouton popinPRPL-informationsMagasin-bouton')]");
		}
	}

	public void lookForMagasin() {
		searchMagasin("Roques");
		LOGGER.info("Look magasin");
		enterMagasin();
		LOGGER.info("In magasin Roques sur Garonne");
		goIntoMagasin();
		LOGGER.info("Home page magasin");
	}

	//**********************\\
	// 		  INPUT			\\
	//**********************\\
	
	//recherche un magasin
	public void searchMagasin(String text) {
		driver.findElement(input_magasin).sendKeys(text);
	}
	
	//**********************\\
	// 		  CLICK			\\
	//**********************\\
	
	//selectionner un magasin
	public void enterMagasin() {
		this.getClickManager().waitAndClick((btn_magasinTitle));
		this.getClickManager().waitAndClick((btn_magasinId));
	}
	
	//go into magasin
	public void goIntoMagasin() {
		this.getClickManager().waitAndClick((btn_goIntoDrive));
	}

}