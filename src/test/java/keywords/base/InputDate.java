package keywords.base;

import org.openqa.selenium.By;

public interface InputDate {
	
	/**
	 * Ecriture de la date donnée dans un élément donné. L'élément donné 
	 * doit être visible dans le DOM. La méthode est affecté par l'`implicit wait`.
	 * 
	 * @param by La location de l'élément
	 * @param date La date en chaîne de caractère sous le format dd/MM/yyyy
	 */
	public void inputDate(By by, String date);
}
