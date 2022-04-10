package project.houseInfo;

import java.util.List;

public interface HouseInfoDao {
	List<HouseInfoDto> searhByDongName(String dongName);
	List<HouseInfoDto> searhByAptName(String aptName);
}