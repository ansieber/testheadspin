package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class LoginPage extends BasePage {
	private static By input_email;
	private static By input_password;
	private static By btn_signin;
	private static By idLoginValidation;
	private static By idMdpValidation;
	private static By idMdpMailValidation;
	
	public LoginPage() {
		if (getPlatform().equals("ANDROID")) {
			input_email = By.xpath("(//input[contains(@id,'Login')])[1]");
			input_password = By.xpath("//input[contains(@id,'Mdp')]");
			btn_signin = By.xpath("(//a[contains(@id,'Connecter')])[2]");
			idLoginValidation=By.xpath("(//a[contains(@id,'Connecter')])[2]");
			idMdpValidation=By.xpath("(//span[contains(@id,'MdpValidation')])[2]");
			idMdpMailValidation=By.xpath("(//span[contains(@id,'MdpValidation')])[1]");
			
		} else if (getPlatform().equals("IOS")) {
			input_email = By.xpath("(//input[contains(@id,'Login')])[1]");
			input_password = By.xpath("//input[contains(@id,'Mdp')]");
			btn_signin = By.xpath("(//a[contains(@id,'Connecter')])[2]");
			idLoginValidation=By.xpath("(//a[contains(@id,'Connecter')])[2]");
			idMdpValidation=By.xpath("(//span[contains(@id,'MdpValidation')])[2]");
			idMdpMailValidation=By.xpath("(//span[contains(@id,'MdpValidation')])[1]");
			
		}
	}
	
	public void connection(String email, String password) {
		addEmail(email);
		addPassword(password);
		signin();
	}
	public void connectionChampsVide(String email, String password,String ErrorEmail,String ErrorPwd) {
		addEmail(email);
		addPassword(password);
		signin();
		checkMessageLogin(ErrorEmail);
		checkMessagePwd(ErrorPwd);
		
		
	}
	
	
	public void connectionMailInvalid(String email, String password,String ErrorMailMdp) {
		addEmail(email);
		addPassword(password);
		signin();
		checkMessageEmailPwd(ErrorMailMdp);
		
	}
	
	//**********************\\
	// 		  CLICK			\\
	//**********************\\
	
	//se connecter
	public void signin() {
		this.getClickManager().waitAndClick((btn_signin));
	}
	
	//**********************\\
	// 		  INPUT			\\
	//**********************\\
	
	//entrer un email
	public void addEmail(String text) {
		//this.getInputManager().inputAndClear((input_email), text);
		this.getClickManager().waitAndClick(input_email);
		driver.findElement(input_email).clear();
		driver.findElement(input_email).sendKeys(text);
	}
	
	//entrer un mot de passe
	public void addPassword(String text) {
		this.getClickManager().waitAndClick(input_password);
		driver.findElement(input_password).clear();
		driver.findElement(input_password).sendKeys(text);
	}
    
	
	public void checkMessageLogin(String text) {
		driver.findElement(idLoginValidation).getText().contains(text);
		
	}

	
	public void checkMessagePwd(String text) {
		driver.findElement(idMdpValidation).getText().contains(text);
		
	}
	
	public void checkMessageEmailPwd(String text) {
		driver.findElement(idMdpMailValidation).getText().contains(text);
		
	}
	
}