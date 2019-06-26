package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class PaymentPage extends BasePage {
	
	private static By btn_Valider;
	private static By id_Card;
	private static By id_Code;
	private static By id_TypeCard;
	private static By btn_ValiderPaiement;
	private static By id_month;
	private static By id_year;
	private static By id_DateExpiration;
	
	public PaymentPage() {
		if (getPlatform().equals("ANDROID")) {
			btn_Valider = By.xpath("(//a[contains(@id,'lkbContinuerPaiement')])[1]");
			id_Card= By.xpath("//iframe[contains(@id,'cardNumber')]");
			id_Code= By.xpath("//input[contains(@name,'cvx')]");
			//id_TypeCard= By.xpath("(//input[contains(@name,'type')])[1]");
			//id_month= By.xpath("//select[contains(@id,'month')]");
			//id_year= By.xpath("//select[contains(@id,'year')]");//
			id_DateExpiration = By.xpath("(//input[contains(@class,'input')])[2]");
			btn_ValiderPaiement = By.xpath("//button[contains(@id,'payBtn')]");
			
		} else if (getPlatform().equals("IOS")) {
			btn_Valider = By.xpath("(//a[contains(@id,'lkbContinuerPaiement')])[1]");
			id_Card= By.xpath("//iframe[contains(@id,'cardNumber')]");
			id_Code= By.xpath("//input[contains(@name,'cvx')]");
			//id_TypeCard= By.xpath("(//input[contains(@name,'type')])[1]");
			//id_month= By.xpath("//select[contains(@id,'month')]");
			//id_year= By.xpath("//select[contains(@id,'year')]");//
			id_DateExpiration = By.xpath("(//input[contains(@class,'input')])[2]");
			btn_ValiderPaiement = By.xpath("//button[contains(@id,'payBtn')]");
			
		}
	}
	
	public void DoPayment(String card,String codeSecure,String date) {
		ClickOnValider();
		InputCard(card);
		InputDateExpiration(date);
		InputCode(codeSecure);
		ValiderPaiement();
		
		
	}
	
	//**********************\\
	// 		  CLICK			\\
	//**********************\\
	
	
	public void ClickOnValider() {
		this.getClickManager().waitAndClick((btn_Valider));
	}
	
	
	
	
	public void ValiderPaiement() {
		this.getClickManager().waitAndClick((btn_ValiderPaiement));
	}
	
	
	    //**********************\\
		// 		 Input		\\
		//**********************\\
	
	
	public void InputCard(String text) {
		this.getClickManager().waitAndClick(id_Card);
		driver.findElement(id_Card).sendKeys(text);
	}
		

	public void InputCode(String text) {
		this.getClickManager().waitAndClick(id_Code);
		driver.findElement(id_Code).sendKeys(text);
		
	}
	
	public void InputDateExpiration(String text) {
		this.getClickManager().waitAndClick(id_DateExpiration);
		driver.findElement(id_DateExpiration).sendKeys(text);
	}
	

}