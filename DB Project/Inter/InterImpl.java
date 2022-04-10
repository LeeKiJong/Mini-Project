package project.Inter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.jdbctest.util.DBClose;
import com.ssafy.jdbctest.util.DBConnection;

public class InterImpl implements InterDao {

	private static InterDao interDao;

	private InterImpl() {}

	public static InterDao getInterDao() {
		if (interDao == null)
			interDao = new InterImpl();
		return interDao;
	}

	@Override
	public void register(InterDto interDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into Interest (id, si, gu, dong)\r\n"
					+ "values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, interDto.getId());
			pstmt.setString(2, interDto.getSi());
			pstmt.setString(3, interDto.getGu());
			pstmt.setString(4, interDto.getDong());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}
	
	@Override
	public void delete(String id, String dong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from Interest where id = ? and dong = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, dong);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public List<InterDto> searchAll() {
		List<InterDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			conn=DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, si, gu, dong \n");
			sql.append("from Interest");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while (rs.next()) {
				InterDto interDto = new InterDto();
				interDto.setId(rs.getString("id"));
				interDto.setSi(rs.getString("si"));
				interDto.setGu(rs.getString("gu"));
				interDto.setDong(rs.getString("dong"));

				list.add(interDto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

}
