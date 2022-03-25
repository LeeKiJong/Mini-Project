package com.ssafy.happyhouse.util;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.AirCondition;
import com.ssafy.happyhouse.model.dto.LocationInfo;

public class AirConditionParser {
	public List<AirCondition> list = new ArrayList();
	public AirConditionParser() {
		loadData();
	}

	private void loadData() {
		String path = "res/last_amb_hour_day.csv";
		list = new AirConditionCSVParser(path).getList();
		System.out.println("size : " + list.size());
	}
	
	public List<AirCondition> getList(){
		return list;
	}
}
