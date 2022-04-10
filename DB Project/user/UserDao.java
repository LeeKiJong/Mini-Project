package project.user;

import java.util.List;

public interface UserDao {

	void register(UserDto UserDto);
	void update(String Id, String name, String phone, String email);
	void delete(String Id);
	UserDto searchById(String Id);
	List<UserDto> searchAll();
}
