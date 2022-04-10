package project.Inter;

import java.util.List;

public interface InterDao {

	void register(InterDto interDto);

	void delete(String id, String dong);


	List<InterDto> searchAll();
}
