package com.ssafy.happyhouse;

public class HappyHouseException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public HappyHouseException() {
		super("데이타를 처리 중 오류 발생");
	}
	public HappyHouseException(String msg) {
		super(msg);
	}
	
}
