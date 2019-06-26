package keywords.base.appium.android;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import io.appium.java_client.MobileElement;
import keywords.base.InputDate;
import keywords.base.PresentManager;
import keywords.base.appium.ScrollManagerAppium;
import utils.Common;

public class InputDateManagerAndroid extends BaseTest implements InputDate {
	
	@Override
	public void inputDate(By by, String date) {
		PresentManager present = new PresentManager();
		
		if(!present.isPresent(By.xpath("//*[@resource-id = 'android:id/datePicker']//android.widget.NumberPicker"))) {
			if (!present.isPresent(By.xpath("//*[@resource-id = 'android:id/date_picker_month_day_year_layout']"))) {
				try {
					//version 6 et + d'android 
					inputDateAndroidVersion6Plus(date);
				} catch (ParseException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					// version android 5
					inputDateAndroidVersion5(date);
				} catch (ParseException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				// version 4
				inputDateAndroidVersion4(date);
			} catch (ParseException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//logAndScreenshot("Saisie de date:"+date);
	}
	
	private void inputDateAndroidVersion5(String inputAsString) throws ParseException, InterruptedException {
		//conversion string => date
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
		Date inputDate = format.parse(inputAsString);
		ScrollManagerAppium scrollManager = new ScrollManagerAppium();
				
		//zone de selection
		MobileElement calendarZone = androidDriver.findElementById("android:id/animator");
		
		//Selection annee
		MobileElement selectedYear = androidDriver.findElementById("android:id/date_picker_year");
		selectedYear.click();
		
		//Selection de la bonne annee
		String neededYear = new SimpleDateFormat("yyyy", Locale.FRANCE).format(inputDate);
		while(androidDriver.findElementsByXPath("//*[@resource-id = 'android:id/month_text_view'][contains(@content-desc, "+ neededYear+")]").isEmpty()) {
			//Scroll dans la bonne direction selon que l'annee recherche est < ou > a l'annee affichee
			if(Integer.parseInt((androidDriver.findElementsByXPath("//*[@resource-id = 'android:id/month_text_view']").get(0)).getText()) > Integer.parseInt(neededYear)) {
				scrollManager.scroll(calendarZone.getCenter().x, calendarZone.getLocation().y + 100, calendarZone.getCenter().x, calendarZone.getLocation().y + calendarZone.getSize().height - 100);
			}
			else if(Integer.parseInt((androidDriver.findElementsByXPath("//*[@resource-id = 'android:id/month_text_view']").get(0)).getText()) < Integer.parseInt(neededYear)) {
				scrollManager.scroll(calendarZone.getCenter().x, calendarZone.getLocation().y + calendarZone.getSize().height - 100, calendarZone.getCenter().x, calendarZone.getLocation().y + 100);
			}
					
			//On clique ensuite dessus si on a trouve
			if(!androidDriver.findElementsByXPath("//*[contains(@text, '"+ neededYear +"')]").isEmpty()) {
				(androidDriver.findElementByXPath("//*[contains(@text, '"+ neededYear +"')]")).click();
			}
			Common.sleep(1000);
		}
		
		androidDriver.findElementByXPath("//*[@resource-id = 'android:id/month_text_view'][contains(@content-desc, "+ neededYear+")]").click();
		
		//Variables utilisees pour passer du nom d'un mois et obtenir son numero (janvier -> 01)
		Date tempDate;
		Calendar cal = Calendar.getInstance();
		
		//Selection du mois
		while(!androidDriver.findElementById("android:id/date_picker_month").getText().contains((new SimpleDateFormat("MMM", Locale.FRANCE).format(inputDate)).toUpperCase())) {
			tempDate = new SimpleDateFormat("MMM", Locale.FRANCE).parse(androidDriver.findElementById("android:id/date_picker_month").getText());
			cal.setTime(tempDate);
			
			//Scroll dans la bonne direction, selon le mois recherche
			if(Integer.parseInt(inputAsString.substring(3, 5)) < cal.get(Calendar.MONTH)) {
				scrollManager.scroll(calendarZone.getCenter().x, calendarZone.getLocation().y+1, calendarZone.getCenter().x, calendarZone.getLocation().y + calendarZone.getSize().height/2);
			}
			else if(Integer.parseInt(inputAsString.substring(3, 5)) > cal.get(Calendar.MONTH)) {
				scrollManager.scroll(calendarZone.getCenter().x, calendarZone.getLocation().y + calendarZone.getSize().height/2, calendarZone.getCenter().x, calendarZone.getLocation().y+1);
			}
			//On clique le bon jour sur le mois selectionne dans le picker
			Common.sleep(500);
			androidDriver.findElementByXPath("//android.widget.ViewAnimator/android.widget.ListView/android.view.View[1]/android.view.View["+inputAsString.substring(0, 2)+"]").click();	
		}
		
		//click sur OK
		androidDriver.findElementById("button1").click();
	}

	
	/**
	 * Gere l'input sur le widget de selection de date sur les vieilles versions android (< 5).
	 * A noter qu'il faut respecter le format pour la date
	 * @param _we le widget DatePicker Android 7
	 * @param date la date au format "jj/MM/yyyy" - Respecter le format
	 * @throws InterruptedException, ParseException
	 */ 
	private void inputDateAndroidVersion4(String date) throws ParseException, InterruptedException {
		//split jours/mois/annee
		String parts[] = date.split("/");
		
		//identification elements du picker
		//date selectionnee sur le picker
		MobileElement currentDay = androidDriver.findElement(By.xpath("//*[@resource-id = 'android:id/datePicker']//android.widget.NumberPicker[1]/android.widget.EditText"));
		MobileElement currentMonth = androidDriver.findElement(By.xpath("//*[@resource-id = 'android:id/datePicker']//android.widget.NumberPicker[2]/android.widget.EditText"));
		MobileElement currentYear = androidDriver.findElement(By.xpath("//*[@resource-id = 'android:id/datePicker']//android.widget.NumberPicker[3]/android.widget.EditText"));
		
		//selection Jour
		while(!currentDay.getText().equals(parts[0])) {
			if(Integer.parseInt(currentDay.getText()) > Integer.parseInt(parts[0]))
				androidDriver.findElement(By.xpath("//*[@resource-id = 'android:id/datePicker']//android.widget.NumberPicker[1]/android.widget.Button[1]")).click();
			
			else if(Integer.parseInt(currentDay.getText()) < Integer.parseInt(parts[0]))
				androidDriver.findElement(By.xpath("//*[@resource-id = 'android:id/datePicker']//android.widget.NumberPicker[1]/android.widget.Button[2]")).click();	
		}
		
		//selection Mois
		//conversion string => date (pour pouvoir recuperer le mois en lettres (02 => fev.)
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
		Date input = format.parse(date);
		
		// new SimpleDateFormat("MMM", Locale.FRANCE).format(input) <= nom du mois en lettres
		while(!currentMonth.getText().contains(new SimpleDateFormat("MMM", Locale.FRENCH).format(input))) {
			androidDriver.findElement(By.xpath("//*[@resource-id = 'android:id/datePicker']//android.widget.NumberPicker[2]/android.widget.Button[2]")).click();	
		}
		
		//selection Annee
		while(!currentYear.getText().equals(parts[2])) {
			if(Integer.parseInt(currentYear.getText()) > Integer.parseInt(parts[2]))
				androidDriver.findElement(By.xpath("//*[@resource-id = 'android:id/datePicker']//android.widget.NumberPicker[3]/android.widget.Button[1]")).click();
			
			else if(Integer.parseInt(currentYear.getText()) < Integer.parseInt(parts[2]))
				androidDriver.findElement(By.xpath("//*[@resource-id = 'android:id/datePicker']//android.widget.NumberPicker[3]/android.widget.Button[2]")).click();	
		}
		
		//click OK
		androidDriver.findElementById("button1").click();			
	}
	
	
	/**
	 * Gere l'input sur le widget de selection de date Android 6 et +. 
	 * A noter qu'il faut respecter le format pour la date
	 * @param _we le widget DatePicker Android 7
	 * @param date la date au format "jj/MM/yyyy" - Respecter le format
	 * @throws InterruptedException, ParseException
	 */ 
	public void inputDateAndroidVersion6Plus(String date) throws ParseException, InterruptedException {
		//conversion string => date
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
		Date input = format.parse(date);
		
		//selection mois
		selectMonthAndroid6Plus(new SimpleDateFormat("MMM", Locale.FRENCH).format(input));
		
		//selection jour
		int dayToSelect = Integer.parseInt(new SimpleDateFormat("dd").format(input));
		androidDriver.findElementByXPath("//com.android.internal.widget.ViewPager/android.view.View/android.view.View["+ Integer.toString(dayToSelect) +"]").click();
		
		//selection annee
		selectYearAndroid6Plus(Integer.parseInt(new SimpleDateFormat("yyyy").format(input)));
		
		//click OK
		androidDriver.findElementById("android:id/button1").click();
	}
	
	
	//Fonction privee. Selection du mois sur le widget DatePicker Android 6 et plus
	private void selectMonthAndroid6Plus(String monthNameToSelect) {
		String currentSelectedDate = androidDriver.findElementByXPath("//*[@resource-id = 'android:id/date_picker_header_date']").getText(); //recupere la date selectionnee sur le widget
		
		String monthText = currentSelectedDate.split("\\s+")[2]; //recupere le String qui represente le Mois sur la date precedemment recuperee
		
		//On clique sur next pour changer de mois, on clique sur un jour au hasard pour mettre a jour la date selectionnee, on verifie l'egalite sur le mois, on repete
		while(!monthText.equals(monthNameToSelect)) {
			androidDriver.findElement(By.xpath("//*[@resource-id = 'android:id/next']")).click();
			androidDriver.findElementByXPath("//com.android.internal.widget.ViewPager/android.view.View/android.view.View[10]").click();
			currentSelectedDate =  androidDriver.findElementByXPath("//*[@resource-id = 'android:id/date_picker_header_date']").getText();
			monthText = currentSelectedDate.split("\\s+")[2];	
		}
	}
	
	
	//Fonction privee. Selection de l'annee sur le widget DatePicker Android 6 et plus 
	private void selectYearAndroid6Plus(int yearToSelect) throws InterruptedException {
		//Recupere l'annee selectionnee sur le widget
		WebElement currentSelectedYear = androidDriver.findElementByXPath("//*[@resource-id = 'android:id/date_picker_header_year']");
		int selectedYear = Integer.parseInt(currentSelectedYear.getText());
		ScrollManagerAppium scrollManager = new ScrollManagerAppium();
		
		//Va dans la partie selection d'annee du widget
		currentSelectedYear.click();
			
		WebElement yearToBeClicked = null; //element de l'annee recherchee
		
		int firstDateY = (androidDriver.findElementByXPath("(//*[@resource-id = 'android:id/text1'])[1]")).getLocation().y + 20; //mesure de pixel pour scroller juste ce qu'il faut
		int firstDateX = (androidDriver.findElementByXPath("(//*[@resource-id = 'android:id/text1'])[1]")).getLocation().x + 20; //mesure de pixel pour scroller juste ce qu'il faut
		//Cherche la bonne annee, si pas trouvee scroll dans la bonne direction selon qu'il faut aller en haut ou en bas, tant que l'annee n'est pas trouvee
		while (yearToBeClicked == null) {
			if(yearToSelect > selectedYear) 
				scrollManager.scroll(firstDateX, firstDateY+150, firstDateX, firstDateY);
			else if (yearToSelect < selectedYear) 
				scrollManager.scroll(firstDateX, firstDateY, firstDateX, firstDateY+150);
			yearToBeClicked = checkYearPresenceAndroid6Plus(yearToSelect);	
		}
		
		yearToBeClicked.click();
		Common.sleep(2000);
	}
	
	
	//Fonction privee verifie si l'annee recherchee a ete trouvee sur le DatePicker Android 6 et plus
	private MobileElement checkYearPresenceAndroid6Plus(int year) {
		List<MobileElement> elements = (List<MobileElement>) androidDriver.findElements(By.xpath("//*[@resource-id = 'android:id/text1']")); //les Elements d'annee ont tous cet ID sur le DatePicker. On recupere tous ceux affiches
		
		for(int i = 0; i < elements.size(); i++){
			if(Integer.parseInt(elements.get(i).getText()) == year) return elements.get(i); 
		}	
		return null;
	}
}
