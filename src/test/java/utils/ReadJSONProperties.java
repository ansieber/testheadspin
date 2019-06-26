package utils;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;





public class ReadJSONProperties {
	
	protected static JSONObject jsonObject = null;
	
	private static void openJSONFile(String JSONFile)
	{
		JSONParser parser = new JSONParser();
		
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader("src/test/resources/data/" + JSONFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getClassName(Class<?> classOf) {
		String className = classOf.getSimpleName();	

		className = className.substring(className.indexOf('_') + 1, className.length());

		return (className);
	}
	
	/**
	 * @author Peter Xu
	 * 
	 * Retourne un objet du type desire avec les valeurs se trouvant
	 * dans le @param file 
	 * 
	 * @param <T> Le type desire de l'objet 
	 * @param file Le fichier de configuration en JSON
	 * @param classOfT la class de T
	 * @return un objet de type T
	 */
	public static <T> T setClass(Class<?> classToDeduct, Class<T> classOfT) {		
		String JSONData;
		String JSONFile;
		Gson gson = new Gson();
				
		JSONFile = checkFiles(classToDeduct, classOfT);
		System.out.println("File Loaded for [" + classToDeduct.getName() + "] : " + JSONFile);
		openJSONFile(JSONFile);
		JSONData = jsonObject.toString();
		T obj = gson.fromJson(JSONData, classOfT);
		jsonObject.clear();
		return (obj);
	}
	
	public static <T> T setClass(String JSONFile, Class<T> classOfT) {		
		String JSONData;
		Gson gson = new Gson();
				
		System.out.println("File Loaded : " + JSONFile);
		openJSONFile(JSONFile);
		JSONData = jsonObject.toString();
		T obj = gson.fromJson(JSONData, classOfT);
		jsonObject.clear();
		return (obj);
	}

	private static String checkFiles(Class<?> className, Class<?> classNameOfT) {
		File file;

		file = new File("Data/" + className.getSimpleName() + ".json");
		if (file.isFile())
			return (className.getSimpleName() + ".json");
		file = new File("Data/" + getClassName(className) + ".json");
		if (file.isFile())
			return (getClassName(className) + ".json");
		file = new File("Data/" + getClassName(classNameOfT) + ".json");
		if (file.isFile())
			return (getClassName(classNameOfT) + ".json");
		return (null);
	}
	
	public static String getJsonProperty(String JSONFile, String Property){		
		System.out.println("File Loaded : " + JSONFile);
		openJSONFile(JSONFile);
		String propertyValue = (String) jsonObject.get(Property);
		return propertyValue;
	}
}
