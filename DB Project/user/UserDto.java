package project.user;

// DTO : Data Transfer Object
// VO : Value Object

public class UserDto {

	private String Id;
	private String Name;
	private String email;
	private String phone;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Id=" + Id + ", Name=" + Name + ", phone=" + phone + ", email=" + email;
	}

	
}
