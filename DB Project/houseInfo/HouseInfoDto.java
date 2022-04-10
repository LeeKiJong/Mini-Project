package project.houseInfo;

import project.houseDeal.HouseDealDto;

public class HouseInfoDto {
	private Long aptCode;
	private String aptName;
	private String dongCode;
	private String dongName;
//	private int buildYear;
//	private String jibun;
//	private double lat;
//	private double lng;
//	private String img;
	
	private HouseDealDto houseDealDto;

	public Long getAptCode() {
		return aptCode;
	}

	public void setAptCode(Long aptCode) {
		this.aptCode = aptCode;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public HouseDealDto getHouseDealDto() {
		return houseDealDto;
	}

	public void setHouseDealDto(HouseDealDto houseDealDto) {
		this.houseDealDto = houseDealDto;
	}

	@Override
	public String toString() {
		return "[aptCode=" + aptCode + ", aptName=" + aptName + ", dongCode=" + dongCode + ", dongName="
				+ dongName + ", " + houseDealDto + "]";
	}
	
	
	
}
