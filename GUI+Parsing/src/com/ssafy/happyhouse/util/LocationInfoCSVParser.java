package com.ssafy.happyhouse.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.LocationInfo;

public class LocationInfoCSVParser {
	private List<LocationInfo> list = new ArrayList<>();
	
	public LocationInfoCSVParser(String path) {
		 File csv = new File(path);
	        String line = "";
	        try(BufferedReader br = new BufferedReader(new FileReader(csv))) {
	            while ((line = br.readLine()) != null) { 
	                String[] lineArr = line.split(","); 
	                LocationInfo temp = new LocationInfo(lineArr[1], lineArr[6], lineArr[14], lineArr[16] ,lineArr[24]);
	                if(temp.getGu().contains("종로구")) {
	                	list.add(temp);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	}

	public List<LocationInfo> getList(){
		return list;
	}
	
}
