 	package com.ibm.tealeaf.utils;

/*
//Validate the json
//http://jsonlint.com/
//http://stackoverflow.com/questions/5015844/parsing-json-object-in-java

 

 {
 "Name": "testingnames",
 "Author": "App Shah",
 "Company List": [
 "Company: eBay",
 "Company: Paypal",
 "Company: Google"
 ]
 }

 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.sourceforge.htmlunit.corejs.javascript.json.JsonParser.ParseException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;

public class JSONUtil {

	public static void main(String[] args) throws FileNotFoundException,
			JSONException,Exception {
		String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(
					TeaLeafCONSTANTS.LOGINJSONDATAPATH));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		JSONObject jsonObject = new JSONObject(jsonData);
		
	
		   parseJson(jsonObject);
		 

	}
	
	public static void getArray(Object object2) throws  Exception {

	    JSONArray jsonArr = (JSONArray) object2;

	    for (int k = 0; k < jsonArr.length() ; k++) {

	        if (jsonArr.get(k) instanceof JSONObject) {
	         
	            parseJson((JSONObject) jsonArr.get(k));
	            System.out.println(2);
	        } else {
	     
	            System.out.println(jsonArr.get(k)+ "1");
	        }

	    }
	}
	
	public static void parseJson(JSONObject jsonObject) throws  Exception {

	    Set<String> set = jsonObject.keySet();
	    Iterator<String> iterator = set.iterator();
	    while (iterator.hasNext()) {
	        String obj = iterator.next();
	        if (jsonObject.get(obj) instanceof JSONArray) {
	            System.out.println(obj.toString() + "2");
	            
	            getArray(jsonObject.get(obj));
	        } else {
	            if (jsonObject.get(obj) instanceof JSONObject) {
	                parseJson((JSONObject) jsonObject.get(obj));
	            } else {
	            	 
	                System.out.println(obj.toString() + "\t 4"
	                        + jsonObject.get(obj));
	            }
	        }
	    }
	}
	
	 
}
