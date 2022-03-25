package com.ssafy.happyhouse.util;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.happyhouse.model.dto.HouseDeal;

/**
 *  HouseRentHistory.xml 파일에서 주택 전월세 정보를 읽어 파싱하는 핸들러 클래스 
 */
public class HouseRentSAXHandler extends DefaultHandler {
	/**아파트 거래 정보를 담는다 */
	private List<HouseDeal> houses;
	/**파상힌 아파트 거래 정보*/
	private HouseDeal house;
	/**태그 바디 정보를 임시로 저장*/
	private String temp;
	public HouseRentSAXHandler(){
		houses = new LinkedList<HouseDeal>();
	}
	public void startElement(String uri, String localName
			                           , String qName, Attributes att ){
		if(qName.equals("item")){
			house = new HouseDeal(HouseSaxParser.no++);
			house.setType(HouseDeal.HOUSE_RENT);
			houses.add(house);
		}
	}
	public void endElement(String uri, String localName, String qName){
		if(qName.equals("지역코드")) { 
			house.setCode(Integer.parseInt(temp));
		}else if(qName.equals("연립다세대")) { 
			house.setAptName(temp.trim());
		}else if(qName.equals("법정동")) { 
			house.setDong(temp.trim());
		}else if(qName.equals("보증금액")) { 
			house.setDealAmount(temp);
		}else if(qName.equals("월세금액")) { 
			house.setRentMoney(temp);
		}else if(qName.equals("건축년도")) { 
			house.setBuildYear(Integer.parseInt(temp));
		}else if(qName.equals("년")) { 
			house.setDealYear(Integer.parseInt(temp));
		}else if(qName.equals("월")) { 
			house.setDealMonth(Integer.parseInt(temp));
		}else if(qName.equals("일")) { 
			house.setDealDay(Integer.parseInt(temp));
		}else if(qName.equals("전용면적")) { 
			house.setArea(Double.parseDouble(temp));
		}else if(qName.equals("지번")) { 
			house.setJibun(temp);
		}else if(qName.equals("층")) { 
			house.setFloor(Integer.parseInt(temp));
		}
	}
	public void characters(char[]ch, int start, int length){
		temp = new String(ch, start, length);
	}
	public List<HouseDeal> getHouses() {
		return houses;
	}
	public void setHouses(List<HouseDeal> houses) {
		this.houses = houses;
	}
}





