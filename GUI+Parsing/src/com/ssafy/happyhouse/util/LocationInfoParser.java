package com.ssafy.happyhouse.util;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.LocationInfo;

public class LocationInfoParser {
	public List<LocationInfo> list = new ArrayList();
	public LocationInfoParser() {
		loadData();
	}

	private void loadData() {
		String path = "res/seoul.csv";
		list = new LocationInfoCSVParser(path).getList();
		System.out.println("size : " + list.size());
	}
	
	public List<LocationInfo> getList(String gu, String dong){
		List<LocationInfo> temp = new ArrayList<>();
		
		for(LocationInfo locationInfo : list) {
			if(locationInfo.getGu().contains(gu) && locationInfo.getDong().contains(dong.substring(0, 3))) {
				temp.add(locationInfo);
			}
		}
		
		return temp;
	}
}
