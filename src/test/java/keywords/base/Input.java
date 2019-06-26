package keywords.base;

import org.openqa.selenium.By;

public interface Input {
	
	/**
	 * Attends que l'élément soit présent, puis visible et 
	 * enfin entre le texte donné dans l'élément donné. 
	 * La méthode est affectée par l'`implicit wait`.
	 *  
	 * @param by La location de l'élément
	 * @param text Le texte a entrer dans l'élément donné
	 */
	public void input(By by, String text);

	/**
	 * Attends que l'élément soit présent, puis visible et 
	 * enfin entre le texte donné dans l'élément donné. 
	 * La méthode est affectée par l'`implicit wait`.
	 *  
	 * @param by La location de l'élément
	 * @param text Le texte a entrer dans l'élément donné
	 */
	public void inputAndPressEnter(By by, String text);
	
	/**
	 * Attends que l'élément soit présent, puis visible,
	 * supprime les données dans l'élément, puis entre
	 * le texte.
	 * La méthode est affectée par l'`implicit wait`.
	 * 
	 * @param by La location de l'élément
	 * @param text Le texte a entrer dans l'élément donné
	 */
	public void inputAndClear(By by, String text);
}
