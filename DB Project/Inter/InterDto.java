package project.Inter;

// DTO : Data Transfer Object
// VO : Value Object

public class InterDto {

	private String Id;
	private String si;
	private String gu;
	private String dong;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getSi() {
		return si;
	}
	public void setSi(String si) {
		this.si = si;
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
	@Override
	public String toString() {
		return "InterDto [Id=" + Id + ", si=" + si + ", gu=" + gu + ", dong=" + dong + "]";
	}
	

	
}
