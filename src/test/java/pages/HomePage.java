package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class HomePage extends BasePage {
	private static By btn_chooseMagasin;
	private static By input_saisirCodePostal;
	private static By span_messageErreur;
	private static By li_autoCompletion;
	private static By li_resulatRecherche;
	private static By btn_accederAuDrive;
	private static String btn_clickOnCity;

	public HomePage() {
		if (getPlatform().equals("ANDROID")) {
			btn_chooseMagasin = By.xpath("(//span[contains(text(),'Ville ou code postal')])[1]");
			input_saisirCodePostal = By.xpath("(//input[contains(@id,'Recherche')])[1]");
			span_messageErreur = By.xpath("//div[contains(@id,'ResultatPointsRetrait')]//dt");
			li_autoCompletion = By.xpath("//div[contains(@id,'ResultatVilles')]//li[1]");
			li_resulatRecherche = By.xpath("//div[contains(@id,'ResultatPointsRetrait')]//li[1]");
			btn_accederAuDrive = By.xpath("//a[contains(text(),'Entrer dans ce')]");
			btn_clickOnCity = "//a[contains(@data-description,'";
		} else if (getPlatform().equals("IOS")) {
			btn_chooseMagasin = By.xpath("(//span[contains(text(),'Ville ou code postal')])[1]");
			input_saisirCodePostal = By.xpath("(//input[contains(@id,'Recherche')])[1]");
			span_messageErreur = By.xpath("//div[contains(@id,'ResultatPointsRetrait')]//dt");
			li_autoCompletion = By.xpath("//div[contains(@id,'ResultatVilles')]//li[1]");
			li_resulatRecherche = By.xpath("//div[contains(@id,'ResultatPointsRetrait')]//li[1]");
			btn_accederAuDrive = By.xpath("//a[contains(text(),'Entrer dans ce')]");
			btn_clickOnCity = "//a[contains(@data-description,'";
		}
	}

	public void recherchePointDeVente(String url, String NomMagasinKO, String NomMagasinOK) {
		openBrowser(url);
		cliquerSurLaBarreRechercheMagasin();
		saisirUnMagasinKO(NomMagasinKO);
		verifierMessageErreur();
		saisirNomMagasinOK(NomMagasinOK);
		verifierAutoCompletion();
		cliquerSurAutocompletion();
		cliquerSurResulatDeRecherche();
		cliquerSurSelectionnerCeDrive();
		LOGGER.info("Select magasin");
	}

	// ouvrir le navigateur
	public void openBrowser(String url) {
		this.getWebManager().openUrl(url);
	}

	// **********************\\
	// 			CLICK 		 \\
	// **********************\\

	// ouvre la page de recherche de magasin
	public void cliquerSurLaBarreRechercheMagasin() {
		this.getClickManager().waitAndClick((btn_chooseMagasin));
		LOGGER.info("cliquer sur la zone de recherche");
	}

	public void saisirUnMagasinKO(String NomMagasinKO) {
		driver.findElement(input_saisirCodePostal).sendKeys(NomMagasinKO);

		LOGGER.info("saisir nom de magasin KO : " + NomMagasinKO);

		this.getClickManager().waitAndClick(By.xpath(btn_clickOnCity + NomMagasinKO + "')]"));
	}

	public void verifierMessageErreur() {

		Boolean messageErreur = this.getPresentManager().isPresent(span_messageErreur);

		if (messageErreur) {
			LOGGER.info("le message d'erreur est affich�");
		} else {

			throw new java.lang.RuntimeException("le message erreur magasin n'est pas affich� ");

		}

	}

	public void saisirNomMagasinOK(String NomMagasinOK) {
		
		/*//Cette methode est a utiliser en cas de application et non en web
		this.getInputManager().inputAndClear(input_saisirCodePostal, NomMagasinOK);
		LOGGER.info("saisir Nom du magasin OK : "+ NomMagasinOK);*/
		
		//Je vois que ca pour l'instant de fonctionnel.
		WebElement elm = driver.findElement(input_saisirCodePostal);
		elm.clear();
		elm.sendKeys(NomMagasinOK);
		LOGGER.info("saisir Nom du magasin OK : "+ NomMagasinOK);
	}

	public void verifierAutoCompletion() {

		boolean autocompletionVisible = this.getPresentManager().isPresent(li_autoCompletion);
		
		if (autocompletionVisible) {
			LOGGER.info("autocompletion est affich�e");
		}else {
			
			throw new java.lang.RuntimeException(" l'autocompletion n'est pas affich�e ");
		}
	}

	public void cliquerSurAutocompletion() {
		
		this.getClickManager().waitAndClick(li_autoCompletion);
		LOGGER.info("cliquer sur le 1 er choix de l'auto completion ");

	}

	public void cliquerSurResulatDeRecherche() {

		this.getClickManager().waitAndClick(li_resulatRecherche);
		LOGGER.info(" selectionner le resultat du recherche ");
		
	}

	public void cliquerSurSelectionnerCeDrive() {
		
		this.getClickManager().waitAndClick(btn_accederAuDrive);
		LOGGER.info("cliquer sur le bouton choisir ce drive");
		
	}

}