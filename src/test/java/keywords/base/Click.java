package keywords.base;

import org.openqa.selenium.By;

public interface Click {

	/**
	 * Attend que l'élément soit présent, visible et cliquable, puis clique.
	 * La méthode est affectée par l'`implicit wait`.
	 * 
	 * @param by La location de l'élément
	 */
	public void waitAndClick(By by);
	
	/**
	 * Fais en premier lieu un chargement AJAX, puis attends que l'élément
	 * soit présent, visible et cliquable, puis clique.
	 * La méthode est affectée par l'`implicit wait`.
	 * 
	 * @param by La location de l'élément
	 */	
	public void waitAjaxAndClick(By by);
}
