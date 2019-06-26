package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseTest;
import dataObject.Accounts;
import pages.AdvantagePage;
import pages.BasketPage;
import pages.BasketRecapPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MagasinHomePage;
import pages.PaymentPage;
import pages.ResearchPage;
import pages.ResultPage;
import pages.SchedulePage;

public class BuyProduct extends BaseTest {

	@Test(groups = { "APPIUM_ANDROID_CHROME" })
	public void buyProduct() throws InterruptedException, Exception {
		HomePage home_page = new HomePage();
		ResearchPage research_page = new ResearchPage();
		MagasinHomePage magasin_home_page = new MagasinHomePage();
		ResultPage result_page = new ResultPage();
		LoginPage  Login_page = new LoginPage();
		AdvantagePage Advantage_page = new AdvantagePage();
		Accounts accounts =new Accounts();
		PaymentPage payment_page=new PaymentPage();
		BasketPage basket_page = new BasketPage();
		SchedulePage schedule_page = new SchedulePage();
		BasketRecapPage basketRecap_page = new BasketRecapPage();
		
		
		
		magasin_home_page.selectProducts();
		LOGGER.info("Product selected");
		takeScreenshot("selectProduct", LogStatus.PASS);

		result_page.selectProducts();
		LOGGER.info("Product added to basket");
		takeScreenshot("productAddedBasket", LogStatus.PASS);

		basket_page.validBasket("Prochain retrait disponible :","Détail panier ");
		LOGGER.info("Basket validated");
		takeScreenshot("basketValidated", LogStatus.PASS);

		schedule_page.chooseHour();
		LOGGER.info("Hour choosed");
		takeScreenshot("hourChoosed", LogStatus.PASS);
		
		basketRecap_page.validBasketRecap("Retrait choisi :","Détail panier ");
		LOGGER.info("BasketRecap validated");
		takeScreenshot("basketRecapValid", LogStatus.PASS);
	
		/*Login_page.connectionChampsVide("","","Veuillez saisir votre adresse email","Veuillez saisir votre mot de passe");
		LOGGER.info("Veuillez saisir email et Mdp");
		takeScreenshot("emailPassword", LogStatus.PASS);

		//Faux mot de passe
		Login_page.connectionMailInvalid("clark.k@yopmail.c","Sogeti_33","Votre login et/ou votre mot de passe est incorrect. Veuillez le(s) saisir à nouveau.");
		LOGGER.info("mot de passe ou mail incorrect");
		takeScreenshot("incorrectInfoValidated", LogStatus.PASS);*/
	
		Login_page.connection(accounts.getEmail(),accounts.getPassword());
		LOGGER.info("Client connecté");
		takeScreenshot("clientLogged", LogStatus.PASS);
		
		
		//Page avantage
		Advantage_page.ValidAdvantage("Avantages","Votre horaire de retrait","Votre commande *", "Total à payer :");
		LOGGER.info("paiement s'affiche");
		takeScreenshot("advantagePassed", LogStatus.PASS);

/*		
		//page paiement
		payment_page.DoPayment(accounts.getCardNumber(),accounts.getDateExp(),accounts.getCode());
*/		
		
		try {
			Thread.sleep(10000 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}