package com.ibm.tealeaf.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader extends Properties {

	private static PropertyReader prpreader;

	public static PropertyReader readProperty() {

	 	if (prpreader == null) {
		 	prpreader = new PropertyReader();
		}
 
		try {
			InputStream in = new FileInputStream(new File(
					TeaLeafCONSTANTS.CONFIGPATH));
		 	prpreader.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return prpreader;
	}

}
