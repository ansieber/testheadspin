package keywords.base;

import org.openqa.selenium.By;

public interface Tap {

	/**
	 * Effectue une pression sur le centre de l'élément donné.
	 * Le tap fonctionne pour tous les éléments (image, texte, etc...)
	 * @param by La location de l'élément
	 */
	public void tap(By by);
	
	/**
	 * Effectue une pression sur un point {x, y} donné.
	 * 
	 * @param x Coordonnée X
	 * @param y Coordonnée Y
	 */
	public void tap(int x, int y);
	public void longPress(int x, int y);
}
