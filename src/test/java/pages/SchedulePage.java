package pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import base.BasePage;

public class SchedulePage extends BasePage {
	private static By btn_ValiderChoixHoraire;
	private static By btn_hourChoice;
	private static String idHeureRetrait;
	private static By idTabItem;
	private static By idHelp;
	private static By idChoixCr;
	private static By idCalendrier;
	private static By jourRetrait;
	
	public SchedulePage() {
		if (getPlatform().equals("ANDROID")) {
			btn_ValiderChoixHoraire = By.xpath("//a[contains(@id,'ChoisirHoraire')]");
			idCalendrier=By.xpath("//a[contains(@href,'tab1J2')]");
			//idHeureRetrait=By.xpath("//input[contains(@value,'");
			idHeureRetrait="(//div[@id='tab1J2']//li[@class='' or contains(@class,'Affluence')]/span[contains(@class,'Radio')]/input)[";
			idTabItem=By.xpath("//div[contains(@class,'clearfix')][2]");
			idHelp=By.xpath("//span[contains(@id,'Aide')]");
			idChoixCr=By.xpath("//a[contains(@class,'LienChoixRetrait')]");
		} else if (getPlatform().equals("IOS")) {
			btn_ValiderChoixHoraire = By.xpath("//a[contains(@id,'ChoisirHoraire')]");
			idCalendrier=By.xpath("//a[contains(@href,'tab1J2')]");
			//idHeureRetrait=By.xpath("//input[contains(@value,'");
			idHeureRetrait="(//div[@id='tab1J2']//li[@class='' or contains(@class,'Affluence')]/span[contains(@class,'Radio')]/input)[";
			idTabItem=By.xpath("//div[contains(@class,'clearfix')][2]");
			idHelp=By.xpath("//span[contains(@id,'Aide')]");
			idChoixCr=By.xpath("//a[contains(@class,'LienChoixRetrait')]");
		}
	}
	
	public void chooseHour() throws InterruptedException, IOException {
		clickOnHeurRetrait();
		clickOnHelp();
		clickOncalendar();
		clickOnHeurRetrait();
		Thread.sleep(5 * 1000);
		clickOnValider();
	}
	
	//**********************\\
	// 		  CLICK			\\
	//**********************\\
	
	//choisir le jour de retrait
	public void clickOncalendar() throws InterruptedException {
	/*
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(350,400)");
        
		this.getClickManager().waitAndClick(idCalendrier);
		Thread.sleep(1000);
		*/
		
		WebDriverWait wait = new WebDriverWait (driver, 10);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		WebElement e1 = driver.findElement(idCalendrier);
		Thread.sleep(5 * 1000);
		js.executeScript("arguments[0].scrollIntoView(true); ", e1);
		js.executeScript("arguments[0].click();", e1);  
				
	}

	//choisir l'heure de retrait
	public void clickOnHeurRetrait() throws InterruptedException, IOException {
		
		WebDriverWait wait = new WebDriverWait (driver, 10);
		JavascriptExecutor js= (JavascriptExecutor) driver;

		WebElement e1 = driver.findElement(By.xpath(idHeureRetrait + "1]"));
		js.executeScript("arguments[0].scrollIntoView(true); ", e1);
		js.executeScript("arguments[0].click();", e1);
		takeScreenshot("firstHour", LogStatus.PASS);
		e1 = driver.findElement(By.xpath(idHeureRetrait + "7]"));
		js.executeScript("arguments[0].click();", e1);
		takeScreenshot("secondHour", LogStatus.PASS);
		e1 = driver.findElement(By.xpath(idHeureRetrait + "10]"));
		js.executeScript("arguments[0].click();", e1);
		takeScreenshot("thirdHour", LogStatus.PASS);
 
	}
	//Cliquer sur le bouton valider
	public void clickOnValider() {
		this.getClickManager().waitAndClick(btn_ValiderChoixHoraire);
	}
	
	//Cliquer sur le bouton aide
	public void clickOnHelp() {
		this.getClickManager().waitAndClick(idHelp);
		
		
		WebDriverWait wait = new WebDriverWait (driver, 10);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		WebElement e1 = driver.findElement(idChoixCr);
		js.executeScript("arguments[0].scrollIntoView(true); ", e1);
		js.executeScript("arguments[0].click();", e1);
		
		 
	} 
	
}