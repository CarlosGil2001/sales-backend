package com.company.sales.response;

import java.util.ArrayList;

import java.util.HashMap;
//Response to the service
public class ResponseRest {
	
	private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

	//Metadata methods
	public ArrayList<HashMap<String, String>> getMetadata() {
		return metadata;
	}

	public void setMetadata(String type, String code, String date) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("type", type);
		map.put("code", code);
		map.put("date", date);
		
		metadata.add(map);
	}
	
	
	
}
