package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class MagasinHomePage extends BasePage {
	private static By btn_crossClosePopUp;
	private static By btn_addToBasket;
	private static By btn_product;
	private static By btn_research;
	private static By btn_completion;
	private static By input_research;
	private static By input_searchBar;
	
	public MagasinHomePage() {
		if (getPlatform().equals("ANDROID")) {
			btn_crossClosePopUp = By.xpath("//a[contains(@class,'ferme-communiques')]");
			btn_addToBasket = By.xpath("(//a[contains(@class,'ajout')])[1]");
			btn_product = By.xpath("//span[contains(text(),'");
			btn_research = By.xpath("//span[contains(@class,'champ-recherche')]");
			btn_completion = By.xpath("//span[contains(@class,'suggestion-rayon-libelle suggestion-rayon-libelle-sans-image')]");
			input_research = By.xpath("//input[contains(@class,'champ-recherche')]");
			input_searchBar = By.xpath("//input[contains(@id,'saisieTexte')]");
		} else if (getPlatform().equals("IOS")) {
			btn_crossClosePopUp = By.xpath("//a[contains(@class,'ferme-communiques')]");
			btn_addToBasket = By.xpath("(//a[contains(@class,'ajout')])[1]");
			btn_product = By.xpath("//span[contains(text(),'");
			btn_research = By.xpath("//span[contains(@class,'champ-recherche')]");
			btn_completion = By.xpath("//span[contains(@class,'suggestion-rayon-libelle suggestion-rayon-libelle-sans-image')]");
			input_research = By.xpath("//input[contains(@class,'champ-recherche')]");
			input_searchBar = By.xpath("//input[contains(@id,'saisieTexte')]");
		}
	}
	
	public void selectProducts() {
		this.getWebManager().openUrl("https://m-courses.leclercdrive.fr/magasin-103101-Roques-sur-Garonne-Toulouse");
		closePopUp();
		LOGGER.info("PopUp closed");
		lookForProduct("aubergine");
		LOGGER.info("Aubergines searched");
		addToBasket(10);
		LOGGER.info("Product(s) added to basket");

	}
	
	//**********************\\
	// 		  CLICK			\\
	//**********************\\
	
	//fermer la popup des communiques
	public void closePopUp() {
		this.getClickManager().waitAndClick(btn_crossClosePopUp);
	}
	
	//ajouter un article au panier
	public void addToBasket(int numberOfProducts) {
		this.getClickManager().waitAndClick(btn_addToBasket);
	}
	
	//**********************\\
	// 		  INPUT			\\
	//**********************\\
	
	//rechercher un produit
	public void lookForProduct(String text) {
		By product;
		product = By.xpath(btn_product + text + "')]");
		this.getClickManager().waitAndClick(btn_research);
		driver.findElement(input_research).sendKeys(text);
		this.getClickManager().waitAndClick(btn_completion);
	}
	

	
}