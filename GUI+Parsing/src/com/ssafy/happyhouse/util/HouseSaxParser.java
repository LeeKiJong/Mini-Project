package com.ssafy.happyhouse.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HouseInfo;

/**
 * FoodNutritionSAXHandler와 FoodSAXHandler를 이용해서 식품 정보를 load하는 SAX Parser 프로 그램  
 *
 */
public class HouseSaxParser {
	private Map<String, List<HouseDeal>> deals;
	private Map<String, HouseInfo> houseInfo;
	private int size;
	/**
	 * 아파트 거래 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만 
	 * 현재 버전에서는 0번부터 순차 부여한다. 
	 */
	public static int no;
 	public HouseSaxParser() {
		loadData();
	}
 	
 	/**
 	 * HouseSAXHandler를 이용 파싱한 아파트 거래 내역을 추출한다. 
 	 */
	private void loadData() {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		String aptInfoFilePath = "res/AptInfo.xml";
		String aptDealFilePath = "res/AptDealHistory.xml";
		String aptRentFilePath = "res/AptRentHistory.xml";
		String houseDealFilePath = "res/HouseDealHistory.xml";
		String houseRentFilePath = "res/HouseRentHistory.xml";
		
		
		try{
			SAXParser parser = factory.newSAXParser();
			HouseSAXHandler handler = new HouseSAXHandler();
			parser.parse(aptInfoFilePath, handler);
			houseInfo = handler.getHouseInfo();
			
			APTDealSAXHandler  aptDealHandler = new APTDealSAXHandler();
			parser.parse(aptDealFilePath, aptDealHandler);
			List<HouseDeal> aptDeals = aptDealHandler.getHouses();
			
			HouseDealSAXHandler  houseDealHandler = new HouseDealSAXHandler();
			parser.parse(houseDealFilePath, houseDealHandler);
			List<HouseDeal> houseDeals = houseDealHandler.getHouses();
			
			APTRentSAXHandler  aptRentHandler = new APTRentSAXHandler();
			parser.parse(aptRentFilePath, aptRentHandler);
			List<HouseDeal> aptRents = aptRentHandler.getHouses();
			
			HouseRentSAXHandler  houseRentHandler = new HouseRentSAXHandler();
			parser.parse(houseRentFilePath, houseRentHandler);
			List<HouseDeal> houseRents = houseRentHandler.getHouses();
			
			size = aptDeals.size() + houseDeals.size() + aptRents.size() + houseRents.size();
			
			deals = new HashMap<String, List<HouseDeal>>();
			
			double airCondition = 0;
	        File csv = new File("res/AIR_HOUR_2020.csv");
	        String line = "";
	        try(BufferedReader br = new BufferedReader(new FileReader(csv))) {
	            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
	                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
	                if(lineArr[1].equals("101")) {
	                	airCondition = Double.parseDouble(lineArr[3]);
	                	break;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
			deals.put(HouseDeal.APT_DEAL, aptDeals);
			deals.put(HouseDeal.APT_RENT, aptRents);
			deals.put(HouseDeal.HOUSE_DEAL, houseDeals);
			deals.put(HouseDeal.HOUSE_RENT, houseRents);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Map<String, List<HouseDeal>> getDeals() {
		return deals;
	}
	public void setDeals(HashMap<String, List<HouseDeal>> deals) {
		this.deals = deals;
	}
	public Map<String, HouseInfo> getHouseInfo() {
		return houseInfo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setHouseInfo(Map<String, HouseInfo> houseInfo) {
		this.houseInfo = houseInfo;
	}

	public static void main(String[] args) {
		new HouseSaxParser();
	}
}
