package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Parameters;

public class ConfigReader {

	
	static Properties prop;
	
	public static Properties initializeProp() {
		
		try {
			prop= new Properties();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream inputProp = new FileInputStream("src/test/resources/config/config.properties");
			prop.load(inputProp);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}



	private static Properties properties;
	private final static String propertyFilePath = "./src/test/resources/config/config.properties";
	private static String browserType = null;
	public static void loadConfig() throws Throwable {

		try {
			FileInputStream fis;
			fis = new FileInputStream(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(fis);

				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	@Parameters("browser")
	public static void setBrowserType(String browser) {
		System.out.println("Setting browser type" + browser);
		browserType = browser;
	}
	
	public static String getUrl() {
		return properties.getProperty("url");
	}

	public static String getBrowserType() throws Throwable {
		if (browserType != null) {
			System.out.println("Setting browser type" + browserType);

			return browserType;
		}
	
		else {
			System.out.println("reading browser from config prop" + browserType);
return properties.getProperty("browser");
		}
	}

}