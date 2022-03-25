package com.ssafy.happyhouse.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.happyhouse.model.dto.HouseInfo;

/**
 *  AptDealHistory.xml 파일에서 아파트 거래 정보를 읽어 파싱하는 핸들러 클래스 
 */
public class HouseSAXHandler extends DefaultHandler {
	/**
	 * 아파트 거래 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만 
	 * 현재 버전에서는 0번부터 순차 부여한다. 
	 */
	private int no;
	/**아파트 거래 정보를 담는다 */
	private Map<String,HouseInfo> houses;
	/**파상힌 아파트 거래 정보*/
	private HouseInfo house;
	/**태그 바디 정보를 임시로 저장*/
	private String temp;
	private double airCondition;
	public HouseSAXHandler(){
		houses = new HashMap<String,HouseInfo>();
	}
	public void startElement(String uri, String localName
			                           , String qName, Attributes att ){
		if(qName.equals("item")){
			house = new HouseInfo(no++);
		}
	}
	public void endElement(String uri, String localName, String qName){
		if(qName.equals("지역코드")) { 
			house.setCode(Integer.parseInt(temp));
		}else if(qName.equals("아파트")) { 
			house.setAptName(temp.trim());
		}else if(qName.equals("법정동")) { 
			house.setDong(temp.trim());
		}else if(qName.equals("img")) { 
			house.setImg(temp);
		}else if(qName.equals("건축년도")) { 
			house.setBuildYear(Integer.parseInt(temp));
		}else if(qName.equals("지번")) { 
			house.setJibun(temp);
		}else if(qName.equals("item")) {
			houses.put(house.getDong()+house.getAptName(), house);
		}
	}
	public void characters(char[]ch, int start, int length){
		temp = new String(ch, start, length);
	}
	public Map<String,HouseInfo> getHouseInfo() {
		return houses;
	}
}





