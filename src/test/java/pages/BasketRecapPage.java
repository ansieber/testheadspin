package pages;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import base.BasePage;

public class BasketRecapPage extends BasePage {
	
	private static By btn_validateNpay;
	private static By idLVisuel;
	private static By idRetour;
	private static By idProduit1;
	private static By idProduit2;
	private static By idProduit3;
	private static By idProduit4;
	private static By idProduit5;
	private static By idLanguette;
	private static By idIdentifier;
	private static By idRetourPanier;
	private static By idCreateCompte;
	private static By idBack;
	private static By idPointRetrait;
	private static By idTitle;
	private static By idLinkBack;
	private static By idBasket;
	private static By idTotalP;
	private static By footer;
	
	public BasketRecapPage() {
		if (getPlatform().equals("ANDROID")) {
			btn_validateNpay = By.xpath("//a[contains(text(),'Valider')]");
			idLVisuel = By.xpath("//li[contains(@id,'sId')]/div/a/img");
			idRetour = By.xpath("//span[contains(@class,'animee')]");
			idProduit1 = By.xpath("(//p[contains(@class,'Prix')])[1]");
			idProduit2 = By.xpath("(//p[contains(@class,'Prix')])[2]");
			idProduit3 = By.xpath("(//p[contains(@class,'Prix')])[3]");
			idProduit4 = By.xpath("(//p[contains(@class,'Prix')])[4]");
			idProduit5 = By.xpath("(//p[contains(@class,'Prix')])[5]");
			idRetour = By.xpath("//span[contains(@class,'animee')]");
			idLanguette = By.xpath("//a[contains(@class,'Languette')]");
			idIdentifier = By.xpath("//a[contains(@id,'MIdentifier')]");
			idRetourPanier = By.xpath("(//span[contains(@class,'animee')])[5]");
			idCreateCompte = By.xpath("//span[contains(@id,'CreerCompte')]");
			idBack = By.xpath("(//span[contains(@class,'animee')])[1]");
			idPointRetrait = By.xpath("//p[contains(@class,'TitreRetrait')]");
			idTitle = By.xpath("(//p[contains(@id,'Titre')])[1]");
			idLinkBack = By.xpath("//li[contains(@class,'LienRetourAuMagasin')]");
			idBasket = By.xpath("//a[contains(@class,'panier')]");
			idTotalP = By.xpath("//span[contains(@class,'MontantTotalLanguette')]");
			footer = By.xpath("//footer[not(contains(@class,'Languette open')) and not(contains(@class,'Pied'))]");
		} else if (getPlatform().equals("IOS")) {
			btn_validateNpay = By.xpath("//a[contains(text(),'Valider')]");
			idLVisuel = By.xpath("//li[contains(@id,'sId')]/div/a/img");
			idRetour = By.xpath("//span[contains(@class,'animee')]");
			idProduit1 = By.xpath("(//p[contains(@class,'Prix')])[1]");
			idProduit2 = By.xpath("(//p[contains(@class,'Prix')])[2]");
			idProduit3 = By.xpath("(//p[contains(@class,'Prix')])[3]");
			idProduit4 = By.xpath("(//p[contains(@class,'Prix')])[4]");
			idProduit5 = By.xpath("(//p[contains(@class,'Prix')])[5]");
			idRetour = By.xpath("//span[contains(@class,'animee')]");
			idLanguette = By.xpath("//a[contains(@class,'Languette')]");
			idIdentifier = By.xpath("//a[contains(@id,'MIdentifier')]");
			idRetourPanier = By.xpath("(//span[contains(@class,'animee')])[5]");
			idCreateCompte = By.xpath("//span[contains(@id,'CreerCompte')]");
			idBack = By.xpath("(//span[contains(@class,'animee')])[1]");
			idPointRetrait = By.xpath("//p[contains(@class,'TitreRetrait')]");
			idTitle = By.xpath("(//p[contains(@id,'Titre')])[1]");
			idLinkBack = By.xpath("//li[contains(@class,'LienRetourAuMagasin')]");
			idBasket = By.xpath("//a[contains(@class,'panier')]");
			idTotalP = By.xpath("//span[contains(@class,'MontantTotalLanguette')]");
			footer = By.xpath("//footer[not(contains(@class,'Languette open')) and not(contains(@class,'Pied'))]");
		}
	}
	
