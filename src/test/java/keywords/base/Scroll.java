package keywords.base;

public interface Scroll {
	
	/**
	 * Effectue un scroll des coordonnées {fromX, fromY} à
	 * {toX, toY} 
	 * 
	 * @param fromX Départ du point X
	 * @param fromY Départ du point Y
	 * @param toX Fin du point X
	 * @param toY Fin du point Y
	 */
	public void scroll(int fromX, int fromY, int toX, int toY);
	public void scrollDown();
	public void scrollUp();
	public void scrollLeft();
	public void scrollRight();
}
