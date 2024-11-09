package com.Epsondoms.PropertyFileLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.Epsondoms.GenericLibrary.FrameworkConstant;


/**
 * This Class Provides the Resuable Method To Read The Data To Property File
 * 
 * 
 * @author Harry
 */
public class ReadPropertyFile implements FrameworkConstant {

	public  FileInputStream fis ;
	public FileOutputStream fos ;
	public Properties property ;

	public String readData(String key) {
		// 1. Convert The Physical File Into Java Readable File
		try {
			fis = new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create An Object For Properties Class
		property = new Properties();

		// 3.Load All the keys/Data
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 4.Fetch The Data
		String data = property.getProperty(key);
		return data;
	}

	public  void writeData(String Key, String value) {
		// 1. Convert The Physical File Into Java Readable File
		try {
			fis = new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create An Object For Properties Class
		property = new Properties();

		// 3.Load All the keys/Data
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 4.Write the Data
		property.put(Key, value);

		// 5.Convert Java Readable into Physical File
		try {
			fos = new FileOutputStream(propertypath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 6.Strore the Data
		try {
			property.store(fos, "Latest Key Updated Sucessful ");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