	public void validBasketRecap(String PointRetarit,String Title) throws InterruptedException {
		BasketTitle(Title);
		CheckName(PointRetarit);
		ClickOnLibelle();
		ClickOnBackP();
		ClickOnIdentify();
		ClickOnBackBasket();
		ClickOnCreateCompte();
		ClickOnBack();
		//ClickOnLinkBack();
		ProductPrice();
		validateNpay();
	}
	
	
	//**********************\\
	// 		  CLICK			\\
	//**********************\\
	
	//valider et payer le panier
	public void validateNpay() throws InterruptedException {
		Thread.sleep(1000);
		this.getClickManager().waitAndClick((btn_validateNpay));
	}
	
	
	public void ClickOnLibelle() {
		this.getClickManager().waitAndClick((idLVisuel));
	}
	
	public void ClickOnBackP() throws InterruptedException {
		Thread.sleep(1000);
		this.getClickManager().waitAndClick((idRetour));
		
	}
	
	public void ClickOnIdentify() throws InterruptedException {
		Thread.sleep(10000);
		this.getClickManager().waitAndClick((idLanguette));
		this.getClickManager().waitAndClick((idIdentifier));
	}
	
	
	public void ClickOnBackBasket() throws InterruptedException {
		Thread.sleep(1000);
		//this.getClickManager().waitAndClick((idRetourPanier));
		
		WebElement ele = driver.findElement(idRetourPanier);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
	}
	public void ClickOnCreateCompte() throws InterruptedException {
		Thread.sleep(10000);
		this.getClickManager().waitAndClick((idLanguette));
		this.getClickManager().waitAndClick((idCreateCompte));
		
	}
	public void ClickOnBack() throws InterruptedException {
		Thread.sleep(1000);
		this.getClickManager().waitAndClick((idBack));
		
	}
	public void ClickOnLinkBack() throws InterruptedException {
		Thread.sleep(1000);
		this.getClickManager().waitAndClick((idLinkBack));
		this.getClickManager().waitAndClick((idBasket));
		
		
	}
	
	    //**********************\\
		// 		  INPUT		\\
		//**********************\\
	
	
	public void CheckName(String text) {
	
		driver.findElement(idPointRetrait).getText().contains(text);
	
	}
	
	
	public void ProductPrice() {
		String PrixProd1=driver.findElement(idProduit1).getText();
		String P1=PrixProd1.replaceAll(" €", "");
		double Prix1 = Double.parseDouble(P1);
		
		
		
		/*
		String PrixProd2=driver.findElement(idProduit2).getText();
		String P2 PrixP2.replaceAll(" €", "");
		double Prix2 = Double.parseDouble(P2);
		
		String PrixProd3=driver.findElement(idProduit3).getText();
		String P3=PrixProd3.replaceAll(" €", "");
		double Prix3 = Double.parseDouble(P3);
		
		String PrixProd4=driver.findElement(idProduit4).getText();
		String P4=PrixProd4.replaceAll(" €", "");
		double Prix4 = Double.parseDouble(P4);
		
		String PrixProd5=driver.findElement(idProduit5).getText();
		PrixProd5.replaceAll(" €", "");
		double Prix5 = Double.parseDouble(P5);
		*/
			
		
		String PrixT=driver.findElement(idTotalP).getText();
		String T=PrixT.replaceAll(" €", "");
		double Total = Double.parseDouble(T);
		System.out.println("le total est : "+Total);
		
		
	 
		
	   
		
	
		double TotalPanier = Prix1;
		
		System.out.println("le total est : "+TotalPanier);
		if(TotalPanier != Total){
			throw new java.lang.RuntimeException("Total n'est pas correcte ");
		}
	}
	
	
	
	
	public void BasketTitle(String text) {
		
	driver.findElement(idPointRetrait).getText().contains(text);
		
	}
	
		

}
