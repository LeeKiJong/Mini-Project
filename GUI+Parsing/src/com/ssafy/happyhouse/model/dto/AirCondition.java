package com.ssafy.happyhouse.model.dto;

public class AirCondition {
	private String date;
	private int dust;
	private int nanoDust;
	private double ozone;
	private double NO2;
	private double CO;
	private double SO2;
	
	public AirCondition(String date, int dust, int nanoDust, double ozone, double nO2, double cO, double sO2) {
		super();
		this.date = date;
		this.dust = dust;
		this.nanoDust = nanoDust;
		this.ozone = ozone;
		NO2 = nO2;
		CO = cO;
		SO2 = sO2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDust() {
		return dust;
	}

	public void setDust(int dust) {
		this.dust = dust;
	}

	public int getNanoDust() {
		return nanoDust;
	}

	public void setNanoDust(int nanoDust) {
		this.nanoDust = nanoDust;
	}

	public double getOzone() {
		return ozone;
	}

	public void setOzone(double ozone) {
		this.ozone = ozone;
	}

	public double getNO2() {
		return NO2;
	}

	public void setNO2(double nO2) {
		NO2 = nO2;
	}

	public double getCO() {
		return CO;
	}

	public void setCO(double cO) {
		CO = cO;
	}

	public double getSO2() {
		return SO2;
	}

	public void setSO2(double sO2) {
		SO2 = sO2;
	}

	@Override
	public String toString() {
		return "AirCondition [date=" + date + ", dust=" + dust + ", nanoDust=" + nanoDust + ", ozone=" + ozone
				+ ", NO2=" + NO2 + ", CO=" + CO + ", SO2=" + SO2 + "]";
	}
	
}
