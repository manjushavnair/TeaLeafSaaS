package com.ibm.tealeaf.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ErrorCodeReader extends Properties {

	private static ErrorCodeReader errorCodereader;

	public static ErrorCodeReader readProperty() {

	 	if (errorCodereader == null) {
	 		errorCodereader = new ErrorCodeReader();
		}
 
		try {
			InputStream in = new FileInputStream(new File(
					TeaLeafCONSTANTS.EXCEPTIONPATH));
			errorCodereader.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return errorCodereader;
	}

}
