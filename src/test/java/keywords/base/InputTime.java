package keywords.base;

public interface InputTime {
	
	/**
	 *  Entre l'heure donné puis clique sur le bouton 'OK'.
	 *  Si vous êtes sur mobile, faîte un clique sur l'élément
	 *  de l'heure avant.
	 *  
	 * @param hour L'heure en chaîne de caractère, sous format 'hh' ou 'h'
	 * @param minute Les minutes en chaîne de caractère, sous format 'mm' ou 'm'.
	 */
	public void inputTime(String hour, String minute);
}
