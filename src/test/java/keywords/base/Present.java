package keywords.base;

import org.openqa.selenium.By;

public interface Present {
	
	/**
	 * Vérifie si un élément est présent sur le DOM.
	 * La méthode modifie l'`implicit wait` à 10 secondes 
	 * puis le remet à la valeur par défaut.
	 * 
	 * @param by La location de l'élément
	 * @return Si l'élément est présent sur le DOM
	 */
	public boolean isPresent(By by);
	
	/**
	 * Vérifie si un texte est présent dans la page.
	 *  
	 * @param text Le texte a vérifier sa présence dans la page
	 * @return Si le texte est présent dans la page
	 */
	public boolean checkTextPresent(String text);
	
	/**
	 * Vérifie si un texte est présent dans l'élément donné.
	 * 
	 * @param by La location de l'élément
	 * @param text Le texte a vérifier sa présence dans un élément
	 * @return Si le texte donné est présent dans l'élément donné
	 */
	public boolean checkTextPresentWithBy(By by, String text);
}
