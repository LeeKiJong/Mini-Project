package com.ssafy.happyhouse.model.dto;

public class LocationInfo {
	private String name;
	private String type;
	private String gu;
	private String dong;
	private String address;

	public LocationInfo(String name, String type, String gu, String dong, String address) {
		super();
		this.name = name;
		this.type = type;
		this.gu = gu;
		this.dong = dong;
		this.address = address;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "LocationInfo [name=" + name + ", type=" + type + ", gu=" + gu + ", dong=" + dong + ", address="
				+ address + "]";
	}
}
