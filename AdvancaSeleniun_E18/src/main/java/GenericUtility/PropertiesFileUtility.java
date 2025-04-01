package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {

	public String readingDataFromPropFile(String Key) throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Manga\\eclipse-workspace\\AdvancaSeleniun_E18\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data = prop.getProperty(Key);
		return data;
	}
		
	}

