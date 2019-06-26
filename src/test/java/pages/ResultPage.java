package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class ResultPage extends BasePage {
	private static By btn_addToBasket;
	private static By btn_addQuantity;
	private static By btn_basketRecap;
	
	public int numberOfProducts = 3;
	public int quantity = 10;
	public String product = "1kg";

	public ResultPage() {
		if (getPlatform().equals("ANDROID")) {
			btn_addToBasket = By.xpath("(//a[contains(@class,'ajout')])[1]");
			btn_addQuantity = By.xpath("//a[contains(@class,'ajouter')]");
			btn_basketRecap = By.xpath("//a[contains(@class,'panier')]");
		} else if (getPlatform().equals("IOS")) {
			btn_addToBasket = By.xpath("(//a[contains(@class,'ajout')])[1]");
			btn_addQuantity = By.xpath("//a[contains(@class,'ajouter')]");
			btn_basketRecap = By.xpath("//a[contains(@class,'panier')]");
		}
	}
	
	public void selectProducts() {
//		clickOnProduct(numberOfProducts);
//		LOGGER.info(Integer.toString(numberOfProducts) + " produits differents ajoutes au panier");
		addQuantity(quantity);
		LOGGER.info(Integer.toString(quantity) + " produits ajoutes au panier");
//		addQuantity(quantity, product);
//		LOGGER.info(Integer.toString(quantity) + " " + product + " ajoutes au panier");
//		addQuantity(quantity, numberOfProducts + 2);
//		LOGGER.info(Integer.toString(quantity) + " produits de l'index " + (Integer.toString(numberOfProducts) + 2) + " au panier");
		goToRecapBasket();
		LOGGER.info("En chemin pour le detail panier");
	}
	
	//**********************\\
	// 		  CLICK			\\
	//**********************\\
	
	//ajoute numberOfProducts produits différents au panier
	public void clickOnProduct(int numberOfProducts) {
		By product;

		product = By.xpath(btn_addToBasket + "[" + Integer.toString(numberOfProducts) + "]");
		for (int x = 1; x <= numberOfProducts; x ++) {
			this.getClickManager().waitAndClick(product);
		}
	}

	//ajoute quantity premier produit de la liste au panier
	public void addQuantity(int quantity) {
		for (int x = 0; x < quantity; x ++) {
			this.getClickManager().waitAndClick(btn_addQuantity);
		}
	}
	
	//ajoute quantity produits au panier avec le xpath suivant
	public void addQuantity(int quantity, String productName) {
		By product;
		//p[contains(text(),'Aubergine  1kg')]//../../div/div/div/span
		product = By.xpath("//p[contains(text(),'" + productName + "')]//../../div/div/div/span");
		driver.findElement(product).sendKeys(Integer.toString(quantity));
	}

	//ajouter quantity produits au n° index de la liste
	//ATTENTION: si cette methode est appelee apres "clickOnProduct", index doit etre plus grand que numberOfProducts
	public void addQuantity(int quantity, int index) {
		if (index < 0)
			LOGGER.info("index ne peut pas etre negatif: impossible d'ajouter un produit avec un index negatif...");
		else if (index > 0) {
			By product;
			product = By.xpath(btn_addToBasket + "[" + Integer.toString(index) + "]");
			this.getClickManager().waitAndClick(product);
			product = By.xpath("(" + btn_addQuantity + ")[" + Integer.toString(index) + "]");
			for (int x = 0; x < quantity; x ++) {
				this.getClickManager().waitAndClick(product);
			}
		}
	}
	
	public void goToRecapBasket() {
		this.getClickManager().waitAndClick(btn_basketRecap);
	}
}
