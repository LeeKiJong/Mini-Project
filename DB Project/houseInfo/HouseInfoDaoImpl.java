package project.houseInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.jdbctest.util.DBConnection;

import project.houseDeal.HouseDealDto;

public class HouseInfoDaoImpl implements HouseInfoDao{
	private static HouseInfoDao houseInfoDao;
	
	private HouseInfoDaoImpl() {}
	
	public static HouseInfoDao getHouseInfoDao() {
		if(houseInfoDao == null) {
			houseInfoDao = new HouseInfoDaoImpl();
		}
		return houseInfoDao;
	}
	
	@Override
	public List<HouseInfoDto> searhByDongName(String dongName) {
		List<HouseInfoDto> list = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select h.aptCode, aptName, dongCode, dongName, dealAmount from houseinfo h join housedeal where dongName like \'%");
			sql.append(dongName);
			sql.append("%\'");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseInfoDto houseInfoDto = new HouseInfoDto();
				houseInfoDto.setAptCode(rs.getLong("aptCode"));
				houseInfoDto.setAptName(rs.getString("aptName"));
				houseInfoDto.setDongName(rs.getString("dongName"));
				houseInfoDto.setDongCode(rs.getString("dongCode"));
				HouseDealDto houseDealDto = new HouseDealDto();
				houseDealDto.setAptCode(rs.getLong("aptCode"));
				houseDealDto.setDealAmount(rs.getString("dealAmount"));
				houseInfoDto.setHouseDealDto(houseDealDto);
				list.add(houseInfoDto);
			}
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			
		}
		return list;
	}

	@Override
	public List<HouseInfoDto> searhByAptName(String aptName) {
		List<HouseInfoDto> list = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select h.aptCode, aptName, dongCode, dongName, dealAmount from houseinfo h join housedeal where aptName like \'%");
			sql.append(aptName);
			sql.append("%\'");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseInfoDto houseInfoDto = new HouseInfoDto();
				houseInfoDto.setAptCode(rs.getLong("aptCode"));
				houseInfoDto.setAptName(rs.getString("aptName"));
				houseInfoDto.setDongName(rs.getString("dongName"));
				houseInfoDto.setDongCode(rs.getString("dongCode"));
				HouseDealDto houseDealDto = new HouseDealDto();
				houseDealDto.setAptCode(rs.getLong("aptCode"));
				houseDealDto.setDealAmount(rs.getString("dealAmount"));
				houseInfoDto.setHouseDealDto(houseDealDto);
				list.add(houseInfoDto);
			}
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			
		}
		return list;
	}

}
