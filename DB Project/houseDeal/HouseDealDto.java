package project.houseDeal;

public class HouseDealDto {
//	private Long no;
	private Long aptCode;
	private String dealAmount;
//	private int dealYear;
//	private int dealMonth;
//	private int dealDay;
//	private double area;
//	private int floor;
//	private int type;
//	private int rentMoney;
	public Long getAptCode() {
		return aptCode;
	}
	public void setAptCode(Long aptCode) {
		this.aptCode = aptCode;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	@Override
	public String toString() {
		return "dealAmount=" + dealAmount;
	}
	
	

	
}
