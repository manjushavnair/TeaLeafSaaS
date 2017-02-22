package com.ibm.tealeaf.utils;

/*
//Validate the json
//http://jsonlint.com/
//http://stackoverflow.com/questions/5015844/parsing-json-object-in-java
http://stackoverflow.com/questions/5015844/parsing-json-object-in-java
 

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
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;

public class JSONUtil {

	public static void main(String[] args) throws FileNotFoundException,
			JSONException {
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
		
	

		String name = (String) jsonObject.get("Name");
		String author = (String) jsonObject.get("Author");
	 
		
	 	
	 	List<String> list = new ArrayList<String>();
	 	JSONArray array = jsonObject.getJSONArray("Company List");
	 	for(int i = 0 ; i < array.length() ; i++){
	 	    list.add(array.getString(i));
	 	}
	 
	  	for (int i = 0; i < list.size(); i++) {
			 System.out.println(list.get(i));
		} 

	}
	
	 
}
