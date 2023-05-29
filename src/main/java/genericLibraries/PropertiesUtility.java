package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	private Properties property;
	
	public void readDataFromProperties(String filePath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		}catch(FileNotFoundException e) {
			e.printStackTrace();	  
		}
		property = new Properties();
		try {
			property.load(fis);
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public String readDataFromProperties(String key) {
		return property.getProperty(key);
		
	}

	/**
	 * this method is used to write data to properties file
	 * @param key
	 * @param value
	 * @param file path
	 * @param comments
	 */
	public void writeToProperties(String key, String value, String filePath, String comments ) {
		property.put(key, value);
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			property.store(fos, comments);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
