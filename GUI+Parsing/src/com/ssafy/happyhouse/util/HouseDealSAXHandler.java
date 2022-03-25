package com.ssafy.happyhouse.util;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.happyhouse.model.dto.HouseDeal;

/**
 *  HouseDealHistory.xml 파일에서 주택 거래 정보를 읽어 파싱하는 핸들러 클래스 
 */
public class HouseDealSAXHandler extends DefaultHandler {
	private String temp;
	private HouseDeal current;
	private List<HouseDeal> houses = new ArrayList<>();
	// complete code #08
	// APTDealSAXHandler Class 를 참조하여, 주택 거래 정보에 맞도록 전체 코드를 작성하세요. 단, 아래 코드를 이용하여 완성하세요.
	public void startElement(String uri, String localName, String qName, Attributes att ){
		if(qName.equals("item")) {
			current = new HouseDeal(HouseSaxParser.no++);
			current.setType(HouseDeal.HOUSE_DEAL);
		}
	}
	public void endElement(String uri, String localName, String qName){
		if(qName.equals("item")) {
			houses.add(current);
			current = null;
		}
		else if(qName.equals("지역코드")) { 
			current.setCode(Integer.parseInt(temp));
		}else if(qName.equals("연립다세대")) { 
			current.setAptName(temp.trim());
		}else if(qName.equals("법정동")) { 
			current.setDong(temp.trim());
		}else if(qName.equals("거래금액")) { 
			current.setDealAmount(temp);
		}else if(qName.equals("건축년도")) { 
			current.setBuildYear(Integer.parseInt(temp));
		}else if(qName.equals("년")) { 
			current.setDealYear(Integer.parseInt(temp));
		}else if(qName.equals("월")) { 
			current.setDealMonth(Integer.parseInt(temp));
		}else if(qName.equals("일")) { 
			current.setDealDay(Integer.parseInt(temp));
		}else if(qName.equals("전용면적")) { 
			current.setArea(Double.parseDouble(temp));
		}else if(qName.equals("지번")) { 
			current.setJibun(temp);
		}else if(qName.equals("층")) { 
			current.setFloor(Integer.parseInt(temp));
		}
	}
	public void characters(char[]ch, int start, int length){
		this.temp = String.valueOf(ch, start, length);
	}
	public List<HouseDeal> getHouses() { return houses; }
	public void setHouses(List<HouseDeal> houses) {
		this.houses = houses;
	}
}
