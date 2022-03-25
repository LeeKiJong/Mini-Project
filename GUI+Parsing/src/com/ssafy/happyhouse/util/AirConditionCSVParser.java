package com.ssafy.happyhouse.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.spi.DateFormatSymbolsProvider;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.AirCondition;
import com.ssafy.happyhouse.model.dto.LocationInfo;

public class AirConditionCSVParser {
	private List<AirCondition> list = new ArrayList<>();
	
	public AirConditionCSVParser(String path) {
		 File csv = new File(path);
	        String line = "";
	        try(BufferedReader br = new BufferedReader(new FileReader(csv))) {
	            while ((line = br.readLine()) != null) {
	            	 AirCondition temp = null;
	            	try {
	                String[] lineArr = line.split(",");
	    
	                 temp = new AirCondition(lineArr[0].replaceAll("\"", ""),
	                		Integer.parseInt(lineArr[1].replaceAll("\"", "")), 
	                		Integer.parseInt(lineArr[2].replaceAll("\"", "")), 
	                		Double.parseDouble(lineArr[3].replaceAll("\"", "")) ,
	                		Double.parseDouble(lineArr[4].replaceAll("\"", "")) ,
	                		Double.parseDouble(lineArr[5].replaceAll("\"", "")) ,
	                		Double.parseDouble(lineArr[6].replaceAll("\"", "")));
		                list.add(temp);
	            	} catch(NumberFormatException e) {
	    	        	//e.printStackTrace();
	    	        } catch(ArrayIndexOutOfBoundsException e) {
	    	        	
	    	        }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	public List<AirCondition> getList(){
		return list;
	}
}
