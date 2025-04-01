package Z_DDTPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DDTbyProperties {

		public static void main(String[] args) throws IOException {
			FileInputStream file=new FileInputStream("‪‪‪‪C:\\Users\\Manga\\eclipse-workspace\\BasicSelenium\\src\\test\\resources\\CommonData.properties");
			Properties prop=new Properties();
			prop.load(file);
			
			String BROWSER = prop.getProperty("browser");
			String URL = prop.getProperty("url");	
			String UNAME= prop.getProperty("uname");
			String PWD = prop.getProperty("Password");
			System.out.println(BROWSER);
			System.out.println(URL);
			System.out.println(UNAME);
			System.out.println(PWD);}
	}


