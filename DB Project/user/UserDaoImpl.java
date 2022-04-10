package project.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.jdbctest.util.DBClose;
import com.ssafy.jdbctest.util.DBConnection;

public class UserDaoImpl implements UserDao {

	private static UserDao productDao;

	private UserDaoImpl() {}

	public static UserDao getUserDao() {
		if (productDao == null)
			productDao = new UserDaoImpl();
		return productDao;
	}

	@Override
	public void register(UserDto userDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into users (id, name, phone, email)\r\n"
					+ "values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getName());
			pstmt.setString(3, userDto.getPhone());
			pstmt.setString(4, userDto.getEmail());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}
	
	@Override
	public void update(String id, String name, String phone, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "update users ";
			sql += "set name = ? ,";
			sql += "phone = ? ,";
			sql += "email = ? ";
			sql += "where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			pstmt.setString(4, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void delete(String Id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from users where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public UserDto searchById(String Id) {
		
		UserDto productDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select id, name, phone, email \n";
			sql += "from users \n";
			sql += "where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				productDto = new UserDto();
				productDto.setId(rs.getString("id"));
				productDto.setName(rs.getString("name"));
				productDto.setPhone(rs.getString("phone"));
				productDto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return productDto;
	}

	@Override
	public List<UserDto> searchAll() {
		List<UserDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			conn=DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, phone, email \n");
			sql.append("from users");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while (rs.next()) {
				UserDto productDto = new UserDto();
				productDto.setId(rs.getString("id"));
				productDto.setName(rs.getString("name"));
				productDto.setPhone(rs.getString("phone"));
				productDto.setEmail(rs.getString("email"));

				list.add(productDto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

}
