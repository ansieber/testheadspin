package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class AdvantagePage extends BasePage {
	
	private static By btn_ValiderPayer;
	private static By idTitle;
	private static By idHoraireRet;
	private static By idCommande;
	private static By idTotalPanier;
	private static By idTotalPayer;
	private static By idTextTotalPayer;
	private static By idCGV;
	private static By idBack;
	//private static By prod = "http://wwww.leclerc.drive.fr";
	

	
	public AdvantagePage() {
		HomePage home_page = new HomePage();
		if (getPlatform().equals("ANDROID")) {
			//String u=driver.getCurrentUrl();
			//if (u.contains("https://www.leclercdrive.image.its.dnsi")) {
			
			idTotalPanier=By.xpath("(//span[contains(@id,'Valeur')])[2]");
			idTotalPayer=By.xpath("(//span[contains(@id,'Valeur')])[3]");
			idTextTotalPayer=By.xpath("(//span[contains(@id,'Texte')])[3]");
			
			
			idTitle=By.xpath("//span[contains(@id,'TitreEnTete')]");
			idHoraireRet=By.xpath("//span[contains(@id,'lblHoraireRetraitTitre')]");
			btn_ValiderPayer = By.xpath("//a[contains(@id,'lnkRegler')]");
			idCommande = By.xpath("//span[contains(@id,'lblCommandeTitre')]");
			idCGV=By.xpath("//span[contains(@class,'CGV')]");	
		} else if (getPlatform().equals("IOS")) {			
			idTotalPanier=By.xpath("(//span[contains(@id,'Valeur')])[2]");
			idTotalPayer=By.xpath("(//span[contains(@id,'Valeur')])[3]");
			idTextTotalPayer=By.xpath("(//span[contains(@id,'Texte')])[3]");
			idTitle=By.xpath("//span[contains(@id,'TitreEnTete')]");
			idHoraireRet=By.xpath("//span[contains(@id,'lblHoraireRetraitTitre')]");
			btn_ValiderPayer = By.xpath("//a[contains(@id,'lnkRegler')]");
			idCommande = By.xpath("//span[contains(@id,'lblCommandeTitre')]");
			idCGV=By.xpath("//span[contains(@class,'CGV')]");	
		}
	}
	
	public void ValidAdvantage(String Title,String Horaire,String Commande,String Total) throws InterruptedException {
		CheckTitle(Title);
		CheckHoraire(Horaire);
		CheckHoraire(Commande);
		CheckTotalCommande(Total);
		//CheckOnCGV();
		ValiderPayer();
	}
	
	//**********************\\
	// 		  CLICK			\\
	//**********************\\
	
	
	public void ValiderPayer() {
		this.getClickManager().waitAndClick((btn_ValiderPayer));
	}
	
	public void CheckOnCGV() throws InterruptedException {
		this.getClickManager().waitAndClick((idCGV));
		Thread.sleep(1000);
		driver.close();
		
	}
	
	    //**********************\\
		// 		  INPUT		\\
		//**********************\\
		
	
	public void CheckTitle(String text) {
		
		driver.findElement(idTitle).getText().contains(text);
	
	}
    public void CheckHoraire(String text) {
		
		driver.findElement(idHoraireRet).getText().contains(text);
	
	}
    public void CheckCommande(String text) {
		
  		driver.findElement(idCommande).getText().contains(text);
  		String PrixPanier=driver.findElement(idTotalPanier).getText();
  	}
    
  		
    public void CheckTotalCommande(String text) {
	 driver.findElement(idTextTotalPayer).getText().contains(text);
	 String PrixPanier=driver.findElement(idTotalPayer).getText();
	
    }
}